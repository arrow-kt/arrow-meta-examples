package plugins

import arrow.meta.ide.IdeMetaPlugin
import arrow.meta.ide.IdePlugin
import arrow.meta.ide.invoke
import arrow.meta.ide.phases.IdeContext
import arrow.meta.phases.ExtensionPhase
import kotlin.contracts.ExperimentalContracts

@ExperimentalContracts
class HelloWorld : IdeMetaPlugin() {
  @ExperimentalContracts
  override fun intercept(ctx: IdeContext): List<IdePlugin> =
    super.intercept(ctx) + empty
}

@ExperimentalContracts
val HelloWorld.empty: IdePlugin
  get() = "Empty Plugin" {
    meta(
        ExtensionPhase.Empty
    )
  }