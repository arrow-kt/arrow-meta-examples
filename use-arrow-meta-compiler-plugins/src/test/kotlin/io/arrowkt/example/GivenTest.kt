// TODO: It doesn't support a composite package
package singlepackage

import org.junit.jupiter.api.Test
import org.assertj.core.api.Assertions.assertThat

class GivenTest {

    @Test
    fun `coherent polymorphic identity`() {
        assertThat(result).isEqualTo("yes!")
    }
}
