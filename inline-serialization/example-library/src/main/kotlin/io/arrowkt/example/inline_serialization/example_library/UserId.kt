package io.arrowkt.example.inline_serialization.example_library

import io.arrowkt.example.inline_serialization.inline_serialization.InlineSerializable

@InlineSerializable
data class UserId(val value : String) {
    companion object {
        fun unique() =
            UserId(java.util.UUID.randomUUID().toString())
    }

    override fun toString(): String = "UserId($value)"
}
