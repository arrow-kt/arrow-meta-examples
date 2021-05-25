package io.arrowkt.example

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.assertThrows

class PositiveIntTest {

    @Test
    fun `throws an exception during runtime`() {
        assertThrows(
          ExceptionInInitializerError::class.java
        ) { println(result) }
    }
}
