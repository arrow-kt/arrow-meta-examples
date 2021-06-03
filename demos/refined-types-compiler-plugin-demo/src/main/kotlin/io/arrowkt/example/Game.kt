package io.arrowkt.example

import arrow.refinement.Refined
import arrow.refinement.ensure
import kotlinx.serialization.Serializable

// @JvmInline
@Serializable
value class GameId private constructor(val value: String) {

//    init {
//        val results = constraints(value)
//        if (!results.allValid())
//            throw IllegalArgumentException(renderMessages(results))
//    }

    companion object : Refined<String, GameId>(::GameId, {
        ensure((it.length == 8) to "Expected $it has 8 characters")
    })
}

@Serializable
data class Game(
    val gameId: GameId,
    val color: String,
)
