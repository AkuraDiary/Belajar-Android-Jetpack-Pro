package com.example.submission2bajpdicoding.ui.movies

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.submission2bajpdicoding.databinding.FragmentMovieBinding
import com.example.submission2bajpdicoding.ui.adapter.KatalogAdapter
import com.example.submission2bajpdicoding.utilities.ViewModelFactory

class FragmentMovie : Fragment() {
    private lateinit var binding : FragmentMovieBinding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentMovieBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        if (activity != null){
            val factory = ViewModelFactory.getInstance(requireActivity())
        }
    }

    /*override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        val binding = view?.let { FragmentMovieBinding.bind(it) }
        val moviesViewModel = ViewModelProvider(this, ViewModelProvider.NewInstanceFactory())[MovieViewModel::class.java]

        if (activity != null){
            val movies = moviesViewModel.getMovies()

            val adapter = KatalogAdapter(EXTRA_CLICK_M)
            adapter.setAll(movies)

            binding?.rvMoviePlaceholder?.apply {
                layoutManager = LinearLayoutManager(context)
                setHasFixedSize(true)
                this.adapter = adapter
            }
        }
    }*/

    companion object{
        const val EXTRA_CLICK_M = 1
    }
}