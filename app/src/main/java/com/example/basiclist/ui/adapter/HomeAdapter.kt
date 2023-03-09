package com.example.basiclist.ui.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.basiclist.databinding.ItemListBinding
import com.example.basiclist.model.HomeModel

class HomeAdapter(val onItemClick: (modelBook: HomeModel) -> Unit) :
    RecyclerView.Adapter<HomeAdapter.AdapterViewHolder>() {

    private var list: List<HomeModel> = ArrayList()

    @SuppressLint("NotifyDataSetChanged")
    fun setList(list: List<HomeModel>) {
        this.list = list
        notifyDataSetChanged()
    }

    inner class AdapterViewHolder(private var binding: ItemListBinding) :
        RecyclerView.ViewHolder(binding.root) {

        init {
            itemView.setOnClickListener {
                onItemClick(list[adapterPosition])
            }
        }

        fun onBind(modelBook: HomeModel) {
            binding.tvName.text = modelBook.name
            Glide.with(binding.ivLogo.context).load(modelBook.img).into(binding.ivLogo)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AdapterViewHolder {
        return AdapterViewHolder(
            ItemListBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: AdapterViewHolder, position: Int) {
        holder.onBind(list[position])
    }

    override fun getItemCount(): Int = list.size
}
