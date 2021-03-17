# Λrrow Meta examples

[![Build](https://github.com/arrow-kt/arrow-meta-examples/workflows/Build/badge.svg)](https://github.com/arrow-kt/arrow-meta-examples/actions?query=workflow%3ABuild)

Some examples for [Λrrow Meta](https://github.com/arrow-kt/arrow-meta/) the functional companion to Kotlin's Compiler & IDE.

## Hello World Compiler Plugin

![Hello World Compiler Plugin Demo](https://github.com/arrow-kt/arrow-meta/raw/master/docs/docs/img/demos/hello-world-compiler-plugin.gif)

The following example shows a Hello World Compiler Plugin.
The Hello World plugin auto implements the `helloWorld` function by rewriting the Kotlin AST before the compiler proceeds.

```kotlin
val Meta.helloWorld: CliPlugin
  get() =
    "Hello World" {
      meta(
        namedFunction(this, { element.name == "helloWorld" }) { (c, _) ->
          Transform.replace(
            replacing = c,
            newDeclaration =
            """|fun helloWorld(): Unit =
               |  println("Hello ΛRROW Meta!")
               |""".function(descriptor).syntheticScope
          )
        }
      )
    }
```

For any user code whose function name is `helloWorld` our compiler plugin will replace the matching function for a
function that returns Unit and prints our message.

```diff
- fun helloWorld(): Unit = TODO()
+ fun helloWorld(): Unit =
+   println("Hello ΛRROW Meta!")
```

### How to run it from IDE

1. Create a new project from existing sources: `hello-world` directory
2. Open `use-plugin/src/main/kotlin/io/arrowkt/example/HelloWorld.kt`
3. Run `main` function 

### How to run it from command line

```
cd hello-world
./gradlew clean build
java -jar use-plugin/build/libs/use-plugin.jar
```

## Hello World Compiler + IDE Plugin

Stay tuned!

## Use of Λrrow Meta Compiler Plugin

Λrrow Meta Compiler Plugin can be used through Λrrow Meta Gradle Plugin.

### How to run it from IDE

1. Create a new project from existing sources: `use-arrow-meta-compiler-plugin` directory
2. Build project to run the test

### How to run it from command line

```
cd use-arrow-meta-compiler-plugin
./gradlew clean build
```

## Other examples

* Create a new plugin to generate sources: `generate-sources` directory

## License

Copyright (C) 2019 The Λrrow Authors

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

   http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License. 
