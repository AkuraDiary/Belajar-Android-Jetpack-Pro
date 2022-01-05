package com.example.submission3bajpdicoding.ui.tvShows

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.submission3bajpdicoding.databinding.ListItemLayoutBinding
import androidx.paging.PagedListAdapter
import com.bumptech.glide.Glide
import com.example.submission3bajpdicoding.R
import com.example.submission3bajpdicoding.data.source.local.entity.Items
import com.example.submission3bajpdicoding.ui.detail.DetailsActivity

class TvShowAdapter : PagedListAdapter<Items, TvShowAdapter.TvShowViewHolder>(DIFF_CALLBACK){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TvShowViewHolder {
        val itemListBinding = ListItemLayoutBinding.inflate(
            LayoutInflater.from(parent.context), parent, false
        )
        return TvShowViewHolder(itemListBinding)
    }

    override fun onBindViewHolder(holder: TvShowViewHolder, position: Int) {
        val tvShow = getItem(position)
        if(tvShow != null){
            holder.bind(tvShow)
        }
    }
    inner class TvShowViewHolder (private val binding: ListItemLayoutBinding) :
        RecyclerView.ViewHolder(binding.root){
            fun bind(tvShow : Items){
                with(binding){
                    itemTitle.text = tvShow.title
                    itemOriginalTitle.text = tvShow.OriginalTitle
                    itemScore.text = tvShow.score.toString()
                    Glide.with(itemView.context)
                        .load(itemView.context.getString(R.string.baseUrl_Poster, tvShow.poster))
                        .into(itemImage)
                }

                itemView.setOnClickListener{
                    val intent = Intent(itemView.context, DetailsActivity::class.java).apply {
                        putExtra(ID = )
                    }
                }
            }
        }

    companion object{
        private val DIFF_CALLBACK = object : DiffUtil.ItemCallback<Items>() {
            override fun areItemsTheSame(oldItem: Items, newItem: Items): Boolean {
                return oldItem.id == newItem.id
            }

            override fun areContentsTheSame(oldItem: Items, newItem: Items): Boolean {
                return oldItem == newItem
            }
        }
    }
}