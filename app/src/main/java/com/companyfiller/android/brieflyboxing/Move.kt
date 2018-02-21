package com.companyfiller.android.brieflyboxing

/**
 * Created by Chase on 2/21/2018.
 */
data class Move(val name: String) {
    override fun equals(other: Any?): Boolean {
        val otherMove = other as? Move ?: return false
        return otherMove.name == name
    }
}