package io.arrowkt.example.inline_serialization.plugin

import org.jetbrains.kotlin.psi.KtClass
import org.jetbrains.kotlin.psi.KtParameter
import org.jetbrains.kotlin.psi.KtPrimaryConstructor

import arrow.core.Either
import arrow.core.left
import arrow.core.right

class TargetClass private constructor(
    val c : KtClass,
    val ctor : KtPrimaryConstructor,
    val valueParameter : KtParameter,
    val valueParameterTypeName : String,
    val primitiveKindName : String
) {
    sealed class Problem {
        object WrongStructure : Problem()
        class UnsupportedType(
            val valueParameterTypeName : String
        ) : Problem()
    }
    companion object {
        fun tryMake(c : KtClass) : Either<Problem, TargetClass> =
            c.primaryConstructor!!.let { ctor ->
                if (ctor.valueParameters.size != 1) {
                    Problem.WrongStructure.left()
                } else {
                    val valueParameter = ctor.valueParameters[0]!!
                    val valueParameterTypeName = valueParameter.typeReference?.text!!

                    val primitiveKindName = valueParameterTypeName.toUpperCase()

                    if (primitiveKindName !in allPrimitiveKinds.keys)
                        Problem.UnsupportedType(valueParameterTypeName).left()
                    else
                        TargetClass(c, ctor, valueParameter, valueParameterTypeName, primitiveKindName).right()
                }
            }
    }

    val name get() = c.name!!
    val packageName get() = c.packageName!!
    val fullyQualifiedName get() = c.fullyQualifiedName

    val serializerClassName
        get() = "${name}Serializer"
    val serializerClassPackageName
        get() = "${packageName}.inline_serialization"

    val originalClassSourceCode
        get() = c.text
}
