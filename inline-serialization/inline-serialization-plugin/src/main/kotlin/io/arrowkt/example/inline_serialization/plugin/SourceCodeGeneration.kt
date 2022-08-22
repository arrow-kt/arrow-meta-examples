package io.arrowkt.example.inline_serialization.plugin

val TargetClass.serializerClassSource get() =
    """ |package $serializerClassPackageName
        |
        |import kotlinx.serialization.*
        |import kotlinx.serialization.internal.*
        |
        |import $fullyQualifiedName
        |
        |@Serializer(forClass = ${name}::class)
        |class $serializerClassName : KSerializer<${name}> {
        |    override val descriptor: SerialDescriptor =
        |          ${valueParameterTypeName}Descriptor.withName("MyData")
        |    //    PrimitiveDescriptor("$name", PrimitiveKind.$primitiveKindName)
        |
        |    //override fun serialize(encoder: Encoder, value: $name) {
        |    //    encoder.encode$valueParameterTypeName(value.value)
        |    override fun serialize(encoder: Encoder, obj: $name) {
        |        encoder.encode$valueParameterTypeName(obj.value)
        |    }
        |
        |    override fun deserialize(decoder: Decoder): $name {
        |        return $name(decoder.decode$valueParameterTypeName())
        |    }
        |}
    """.trimMargin()

val TargetClass.annotatedClassSource get() =
    """ |@kotlinx.serialization.Serializable(with = $serializerClassPackageName.$serializerClassName::class)
        |""".trimMargin() +
    originalClassSourceCode

val TargetClass.serializerSourceFilename get() =
    "${name}.inline_serialization.kt"
