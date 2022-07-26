package io.arrowkt.example

class AnnotatedFunctionInjection {

    @MetaLog
    fun doStuff(input: Int): Int {
        return input * 2
    }
}

fun main() {
    // Assert logging is invoked
    val testInstance = AnnotatedFunctionInjection()
    val result = testInstance.doStuff(5)
    println("result: $result")
}