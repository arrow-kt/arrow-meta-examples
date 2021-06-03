package io.arrowkt.example

import arrow.core.Either
import arrow.core.left
import arrow.core.right
import arrow.refinement.Refined
import arrow.refinement.numbers.PositiveInt
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.json.Json


fun main() {
    kotlinSerialization()
    useDynamicValueWithMap()
    useDynamicValue()
}

// Should throw IllegalArgumentException
fun kotlinSerialization() {
    val json = """{"gameId":"","color":"white"}"""
    println(Json.decodeFromString<Game>(json))
    // output: Game(gameId=GameId(value=), color=white)
}

fun f(n: Int) =
    PositiveInt(n)

// this should not be compiled
fun useDynamicValue() {
    val z = f(-1)
    println(z)
    // Output
    // Exception in thread "main" java.lang.IllegalArgumentException: -1 should be > 0
    //	at se.thanh.refined.MainKt.f(Main.kt:52)
    //	at se.thanh.refined.MainKt.useDynamicValue(Main.kt:28)
    //	at se.thanh.refined.MainKt.main(Main.kt:14)
    //	at se.thanh.refined.MainKt.main(Main.kt)
}

// this should not be compiled
fun useDynamicValueWithMap() {
    val xs = listOf(1, 2)
    val zs = xs.map { PositiveInt(it) }
    println(zs)
    // Output: [PositiveInt(value=1), PositiveInt(value=2)]
}

fun <A, B> Refined<A, B>.validate(a: A): Either<List<String>, B> =
    fold(a, { it.map { it.second }.left() }, { it.right() })

