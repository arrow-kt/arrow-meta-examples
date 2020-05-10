package io.arrowkt.example

import org.hamcrest.MatcherAssert.assertThat
import org.hamcrest.core.IsEqual.equalTo
import org.junit.Test
import java.io.ByteArrayOutputStream
import java.io.PrintStream

class HelloWorldTest {
  @Test
  fun `greets ΛRROW Meta`() {
      val out = ByteArrayOutputStream()
      System.setOut(PrintStream(out))
      helloWorld()
      assertThat(out.toString(), equalTo("Hello ΛRROW Meta!\n"))
  }
}