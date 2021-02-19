package ru.itmo.gunkin.runtime

data class Token<T>(
    val type: T,
    val text: String,
    val pos: Int
)