package com.example.dz1_android_2.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.dz1_android_2.databinding.ItemImagePersonBinding
import com.example.dz1_android_2.model.RecyclerModel

class SecondAdapter(
    private var listArray: ArrayList<RecyclerModel>,
    private val clickListener: (name: RecyclerModel) -> Unit
) : RecyclerView.Adapter<SecondAdapter.SecondViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SecondViewHolder {
        val binding = ItemImagePersonBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return SecondViewHolder(binding)
    }

    override fun onBindViewHolder(holder: SecondViewHolder, position: Int) {
        holder.onBind(listArray[position])
    }

    override fun getItemCount(): Int {
        return listArray.size
    }

    inner class SecondViewHolder(private var binding: ItemImagePersonBinding) :
        RecyclerView.ViewHolder(binding.root) {

        init {
            itemView.setOnClickListener {
                clickListener(listArray[bindingAdapterPosition])
            }
        }
        fun onBind(model: RecyclerModel) {
            Glide.with(binding.ivImagePhoto.context)
                .load(model.image)
                .into(binding.ivImagePhoto)
            binding.root.tag = model
        }
    }
}