package io.arrowkt.example.inline_serialization.plugin

import kotlin.contracts.ExperimentalContracts

import arrow.meta.CliPlugin
import arrow.meta.Meta
import arrow.meta.phases.CompilerContext

class MetaPlugin : Meta {
    @ExperimentalContracts
    override fun intercept(ctx: CompilerContext): List<CliPlugin> =
        listOf(
            inlineSerialization
        )
}
