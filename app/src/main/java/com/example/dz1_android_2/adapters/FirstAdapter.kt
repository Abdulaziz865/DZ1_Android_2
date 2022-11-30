package com.example.dz1_android_2.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.dz1_android_2.databinding.ItemNamePersonBinding
import com.example.dz1_android_2.model.RecyclerModel

class FirstAdapter(
    private var listArray: ArrayList<RecyclerModel>,
    private val clickListener: (name: RecyclerModel) -> Unit
) : RecyclerView.Adapter<FirstAdapter.FirstViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FirstViewHolder {
        val binding = ItemNamePersonBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return FirstViewHolder(binding)
    }

    override fun onBindViewHolder(holder: FirstViewHolder, position: Int) {
        holder.onBind(listArray[position])
    }

    override fun getItemCount(): Int {
        return listArray.size
    }

    inner class FirstViewHolder(private var binding: ItemNamePersonBinding) :
        RecyclerView.ViewHolder(binding.root) {

        init {
            itemView.setOnClickListener {
                clickListener(listArray[bindingAdapterPosition])
            }
        }

        fun onBind(mainModel: RecyclerModel) {
            binding.tvName.text = mainModel.name
        }
    }
}