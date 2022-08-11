package com.example.translateapp.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.translateapp.data.TranslateItemResponseItem
import com.example.translateapp.databinding.ItemTranslateBinding

class TranslateAdapter() : RecyclerView.Adapter<TranslateAdapter.ItemViewHolder>() {
    private val listItemResponse = mutableListOf<TranslateItemResponseItem>()

    class ItemViewHolder(val listItem: ItemTranslateBinding) :
        RecyclerView.ViewHolder(listItem.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = ItemViewHolder(
        ItemTranslateBinding.inflate(LayoutInflater.from(parent.context), parent, false)
    )

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        holder.listItem.apply {
           txtViewDefinition.text =
               listItemResponse[0].meanings?.get(0)?.definitions?.get(position)?.definition
        }
    }

    override fun getItemCount() = listItemResponse[0].meanings?.get(0)?.definitions?.size!!.toInt()

    fun setData(list: List<TranslateItemResponseItem>) {
        if (list == null) return
        this.listItemResponse.clear()
        this.listItemResponse.addAll(list)

    }
}