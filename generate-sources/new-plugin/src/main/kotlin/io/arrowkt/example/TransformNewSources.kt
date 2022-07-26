package io.arrowkt.example

import arrow.meta.CliPlugin
import arrow.meta.Meta
import arrow.meta.invoke
//import arrow.meta.quotes.Transform
//import arrow.meta.quotes.classDeclaration

/*
  The base directory for the generated files is provided in the build.gradle file
  of the module that is using the plugin ('use-plugin' module):

  compileKotlin {
    kotlinOptions {
      ...
      freeCompilerArgs = [ ...
        "-P", "plugin:arrow.meta.plugin.compiler:generatedSrcOutputDir=${buildDir}"]
    }
  }

  If base directory is not provided, it will be "build" directory in the Gradle daemon workspace.
 */
/* TODO 58: rewrite
val Meta.transformNewSources: CliPlugin
  get() = "Transform New Multiple Source" {
    meta(
      classDeclaration(this, { element.name == "NewMultipleSource" }) {
        Transform.newSources(
          """
          |package arrow
          |         
          |class ${name}_Generated
          """.trimMargin().file("${name}_Generated"), // default path: generated/source/kapt/main
          """
          |package arrow
          |
          |class ${name}_Generated_2
          """.trimMargin().file("${name}_Generated_2", "generated/custom/directory")
        )
      }
    )
  }
 */
