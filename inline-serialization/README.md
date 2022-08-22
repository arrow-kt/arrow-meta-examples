# inline-serialization-plugin
A Kotlin compiler plugin for inline serialization, implemented with ΛRROW Meta.

## Notes
*This plug-in is not a polished product meant to be reused in other projects.*

The current version of this plug-in based against on Kotlin 1.3.61 and Serialization Runtime 0.14.0.

Kotlin 1.3.70+ and thus Serialization Runtime 0.20.0 are not supported by ΛRROW Meta, at the moment (https://github.com/arrow-kt/arrow-meta/issues/554).

This plug-in project is derived by the original `hello-world` plug-in example by the ΛRROW Meta team.

## Plug-in description and project structure
The plug-in is implemented in the `inline-serialization-plugin` module.

Inline serialization is enabled using the `@InlineSerializable` annotation, defined in the `inline-serialization` module.

For each class `a.b.c.Xyz` annotated with `@InlineSerializable`, the plug-in generates a serializer `XyzSerializer`, implementing inline serialization, in package `a.b.c.inline_serialization`, and also annotates the class with `@Serializable(with=a.b.c.inline_serialization.XyzSerializer::class)`.

In this case, we annotated two classes in the library implemented in module `example-library`. The compiler plugin is invoked during the build of this module. This library is then used by the application in module `example-application`.

## Usage
### Build
From the console:

```./gradlew clean :example-application:shadowJar```

### Run
From the console:

```java -jar example-application/build/libs/example-application-all.jar```
