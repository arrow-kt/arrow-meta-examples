package io.arrowkt.example.inline_serialization.plugin

import kotlinx.serialization.PrimitiveKind

val allPrimitiveKinds = mapOf(
    "BOOLEAN" to PrimitiveKind.BOOLEAN,
    "BYTE" to PrimitiveKind.BYTE,
    "CHAR" to PrimitiveKind.CHAR,
    "DOUBLE" to PrimitiveKind.DOUBLE,
    "FLOAT" to PrimitiveKind.FLOAT,
    "INT" to PrimitiveKind.INT,
    "LONG" to PrimitiveKind.LONG,
    "SHORT" to PrimitiveKind.SHORT,
    "STRING" to PrimitiveKind.STRING
)

val Map<String, PrimitiveKind>.allTypeNames get() =
    keys.joinToString { it.toLowerCase().capitalize() }
