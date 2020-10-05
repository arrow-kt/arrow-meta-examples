package io.arrowkt.example

import java.io.ByteArrayOutputStream
import java.io.PrintStream
import org.junit.jupiter.api.Test
import org.assertj.core.api.Assertions.assertThat

class HelloWorldTest {
  @Test
  fun `greets ΛRROW Meta`() {
      val out = ByteArrayOutputStream()
      System.setOut(PrintStream(out))
      helloWorld()
      assertThat(out.toString()).isEqualTo("Hello ΛRROW Meta!\n")
  }
}