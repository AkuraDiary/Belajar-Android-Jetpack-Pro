package com.example.submission3bajpdicoding.ui.adapter

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.submission3bajpdicoding.R
import com.example.submission3bajpdicoding.data.source.local.entity.Items
import com.example.submission3bajpdicoding.databinding.ListItemLayoutBinding
import com.example.submission3bajpdicoding.ui.detail.DetailsActivity

class MovieAdapter : PagingDataAdapter<Items, MovieAdapter.MovieViewHolder>(DIFF_CALLBACK){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        val itemListBinding = ListItemLayoutBinding.inflate(
            LayoutInflater.from(parent.context), parent, false
        )
        return MovieViewHolder(itemListBinding)
    }

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        val tvShow = getItem(position)
        if(tvShow != null){
            holder.bind(tvShow)
        }
    }
    inner class MovieViewHolder (private val binding: ListItemLayoutBinding) :
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
                    putExtra(DetailsActivity.ID, tvShow.id)
                    putExtra(DetailsActivity.JUDUL, tvShow.title)
                }
                itemView.context.startActivity(intent)
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