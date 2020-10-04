package io.arrowkt.example

import java.io.ByteArrayOutputStream
import java.io.PrintStream
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions;

class HelloWorldTest {
  @Test
  fun `greets ΛRROW Meta`() {
      val out = ByteArrayOutputStream()
      System.setOut(PrintStream(out))
      helloWorld()
      Assertions.assertEquals(out.toString(), "Hello ΛRROW Meta!\n")
  }
}