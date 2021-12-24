package com.example.submission2bajpdicoding.ui.adapter

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.submission2bajpdicoding.R
import com.example.submission2bajpdicoding.models.Items
import com.example.submission2bajpdicoding.ui.activities.DetailsActivity
import com.example.submission2bajpdicoding.ui.activities.DetailsActivity.Companion.CLICK_STATS
import com.example.submission2bajpdicoding.ui.activities.DetailsActivity.Companion.ID
import com.example.submission2bajpdicoding.ui.activities.DetailsActivity.Companion.JUDUL
import kotlinx.android.synthetic.main.list_item_layout.view.*

class KatalogAdapter(private val idAdapter : Int): RecyclerView.Adapter<KatalogAdapter.ListViewHolder>() {
    private val ItemsList = ArrayList<Items>()

    fun setAll(data: List<Items>) {
        ItemsList.clear()
        ItemsList.addAll(data)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.list_item_layout, parent, false)
        return ListViewHolder(view)
    }

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val item = ItemsList[position]
        holder.bind(item)
    }

    override fun getItemCount(): Int {
        return ItemsList.size
    }

    inner class ListViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        fun bind(items: Items) {
            itemView.apply {
                Glide.with(itemView)
                    .load(items.poster)
                    .into(item_image)
                item_title.text = items.judul
                item_genre.text = items.genre
                itemView.setOnClickListener {
                    val intent = Intent(context, DetailsActivity::class.java).apply {
                        putExtra(ID, items.id)
                        putExtra(JUDUL, items.judul)
                        putExtra(CLICK_STATS, idAdapter)
                    }
                    itemView.context.startActivity(intent)
                }
            }
        }
    }
}








