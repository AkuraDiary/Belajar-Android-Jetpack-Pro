package com.example.submission3bajpdicoding.ui.movies

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.paging.PagedList
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.submission3bajpdicoding.data.source.local.entity.Items
import com.example.submission3bajpdicoding.databinding.FragmentMovieBinding
import com.example.submission3bajpdicoding.ui.adapter.KatalogAdapter
import com.example.submission3bajpdicoding.ui.adapter.MovieAdapter
import com.example.submission3bajpdicoding.utilities.ViewModelFactory
import com.example.submission3bajpdicoding.vo.Resource
import org.koin.androidx.viewmodel.ext.android.viewModel

class FragmentMovie : Fragment() {
    private lateinit var binding : FragmentMovieBinding

    private lateinit var moviesAdapter : MovieAdapter
    private val viewModel : MovieViewModel by viewModel()

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

        moviesAdapter = MovieAdapter()

        /*if (activity != null){
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
        }*/

    }

    private fun setList(sort : String){
        viewModel.getMovies(sort).observe(requireActivity(), moviesObserver)
    }

    private val moviesObserver = Observer<Resource<PagedList<Items>>>{
        TODO("belum di buat")
    }

    companion object{
        const val EXTRA_CLICK_M = 1
    }
}