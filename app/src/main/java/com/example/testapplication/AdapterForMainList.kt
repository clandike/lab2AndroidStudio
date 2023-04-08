package com.example.testapplication

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.testapplication.databinding.ItemCarBinding

class AdapterForMainList(val onClick: (model: MyCar, position: Int) -> Unit) :
    RecyclerView.Adapter<AdapterForMainList.CarViewHolder>() {
    private val list = ArrayList<MyCar>()

    inner class CarViewHolder(val binding: ItemCarBinding) : RecyclerView.ViewHolder(binding.root) {
        @SuppressLint("CheckResult")
        fun bindItem(myCar: MyCar, position: Int) {
            binding.tvName.text = myCar.name
            binding.tvDesc.text = myCar.desc
            binding.btn.setOnClickListener {
                onClick(myCar, position)
            }

            Glide.with(binding.imageView.context)
                .load(myCar.urlImage)
                .into(binding.imageView)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CarViewHolder {
        val view = ItemCarBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return CarViewHolder(view)
    }

    override fun onBindViewHolder(holder: CarViewHolder, position: Int) {
        holder.bindItem(list[position], position)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    @SuppressLint("NotifyDataSetChanged")
    fun setNewData(newList: List<MyCar>) {
        list.clear()
        list.addAll(newList)
        notifyDataSetChanged()
    }
}