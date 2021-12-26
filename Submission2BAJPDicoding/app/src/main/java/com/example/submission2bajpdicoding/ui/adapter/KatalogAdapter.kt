package com.example.submission2bajpdicoding.ui.adapter

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.submission2bajpdicoding.R
import com.example.submission2bajpdicoding.databinding.ListItemLayoutBinding
import com.example.submission2bajpdicoding.data.source.local.entity.Items
import com.example.submission2bajpdicoding.ui.activities.DetailsActivity
import com.example.submission2bajpdicoding.ui.activities.DetailsActivity.Companion.CLICK_STATS
import com.example.submission2bajpdicoding.ui.activities.DetailsActivity.Companion.ID
import com.example.submission2bajpdicoding.ui.activities.DetailsActivity.Companion.JUDUL

class KatalogAdapter(private val idAdapter : Int): RecyclerView.Adapter<KatalogAdapter.ListViewHolder>() {
    private val _itemsList = ArrayList<Items>()

    fun setAll(data: List<Items>) {
        _itemsList.clear()
        _itemsList.addAll(data)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.list_item_layout, parent, false)
        return ListViewHolder(view)
    }

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val item = _itemsList[position]
        holder.bind(item)
    }

    override fun getItemCount(): Int {
        return _itemsList.size
    }

    inner class ListViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        private val binding = ListItemLayoutBinding.bind(view)

        fun bind(items: Items) {
            itemView.apply {
                Glide.with(itemView)
                    .load(items.poster)
                    .into(binding.itemImage)
                binding.itemTitle.text = items.title
                binding.itemOriginalTitle.text = items.OriginalTitle
                itemView.setOnClickListener {
                    val intent = Intent(context, DetailsActivity::class.java).apply {
                        putExtra(ID, items.id)
                        putExtra(JUDUL, items.title)
                        putExtra(CLICK_STATS, idAdapter)
                    }
                    itemView.context.startActivity(intent)
                }
            }
        }
    }
}








