package com.dynamicdevs.ddbestiary.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.dynamicdevs.ddbestiary.databinding.CardDisplayItemBinding
import com.dynamicdevs.ddbestiary.model.data.dd.monster.DDMonsterResult

class DisplayRecyclerViewAdapter(): RecyclerView.Adapter<DisplayRecyclerViewAdapter.CardItemHolder>() {
    inner class CardItemHolder(val binding: CardDisplayItemBinding): RecyclerView.ViewHolder(binding.root)

    var apiList: List<DDMonsterResult> = listOf()
    set(value){
        field = value
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardItemHolder {
        val binding = CardDisplayItemBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return CardItemHolder(binding);
    }

    override fun onBindViewHolder(holder: CardItemHolder, position: Int) {
        val item = apiList[position]
        holder.binding.apply {
            this.nameTextView.text = item.name
        }
    }

    override fun getItemCount(): Int = apiList.size
}