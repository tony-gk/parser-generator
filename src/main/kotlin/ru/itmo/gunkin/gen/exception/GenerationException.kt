package ru.itmo.gunkin.gen.exception

class GenerationException(msg: String) : Exception(msg)

fun ensure(value: Boolean, lazyMessage: () -> String) {
    if (!value) {
        throw GenerationException(lazyMessage())
    }
}

