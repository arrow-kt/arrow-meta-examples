package io.arrowkt.example

import org.junit.Assert.assertEquals
import org.junit.Test

class ComprehensionsTest {
  @Test
  fun `checks the result of test function`() {
      assertEquals(test().value, 3)
  }
}
