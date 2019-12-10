package io.arrowkt.example

import kotlin.reflect.KProperty

//metadebug

class IO<A>(val value: A) {
  operator fun getValue(value: Any?, property: KProperty<*>): A = TODO()
  fun <B> flatMap(f: (A) -> IO<B>): IO<B> =
    f(value)

  companion object {
    fun <A> fx(f: IO.Companion.() -> A): IO<A> = TODO()
    fun <A> just(a: A): IO<A> = IO(a)
  }
}

fun test(): IO<Int> =
  IO.fx {
    val a: Int by IO(1)
    val b: Int by IO(2)
    a + b
  }
