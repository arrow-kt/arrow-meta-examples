package io.arrowkt.example.inline_serialization.plugin

import org.jetbrains.kotlin.psi.*

import arrow.core.getOrHandle
import arrow.meta.CliPlugin
import arrow.meta.Meta
import arrow.meta.invoke
import arrow.meta.quotes.Transform
import arrow.meta.quotes.classDeclaration
import arrow.meta.quotes.plus

import io.arrowkt.example.inline_serialization.inline_serialization.InlineSerializable

val Meta.inlineSerialization: CliPlugin
    get() =
        "Inline Serialization" {
            meta(
                classDeclaration({ isAnnotatedWith<InlineSerializable>() } ) { c ->
                    val targetClass = TargetClass.tryMake(c).getOrHandle { problem ->
                        throw problem.toException()
                    }

                    val originalClassAnnotation = Transform.replace<KtClass>(
                        replacing = c,
                        newDeclaration = targetClass.annotatedClassSource.`class`.syntheticScope
                    )
                    val serializerClassGeneration = Transform.newSources<KtClass>(
                        targetClass.serializerClassSource.file(targetClass.serializerSourceFilename)
                    )

                    originalClassAnnotation + serializerClassGeneration
                }
            )
        }
