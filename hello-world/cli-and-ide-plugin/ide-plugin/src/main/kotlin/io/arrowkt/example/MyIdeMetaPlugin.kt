package io.arrowkt.example

import arrow.meta.CliPlugin
import arrow.meta.ide.IdeMetaPlugin
import arrow.meta.ide.IdePlugin
import arrow.meta.ide.phases.IdeContext
import arrow.meta.phases.CompilerContext
import io.arrowkt.example.plugins.helloWorld
import kotlin.contracts.ExperimentalContracts

@ExperimentalContracts
class MyIdeMetaPlugin : IdeMetaPlugin() {
  @ExperimentalContracts
  override fun intercept(ctx: CompilerContext): List<CliPlugin> =
    cliPlugins

  @ExperimentalContracts
  override fun intercept(ctx: IdeContext): List<IdePlugin> =
    listOf(
      helloWorld
    )
}
