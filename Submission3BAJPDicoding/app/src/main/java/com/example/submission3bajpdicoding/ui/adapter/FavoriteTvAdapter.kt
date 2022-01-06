package com.example.submission3bajpdicoding.ui.adapter

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagedListAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.submission3bajpdicoding.R
import com.example.submission3bajpdicoding.data.source.local.entity.Items
import com.example.submission3bajpdicoding.databinding.ListItemLayoutBinding
import com.example.submission3bajpdicoding.ui.detail.DetailsActivity

class FavoriteTvAdapter : PagedListAdapter<Items, FavoriteTvAdapter.ViewHolder>(DIFF_CALLBACK){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemLayoutBinding = ListItemLayoutBinding.inflate(
            LayoutInflater.from(parent.context), parent, false
        )
        return ViewHolder(itemLayoutBinding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = getItem(position)
        if (item != null){
            holder.bind(item)
        }
    }

    fun getSwipedData(swipedPosition : Int):Items?{
        return getItem(swipedPosition)
    }

    inner class ViewHolder (private val binding : ListItemLayoutBinding):
    RecyclerView.ViewHolder(binding.root){
        fun bind(item:Items){
            with(binding){
                itemTitle.text = item.title
                itemOriginalTitle.text = item.OriginalTitle
                itemScore.text = item.score.toString()

                Glide.with(itemView.context)
                    .load(itemView.context.getString(R.string.baseUrl_Poster, item.poster))
                    .into(itemImage)
            }
            itemView.setOnClickListener{
                val intent = Intent(itemView.context, DetailsActivity::class.java).apply {
                    putExtra(DetailsActivity.ID, item.id)
                    putExtra(DetailsActivity.JUDUL, item.title)
                }
                itemView.context.startActivity(intent)
            }
        }

    }

    companion object{
        private val DIFF_CALLBACK = object : DiffUtil.ItemCallback<Items>(){
            override fun areItemsTheSame(oldItem: Items, newItem: Items): Boolean {
                return oldItem.id == newItem.id
            }

            override fun areContentsTheSame(oldItem: Items, newItem: Items): Boolean {
                return oldItem == newItem
            }
        }
    }
}