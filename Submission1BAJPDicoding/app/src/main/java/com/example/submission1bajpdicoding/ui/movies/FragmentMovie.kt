package com.example.submission1bajpdicoding.ui.movies

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.submission1bajpdicoding.R
import com.example.submission1bajpdicoding.ui.adapter.KatalogAdapter

class FragmentMovie : Fragment() {

    private lateinit var viewModel: MovieViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_movie, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        val moviesViewModel = ViewModelProvider(this, ViewModelProvider.NewInstanceFactory())[MovieViewModel::class.java]

        val movies = moviesViewModel.getMovies()

        val adapter = KatalogAdapter(EXTRA_CLICK_M)

    }

    companion object{
        const val EXTRA_CLICK_M = 1
    }
}