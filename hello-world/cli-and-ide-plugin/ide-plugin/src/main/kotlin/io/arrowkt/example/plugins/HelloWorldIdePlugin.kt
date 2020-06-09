package io.arrowkt.example.plugins

import arrow.meta.ide.IdePlugin
import arrow.meta.ide.invoke
import arrow.meta.ide.resources.ArrowIcons
import arrow.meta.phases.ExtensionPhase
import io.arrowkt.example.MyIdeMetaPlugin
import org.jetbrains.kotlin.idea.caches.resolve.resolveToDescriptorIfAny
import org.jetbrains.kotlin.idea.util.hasInlineModifier
import org.jetbrains.kotlin.psi.KtClass
import org.jetbrains.kotlin.psi.KtNamedFunction
import org.jetbrains.kotlin.utils.addToStdlib.safeAs
import kotlin.contracts.ExperimentalContracts

@ExperimentalContracts
val MyIdeMetaPlugin.helloWorld: IdePlugin
  get() = "Hello world LineMarker" {
    meta(
      registerMetaPlugin(),
      addLineMarkerProvider(
        icon = ArrowIcons.ICON1,
        composite = KtNamedFunction::class.java,
        message = { f ->
          HTML.renderMessage("Teach your users about this function: ") + "<br/>" +
            f.resolveToDescriptorIfAny()?.let(HTML::render)
        },
        transform = {
          it.safeAs<KtNamedFunction>()?.takeIf { f ->
            f.name == "helloWorld"
          }
        }
      )
    )
  }