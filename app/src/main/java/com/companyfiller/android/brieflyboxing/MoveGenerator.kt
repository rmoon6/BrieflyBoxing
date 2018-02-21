package com.companyfiller.android.brieflyboxing

import java.util.*

/**
 * Created by Chase on 2/21/2018.
 */
class MoveGenerator {
    companion object {
        private val moves: List<Move> = listOf(
                Move(name = "right hook"),
                Move(name = "left hook"),
                Move(name = "red hook"),
                Move(name = "blue hook"),
                Move(name = "donatello"),
                Move(name = "michaelangelo"),
                Move(name = "raphael"),
                Move(name = "leonardo"),
                Move(name = "mario"),
                Move(name = "luigi"),
                Move(name = "bobby flay"),
                Move(name = "world star hip hop"),
                Move(name = "tyler the creator"),
                Move(name = "ganondorf"),
                Move(name = "all of the trees"),
                Move(name = "refrigerators"),
                Move(name = "rock lee"),
                Move(name = "umma house"),
                Move(name = "bill and ted"),
                Move(name = "me")
        )

        fun getRandomMoves(amount: Int): List<Move> {
            if (amount > moves.size) return listOf()
            val tempMoves: List<Move> = moves
            Collections.shuffle(tempMoves)
            return tempMoves.take(amount)
        }
    }
}