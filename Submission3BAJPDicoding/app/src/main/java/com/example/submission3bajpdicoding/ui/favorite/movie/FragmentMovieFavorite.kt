package com.example.submission3bajpdicoding.ui.favorite.movie

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.RecyclerView
import com.example.submission3bajpdicoding.databinding.FragmentFavoriteMovieBinding
import com.example.submission3bajpdicoding.ui.adapter.FavoriteMovieAdapter
import com.example.submission3bajpdicoding.ui.favorite.FavoriteViewModel
import com.google.android.material.snackbar.Snackbar
import org.koin.androidx.viewmodel.ext.android.viewModel

class FragmentMovieFavorite : Fragment() {

    private var _fragmentFavoriteMovieBinding : FragmentFavoriteMovieBinding? = null
    private val binding get() = _fragmentFavoriteMovieBinding

    private lateinit var favoriteAdapter : FavoriteMovieAdapter
    private val viewModel : FavoriteViewModel by viewModel()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _fragmentFavoriteMovieBinding = FragmentFavoriteMovieBinding.inflate(layoutInflater, container, false)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


    }

    private val itemTouchHelper = ItemTouchHelper(object : ItemTouchHelper.Callback() {
        override fun getMovementFlags(
            recyclerView: RecyclerView,
            viewHolder: RecyclerView.ViewHolder
        ): Int {
            return makeMovementFlags(
                0, ItemTouchHelper.LEFT or ItemTouchHelper.RIGHT
            )
        }

        override fun onMove(
            recyclerView: RecyclerView,
            viewHolder: RecyclerView.ViewHolder,
            target: RecyclerView.ViewHolder
        ): Boolean {
            return true
        }

        override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int) {
            if (view!=null){
                val swipedPosition = viewHolder.adapterPosition
                val items = favoriteAdapter.getSwipedData(swipedPosition)
                items?.let { viewModel.setFavoriteData(it) }
                val snackBar = Snackbar.make(view as View, "Cancel to delete?", Snackbar.LENGTH_LONG)
                snackBar.setAction("OK"){ _->
                    items?.let { viewModel.setFavoriteData(it) }
                }
                snackBar.show()
            }
        }
    })

    override fun onDestroy() {
        super.onDestroy()
        _fragmentFavoriteMovieBinding = null
    }

}