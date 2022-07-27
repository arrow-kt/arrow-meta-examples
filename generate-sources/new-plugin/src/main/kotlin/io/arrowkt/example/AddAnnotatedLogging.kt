package io.arrowkt.example

import arrow.meta.CliPlugin
import arrow.meta.Meta
import arrow.meta.invoke
import org.jetbrains.kotlin.backend.common.extensions.IrPluginContext
import org.jetbrains.kotlin.backend.common.lower.DeclarationIrBuilder
import org.jetbrains.kotlin.ir.builders.irBlockBody
import org.jetbrains.kotlin.ir.builders.irCall
import org.jetbrains.kotlin.ir.builders.irGetObject
import org.jetbrains.kotlin.ir.declarations.IrFunction
import org.jetbrains.kotlin.ir.expressions.IrBody
import org.jetbrains.kotlin.ir.util.getSimpleFunction
import org.jetbrains.kotlin.ir.util.hasAnnotation
import org.jetbrains.kotlin.ir.util.statements
import org.jetbrains.kotlin.name.FqName

val Meta.addAnnotatedLogging: CliPlugin
    get() = "Add Logging To Annotated Functions" {
        meta(
            irFunction { declaration ->

                // FIXME #58: NoClassDefFound when trying to access via MetaLog::class.qualifiedName
                return@irFunction if (declaration.hasAnnotation(FqName("io.arrowkt.example.MetaLog"))) {
                    declaration.body = prependLoggingToBody(pluginContext, declaration)

                    declaration
                } else {
                    declaration
                }
            }
        )
    }

fun prependLoggingToBody(pluginContext: IrPluginContext, declaration: IrFunction): IrBody {
    return DeclarationIrBuilder(pluginContext, declaration.symbol).irBlockBody {

        val referenceClass = pluginContext.referenceClass(FqName("io.arrowkt.example.MetaLogger"))
            ?: throw NoClassDefFoundError("MetaLogger not found")

        val interceptionCall = referenceClass.getSimpleFunction("log")
            ?: throw NoClassDefFoundError("MetaLogger.log() not fround")

        // Inject logging to function top statement(will be called first)
        +irCall(interceptionCall).apply {
            dispatchReceiver = irGetObject(referenceClass)
        }

        // Apply original statements
        for (statement in declaration.body!!.statements) +statement
    }
}
