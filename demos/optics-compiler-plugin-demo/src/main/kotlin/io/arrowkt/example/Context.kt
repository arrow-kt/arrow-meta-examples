package io.arrowkt.example

import arrow.Optics
import arrow.optics.*

//metadebug

@Optics
data class LensData(
  val field1: String
) {
  companion object
}

val i: Lens<LensData, String> = LensData.field1
val result = i != null