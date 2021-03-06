package com.example.submission2bajpdicoding.ui.tvShows

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.submission2bajpdicoding.databinding.FragmentTvBinding
import com.example.submission2bajpdicoding.ui.adapter.KatalogAdapter
import com.example.submission2bajpdicoding.utilities.ViewModelFactory

class FragmentTV : Fragment(){

    private lateinit var binding : FragmentTvBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentTvBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        if(activity != null){
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
        }
    }

    companion object{
        const val EXTRA_CLICK_TV = 2
    }
}