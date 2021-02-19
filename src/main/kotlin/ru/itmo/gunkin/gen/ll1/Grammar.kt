package ru.itmo.gunkin.gen.ll1

import ru.itmo.gunkin.data.ProductionElem
import ru.itmo.gunkin.data.RuleProduction


class Grammar(
    private val rules: Map<String, List<RuleProduction>>,
    tokens: Set<String>,
    startRule: String,
) {
    companion object {
        const val EPS = ""
        const val END = "$"
    }

    private val first: Map<String, Set<String>>
    private val follow: Map<String, Set<String>>

    // First set construction
    init {
        first = mutableMapOf<String, MutableSet<String>>()
        for (ruleName in rules.keys) {
            first[ruleName] = mutableSetOf()
        }
        for (tokName in tokens) {
            first[tokName] = mutableSetOf(tokName)
        }

        var changed = true
        while (changed) {
            changed = false
            for ((ruleName, prods) in rules) {
                for (prod in prods) {
                    val prodFirstSet = getFirstOfSeq(prod.elements, first)
                    changed = changed ||
                            first.getValue(ruleName).addAll(prodFirstSet)
                }
            }
        }
    }

    // Follow set construction
    init {
        follow = mutableMapOf<String, MutableSet<String>>()
        for (ruleName in rules.keys) {
            follow[ruleName] = mutableSetOf()
        }
        follow.getValue(startRule).add(END)

        var changed = true
        while (changed) {
            changed = false
            for ((ruleName, prods) in rules) {
                for (production in prods) {
                    val prodElems = production.elements
                    if (prodElems.isEmpty()) continue
                    for (i in 1 until prodElems.size) {
                        val prev = prodElems[i - 1]
                        val cur = prodElems[i]
                        if (prev is ProductionElem.Rule) {
                            changed = changed ||
                                    follow.getValue(prev.name).addAll(first.getValue(cur.name))
                        }
                    }

                    for (i in prodElems.size - 1 downTo 1) {
                        val prev = prodElems[i - 1]
                        val cur = prodElems[i]
                        if (EPS !in first.getValue(cur.name)) break
                        if (prev is ProductionElem.Rule) {
                            changed = changed ||
                                    follow.getValue(prev.name).addAll(follow.getValue(ruleName))
                        }
                    }

                    val last = prodElems.last()
                    if (last is ProductionElem.Rule) {
                        changed = changed ||
                                follow.getValue(last.name).addAll(follow.getValue(ruleName))
                    }
                }
            }
        }

        follow.values.forEach { it.remove(EPS) }
    }

    fun getFirst(elemName: String) = first.getValue(elemName)

    fun getFirstOfSeq(seq: List<ProductionElem>): Set<String> {
        return getFirstOfSeq(seq, first)
    }

    private fun getFirstOfSeq(seq: List<ProductionElem>, first: Map<String, Set<String>>): Set<String> {
        val res = mutableSetOf<String>()
        for (prodElem in seq) {
            val elemSet = first.getValue(prodElem.name)
            res.addAll(elemSet)
            if (Companion.EPS in elemSet) {
                res.remove(Companion.EPS)
            } else {
                return res
            }
        }
        res.add(Companion.EPS)
        return res
    }

    fun getFollow(ruleName: String) = follow.getValue(ruleName)

    fun checkLL1(): Boolean {
        for ((ruleName, prods) in rules) {
            for (i in prods.indices) {
                for (j in prods.indices) {
                    if (i == j) continue
                    val iFirst = getFirstOfSeq(prods[i].elements)
                    val jFirst = getFirstOfSeq(prods[j].elements)

                    if (iFirst.any { it in jFirst }) return false

                    if (Companion.EPS in iFirst &&
                        getFollow(ruleName).any { it in jFirst }
                    ) return false
                }
            }
        }
        return true
    }
}