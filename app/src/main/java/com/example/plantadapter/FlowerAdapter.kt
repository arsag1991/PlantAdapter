package com.example.plantadapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.plantadapter.databinding.FlowerItemBinding

class FlowerAdapter: RecyclerView.Adapter<FlowerAdapter.FlowerHolder>() {
    val flowerList = ArrayList<Flower> ()

    class FlowerHolder(item: View): RecyclerView.ViewHolder(item) {
        val binding = FlowerItemBinding.bind(item)
        fun bind(flower: Flower) = with(binding){
            im.setImageResource(flower.flowerId)
            tvTitle.text = flower.title
        }
    }






    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FlowerHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.flower_item, parent, false)
        return FlowerHolder(view)
    }

    override fun onBindViewHolder(holder: FlowerHolder, position: Int) {
        holder.bind(flowerList[position])
    }

    override fun getItemCount(): Int {
        return flowerList.size
    }
    public fun addFlower (flower: Flower){
        flowerList.add(flower)
        notifyDataSetChanged()
    }


}