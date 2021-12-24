package com.example.submission2bajpdicoding.ui.tvShows

import androidx.lifecycle.ViewModel
import com.example.submission2bajpdicoding.models.Items
import com.example.submission2bajpdicoding.utilities.DataDummy

class TvViewModel: ViewModel() {
    fun getTVShows() : List<Items>{
        return DataDummy.getTVShow()
    }

    fun getDetailTV(id : Int):Items?{
        return DataDummy.tvShowDetails(id)
    }

}