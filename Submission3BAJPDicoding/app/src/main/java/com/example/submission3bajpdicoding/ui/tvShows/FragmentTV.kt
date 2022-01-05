package com.example.submission3bajpdicoding.ui.tvShows

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.paging.PagedList
import com.example.submission3bajpdicoding.data.source.local.entity.Items
import com.example.submission3bajpdicoding.databinding.FragmentTvBinding
import com.example.submission3bajpdicoding.ui.adapter.TvShowAdapter
import com.example.submission3bajpdicoding.utilities.SortUtils
import com.example.submission3bajpdicoding.vo.Resource
import com.example.submission3bajpdicoding.vo.Status

class FragmentTV : Fragment(){

    private lateinit var binding : FragmentTvBinding
    private lateinit var viewModel : TvViewModel
    private lateinit var _adapter: TvShowAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentTvBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    private val tvShowObserver = Observer<Resource<PagedList<Items>>>{ tvShow ->
        if (tvShow != null){
            when(tvShow.status){
                Status.SUCCESS -> {
                    _adapter.submitList(tvShow.data)
                    _adapter.notifyDataSetChanged()
                }
                Status.ERROR->{
                    Toast.makeText(context, "Error", Toast.LENGTH_SHORT).show()
                }
            }
        }
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        _adapter = TvShowAdapter()
        setList(SortUtils.NEWEST)

        with(binding.rvTVPlaceholder){
            this.setHasFixedSize(true)
            this.adapter = _adapter
        }


        /*if(activity != null){
            val factory = ViewModelFactory.getInstance()
            val viewModel = ViewModelProvider(this, factory)[TvViewModel::class.java]
            val tvAdapter = KatalogAdapter(EXTRA_CLICK_TV)
            viewModel.getTVShows().observe(viewLifecycleOwner, {items ->
                tvAdapter.setAll(items)
                tvAdapter.notifyDataSetChanged()
            })
            with(binding.rvTVPlaceholder){
                layoutManager = LinearLayoutManager(context)
                setHasFixedSize(true)
                adapter = tvAdapter
            }
        }*/
    }

    private fun setList(newest : String){
        viewModel.getTVShows(newest).observe(requireActivity(), tvShowObserver)
    }

    companion object{
        const val EXTRA_CLICK_TV = 2
    }
}