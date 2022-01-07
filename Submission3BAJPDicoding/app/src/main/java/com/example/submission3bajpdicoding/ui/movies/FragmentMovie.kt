package com.example.submission3bajpdicoding.ui.movies

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.paging.PagedList
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.submission3bajpdicoding.data.source.local.entity.Items
import com.example.submission3bajpdicoding.databinding.FragmentMovieBinding
import com.example.submission3bajpdicoding.ui.adapter.MovieAdapter
import com.example.submission3bajpdicoding.utilities.SortUtils
import com.example.submission3bajpdicoding.vo.Resource
import com.example.submission3bajpdicoding.vo.Status
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

        setList(SortUtils.NEWEST)

        binding.progressBar.visibility = View.VISIBLE

        with(binding.rvMoviePlaceholder){
            layoutManager = LinearLayoutManager(context)
            this.setHasFixedSize(true)
            this.adapter = moviesAdapter
        }

    }

    private fun setList(sort : String){
        viewModel.getMovies(sort).observe(requireActivity(), moviesObserver)
    }

    private val moviesObserver = Observer<Resource<PagedList<Items>>>{
        movieItem -> if(movieItem != null){
            when(movieItem.status){
                Status.LOADING -> binding.progressBar.visibility = View.VISIBLE
                Status.SUCCESS -> {
                    binding.progressBar.visibility = View.GONE
                    moviesAdapter.submitList(movieItem.data)
                    moviesAdapter.notifyDataSetChanged()
                }
                Status.ERROR -> {
                    binding.progressBar.visibility = View.GONE
                    Toast.makeText(context, "There is an Error", Toast.LENGTH_SHORT).show()
                }
            }
        }
    }

    companion object{
        const val EXTRA_CLICK_M = 1
    }
}