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
            val factory = ViewModelFactory.getInstance()
            val viewModel = ViewModelProvider(this, factory)[MovieViewModel::class.java]
            val movieAdapter = KatalogAdapter(EXTRA_CLICK_M)

            viewModel.getMovies().observe(viewLifecycleOwner, { movies ->
                movieAdapter.setAll(movies)
                movieAdapter.notifyDataSetChanged()
            })

            with(binding.rvMoviePlaceholder) {
                layoutManager = LinearLayoutManager(context)
                setHasFixedSize(true)
                adapter = movieAdapter
            }
        }
    }

    companion object{
        const val EXTRA_CLICK_M = 1
    }
}