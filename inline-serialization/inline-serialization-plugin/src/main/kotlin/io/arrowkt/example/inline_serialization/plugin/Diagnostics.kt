package io.arrowkt.example.inline_serialization.plugin

fun TargetClass.Problem.toException() =
    when (this) {
        TargetClass.Problem.WrongStructure ->
            UnsupportedClassStructure()
        is TargetClass.Problem.UnsupportedType ->
            UnsupportedValArgumentType(valueParameterTypeName)
    }

class UnsupportedClassStructure :
    Exception("Inline serialization is meaningful only for classes with one and only one val member")
class UnsupportedValArgumentType(
    val valueParameterTypeName : String
) : Exception("Unsupported val member type $valueParameterTypeName: Only supported types are: ${allPrimitiveKinds.allTypeNames}}")
