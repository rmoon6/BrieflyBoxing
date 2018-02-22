package com.companyfiller.android.brieflyboxing

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView

/**
 * Created by Chase on 2/21/2018.
 */
class ShowMovesActivity: AppCompatActivity(), View.OnClickListener {

    private val NUM_MOVES: Int = 5

    private val recyclerView: RecyclerView by lazy { findViewById<RecyclerView>(R.id.moves_recycler) }
    private val refreshButton: Button by lazy { findViewById<Button>(R.id.refresh_button) }

    private var movesList: List<Move> = listOf()
    private val movesAdapter: ShowMovesAdapter by lazy { ShowMovesAdapter() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_show_moves)
    }

    override fun onStart() {
        super.onStart()

        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = movesAdapter

        refreshButton.setOnClickListener(this)
        refreshMoves()
    }

    override fun onClick(v: View?) { when (v) { refreshButton -> refreshMoves() } }

    private fun refreshMoves() {
        movesList = MoveGenerator.getRandomMoves(NUM_MOVES)
        movesAdapter.notifyDataSetChanged()
    }

    inner class ShowMovesViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {

        private val moveText: TextView by lazy { itemView.findViewById<TextView>(R.id.move_text) }

        fun bindView(move: Move) {
            moveText.text = move.name
        }

    }

    inner class ShowMovesAdapter: RecyclerView.Adapter<ShowMovesViewHolder>() {
        override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): ShowMovesViewHolder =
                ShowMovesViewHolder(layoutInflater.inflate(R.layout.item_move, parent, false))
        override fun onBindViewHolder(holder: ShowMovesViewHolder, position: Int) {
            holder.bindView(movesList[position])
        }
        override fun getItemCount(): Int = movesList.size
    }

}