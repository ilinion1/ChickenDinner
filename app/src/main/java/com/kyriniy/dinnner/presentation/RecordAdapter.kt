package com.kyriniy.dinnner.presentation

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.kyriniy.dinnner.R

class RecordAdapter(): RecyclerView.Adapter<RecordAdapter.RecordViewHolder>() {

    var gameList = arrayListOf<String>()
    var countList = arrayListOf<String>()

    class RecordViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        val count = itemView.findViewById<TextView>(R.id.tvCount)
        val coin = itemView.findViewById<TextView>(R.id.tvCoin)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecordViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.record_item, parent, false)
        return  RecordViewHolder(view)
    }

    override fun onBindViewHolder(holder: RecordViewHolder, position: Int) {
        holder.count.text = countList[position]
        holder.coin.text = gameList[position]
    }

    override fun getItemCount(): Int {
        return gameList.size
    }
}