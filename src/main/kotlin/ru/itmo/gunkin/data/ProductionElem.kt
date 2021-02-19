package ru.itmo.gunkin.data

sealed class ProductionElem(val name: String) {
    class Token(name: String) : ProductionElem(name)
    class Rule(name: String, val inheritedAttr : String?) : ProductionElem(name)
}