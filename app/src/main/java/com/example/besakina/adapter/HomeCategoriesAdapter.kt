package com.example.besakina.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.besakina.databinding.HomeCategoriesItemLayoutBinding
import com.example.besakina.model.HomeCategoriesModel
import com.example.besakina.utils.ClickListener

class HomeCategoriesAdapter (private val itemList: List<HomeCategoriesModel>, private val context: Context,
                             private val clickListener: ClickListener):
    RecyclerView.Adapter<HomeCategoriesAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomeCategoriesAdapter.ViewHolder {
        val itemBinding = HomeCategoriesItemLayoutBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return HomeCategoriesAdapter.ViewHolder(itemBinding)
    }

    override fun getItemCount(): Int {
        return itemList.size
    }

    override fun onBindViewHolder(holder: HomeCategoriesAdapter.ViewHolder, position: Int) {
        val rowData = itemList[position]
        holder.bind(rowData, context, clickListener)
    }

    class ViewHolder(private val itemBinding: HomeCategoriesItemLayoutBinding) :
        RecyclerView.ViewHolder(itemBinding.root) {
        fun bind(data: HomeCategoriesModel, context: Context, clickListener: ClickListener) {
            itemBinding.apply {
                val drawableResourceId = context.getResources().getIdentifier(data.picPath, "drawable", context.getPackageName());
                Glide.with(context)
                    .load(drawableResourceId)
                    .into(imageView)
                nameTv.text = data?.name
                root.setOnClickListener {
                    clickListener.onClick(it.rootView, data?.name)
                }
            }
        }
    }
}