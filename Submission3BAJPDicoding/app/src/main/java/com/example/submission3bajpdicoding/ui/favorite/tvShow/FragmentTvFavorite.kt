package com.example.submission3bajpdicoding.ui.favorite.tvShow

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.submission3bajpdicoding.databinding.FragmentFavoriteTvBinding
import com.example.submission3bajpdicoding.ui.adapter.FavoriteTvAdapter
import com.example.submission3bajpdicoding.ui.favorite.FavoriteViewModel
import com.google.android.material.snackbar.Snackbar
import org.koin.androidx.viewmodel.ext.android.viewModel

class FragmentTvFavorite : Fragment() {
    private var _fragmentFavoriteTvBinding : FragmentFavoriteTvBinding? = null
    private val binding get() = _fragmentFavoriteTvBinding

    private lateinit var favoriteTvAdapter: FavoriteTvAdapter
    private val viewModel : FavoriteViewModel by viewModel()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _fragmentFavoriteTvBinding = FragmentFavoriteTvBinding.inflate(layoutInflater, container, false)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        itemTouchHelper.attachToRecyclerView(binding?.rvTVPlaceholderFavorite)
        favoriteTvAdapter = FavoriteTvAdapter()

        binding?.progressBar?.visibility = View.VISIBLE
        binding?.noFav?.visibility = View.VISIBLE
        viewModel.getFavoriteTvShows().observe(requireActivity(), { item ->
            binding?.progressBar?.visibility = View.GONE
            if (item.size >= 1){
                binding?.noFav?.visibility = View.GONE
            }
            favoriteTvAdapter.submitList(item)
        })

        with(binding?.rvTVPlaceholderFavorite){
            this?.layoutManager = LinearLayoutManager(context)
            this?.setHasFixedSize(true)
            this?.adapter = favoriteTvAdapter
        }
    }

    private val itemTouchHelper = ItemTouchHelper(object : ItemTouchHelper.Callback(){
        override fun getMovementFlags(
            recyclerView: RecyclerView,
            viewHolder: RecyclerView.ViewHolder
        ): Int {
            return makeMovementFlags(0, ItemTouchHelper.LEFT or ItemTouchHelper.RIGHT)
        }

        override fun onMove(
            recyclerView: RecyclerView,
            viewHolder: RecyclerView.ViewHolder,
            target: RecyclerView.ViewHolder
        ): Boolean {
            return true
        }

        override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int) {
            if(view != null){
                val swipedPosition = viewHolder.adapterPosition
                val item = favoriteTvAdapter.getSwipedData(swipedPosition)
                item?.let { viewModel.setFavoriteData(it) }
                val snackBar = Snackbar.make(view as View, "Cancel to Delete?", Snackbar.LENGTH_LONG)
                snackBar.setAction("Ok"){ _ ->
                    item?.let { viewModel.setFavoriteData(it) }
                }
                snackBar.show()
            }
        }
    })

    override fun onDestroy() {
        super.onDestroy()
        _fragmentFavoriteTvBinding = null
    }
}