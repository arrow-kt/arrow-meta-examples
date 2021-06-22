package io.arrowkt.example.inline_serialization.example_application

import kotlinx.serialization.json.Json
import kotlinx.serialization.json.JsonConfiguration

import io.arrowkt.example.inline_serialization.example_library.ChannelCount
import io.arrowkt.example.inline_serialization.example_library.UserId

fun main(args : Array<String>) {
  val stereo = ChannelCount(2)
  val mono = ChannelCount(1)
  val tri = stereo + mono

  println(tri)

  val userId1 = UserId.unique()

  println(userId1)

  val sampleRate = SampleRateHz(44100)

  println(sampleRate)

  val info = Info(stereo, sampleRate)

  println(info)

  val json = Json(JsonConfiguration.Stable)

  println(json.stringify(ChannelCount.serializer(), tri))
  println(json.stringify(SampleRateHz.serializer(), sampleRate))
  println(json.stringify(Info.serializer(), info))
}
