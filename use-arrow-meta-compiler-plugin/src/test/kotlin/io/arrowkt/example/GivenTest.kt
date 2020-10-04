// TODO: It doesn't support a composite package
package singlepackage

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions;

class GivenTest {

    @Test
    fun `coherent polymorphic identity`() {
        Assertions.assertTrue(result == "yes!")
    }
}
