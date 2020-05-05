package io.arrowkt.example.inline_serialization.example_application

import kotlinx.serialization.Serializable

import io.arrowkt.example.inline_serialization.example_library.ChannelCount

@Serializable
data class Info(
        val channelCount: ChannelCount,
        val sampleRate: SampleRateHz
)
