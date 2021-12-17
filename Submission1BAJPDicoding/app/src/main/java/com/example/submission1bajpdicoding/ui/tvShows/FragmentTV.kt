package com.example.submission1bajpdicoding.ui.tvShows

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.submission1bajpdicoding.R

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

        }
    }

    companion object{
        const val EXTRA_CLICK_TV = 2
    }
}