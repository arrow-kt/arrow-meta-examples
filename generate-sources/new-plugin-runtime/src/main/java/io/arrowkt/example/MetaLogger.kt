package io.arrowkt.example

@Suppress("unused")
object MetaLogger {

    /**
     * Called by [io.arrowkt.example.MetaPlugin] during IR transformation
     */
    @Suppress("unused")
    fun log() {
        println("MetaLogger.log() invoked")
    }
}