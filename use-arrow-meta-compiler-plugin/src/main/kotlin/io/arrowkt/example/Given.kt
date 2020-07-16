// TODO: It doesn't support a composite package
package singlepackage

import arrow.*

fun <A> given(evidence: @Given A = arrow.given): A = evidence
@Given val x = "yes!"
val result = given<String>()
