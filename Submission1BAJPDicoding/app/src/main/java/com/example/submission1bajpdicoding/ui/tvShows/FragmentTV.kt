package com.example.submission1bajpdicoding.ui.tvShows

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.submission1bajpdicoding.R
import com.example.submission1bajpdicoding.ui.adapter.KatalogAdapter
import kotlinx.android.synthetic.main.fragment_tv.*

class FragmentTV : Fragment(){

    private lateinit var viewModel : TvViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_tv, container, false)
        //return super.onCreateView(inflater, container, savedInstanceState)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(TvViewModel::class.java)

        if (activity != null){
            val TvShowVM = ViewModelProvider(this, ViewModelProvider.NewInstanceFactory())[TvViewModel::class.java]

            val TvShows = TvShowVM.getTVShows()
            val adapter = KatalogAdapter(EXTRA_CLICK_TV)
            adapter.setAll(TvShows)

            rv_TV_placeholder.apply {
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