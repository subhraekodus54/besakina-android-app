package com.example.besakina.adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.besakina.R
import com.example.besakina.databinding.MyAdsItemLayoutBinding
import com.example.besakina.model.AddsModel
import com.example.besakina.ui.activity.AdDetailsActivity

class MyAdsAdapter(private val itemList: List<AddsModel>, private val context: Context):
    RecyclerView.Adapter<MyAdsAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyAdsAdapter.ViewHolder {
        val itemBinding = MyAdsItemLayoutBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return MyAdsAdapter.ViewHolder(itemBinding)
    }

    override fun getItemCount(): Int {
        return itemList.size
    }

    override fun onBindViewHolder(holder: MyAdsAdapter.ViewHolder, position: Int) {
        val rowData = itemList[position]
        holder.bind(rowData, context)
    }

    class ViewHolder(private val itemBinding: MyAdsItemLayoutBinding) :
        RecyclerView.ViewHolder(itemBinding.root) {
        fun bind(data: AddsModel, context: Context) {
            itemBinding.apply {
                Glide.with(context)
                    .load(data.picPath) // image url
                    .placeholder(R.color.text_grey) // any placeholder to load at start
                    .centerCrop()
                    .into(imageView)
                timeTv.text = data?.time
                itemDescTv.text = data?.desc
                priceTv.text = data?.price
                locTv.text = data?.location

                root.setOnClickListener {
                    val intent = Intent(context, AdDetailsActivity::class.java)
                    context.startActivity(intent)
                }
            }
        }
    }
}