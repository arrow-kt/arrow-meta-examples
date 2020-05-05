package io.arrowkt.example.inline_serialization.plugin

import org.jetbrains.kotlin.psi.*

fun String?.orNoName() = this ?: "<no name>"

val KtParameter.description get() =
    "${name.orNoName()} : ${typeReference?.text }"

fun List<String?>.joinAsNames() =
    filterNotNull().joinToString(".")

fun <T> List<T>.joinAsNames(block : (T) -> String?) =
    map(block).joinAsNames()

val KtClass.packageDirective get() =
    containingFile.children.filterIsInstance<KtPackageDirective>().firstOrNull()

val KtClass.packageName get() =
    packageDirective?.packageNames?.joinAsNames { it.getReferencedName() }

val KtClass.fullyQualifiedName get() =
    listOf(packageName, name).joinAsNames()

inline fun <reified T> isAnnotatedWith() : KtAnnotated.() -> Boolean =
        { annotationEntries.any { it.shortName?.asString() == T::class.simpleName } }

inline fun <reified T> KtAnnotated.isAnnotatedWith() =
        annotationEntries.any { it.shortName?.asString() == T::class.simpleName }
