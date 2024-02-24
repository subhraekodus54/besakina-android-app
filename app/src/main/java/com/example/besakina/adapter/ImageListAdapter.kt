package com.example.besakina.adapter

import android.content.Context
import android.content.Intent
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.besakina.databinding.ImageListItemLayoutBinding
import com.example.besakina.model.ImageListModel
import java.io.InputStream

class ImageListAdapter(private val itemList: MutableList<ImageListModel>, private val context: Context):
    RecyclerView.Adapter<ImageListAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ImageListAdapter.ViewHolder {
        val itemBinding = ImageListItemLayoutBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return ImageListAdapter.ViewHolder(itemBinding)
    }

    override fun getItemCount(): Int {
        return itemList.size
    }

    fun add(data: ImageListModel) {
        itemList.add(data)
        notifyItemInserted(itemList.size - 1)
    }
    override fun onBindViewHolder(holder: ImageListAdapter.ViewHolder, position: Int) {
        val rowData = itemList[position]
        holder.bind(rowData, context)
    }

    class ViewHolder(private val itemBinding: ImageListItemLayoutBinding) :
        RecyclerView.ViewHolder(itemBinding.root) {
        fun bind(data: ImageListModel, context: Context) {
            itemBinding.apply {
                val imageStream: InputStream = data?.uri?.let {
                    context.getContentResolver().openInputStream(
                        it
                    )
                }!!
                val selectedImage: Bitmap = BitmapFactory.decodeStream(imageStream)
                imageView.setImageBitmap(selectedImage)
            }
        }
    }
}