// TODO: It doesn't support a composite package
package singlepackage

import arrow.Given

fun <A> given(evidence: @Given A = arrow.given): A = evidence

@Given
internal val x: String = "yes!"

val result = given<String>()
