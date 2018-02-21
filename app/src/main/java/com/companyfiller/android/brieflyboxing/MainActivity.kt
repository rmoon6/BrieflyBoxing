package com.companyfiller.android.brieflyboxing

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {

    private val getMovesButton: Button by lazy { findViewById<Button>(R.id.get_moves_button) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    override fun onStart() {
        super.onStart()
        getMovesButton.setOnClickListener { goToShowMoves() }
    }

    private fun goToShowMoves() { startActivity(Intent(this, ShowMovesActivity::class.java)) }
}
