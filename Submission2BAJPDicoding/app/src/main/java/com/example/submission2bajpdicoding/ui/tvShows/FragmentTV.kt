package com.example.submission2bajpdicoding.ui.tvShows

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.submission2bajpdicoding.R
import com.example.submission2bajpdicoding.databinding.FragmentTvBinding
import com.example.submission2bajpdicoding.ui.adapter.KatalogAdapter

class FragmentTV : Fragment(){

    private lateinit var viewModel : TvViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_tv, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this)[TvViewModel::class.java]
        val binding = view?.let { FragmentTvBinding.bind(it) }
        if (activity != null){
            val tvShowVM = ViewModelProvider(this, ViewModelProvider.NewInstanceFactory())[TvViewModel::class.java]

            val tvShows = tvShowVM.getTVShows()
            val adapter = KatalogAdapter(EXTRA_CLICK_TV)
            adapter.setAll(tvShows)

            binding?.rvTVPlaceholder?.apply {
                layoutManager = LinearLayoutManager(context)
                setHasFixedSize(true)
                this.adapter = adapter
            }

        }
    }

    companion object{
        const val EXTRA_CLICK_TV = 2
    }
}