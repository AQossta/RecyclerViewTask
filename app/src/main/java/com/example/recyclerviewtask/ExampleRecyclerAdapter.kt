package com.example.recyclerviewtask

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.recyclerviewtask.databinding.ExampleAdapterBinding

class ExampleRecyclerAdapter(): RecyclerView.Adapter<ExampleRecyclerAdapter.ExampleViewHolder>() {

    val adapterList = mutableListOf<Product>()

    inner class ExampleViewHolder(private var binding: ExampleAdapterBinding): RecyclerView.ViewHolder(binding.root){
        @SuppressLint("SetTextI18n")
        fun onBind(item:Product){
            binding.tvProductTitle.text = item.title
            binding.tvProductPrice.text = item.price.toString()
        }
    }

    fun submitList(list: List<Product>){
        adapterList.addAll(list)
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ExampleRecyclerAdapter.ExampleViewHolder {
        return ExampleViewHolder(
            ExampleAdapterBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(
        holder: ExampleRecyclerAdapter.ExampleViewHolder,
        position: Int
    ) {
        holder.onBind(adapterList[position])
    }

    override fun getItemCount(): Int {
        return adapterList.size
    }
}