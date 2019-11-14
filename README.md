# Λrrow Meta Examples

[![Build](/arrow-kt/test/workflows/Build/badge.svg)](/arrow-kt/test/actions?query=workflow%3ABuild)

Some examples for [Λrrow Meta](/arrow-kt/arrow-meta/) the functional companion to Kotlin's Compiler & IDE.

## Hello World

### How to run it from IDE

1. Create a new project from existing sources: `hello-world` directory
2. Open `use-plugin/src/main/kotlin/io/arrowkt/example/HelloWorld.kt`
3. Run `main` function 

### How to run it from command line

```
./gradlew clean :use-plugin:shadowJar
java -jar use-plugin/build/libs/use-plugin-all.jar
```

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
