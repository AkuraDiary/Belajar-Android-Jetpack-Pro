package com.example.submission3bajpdicoding.ui.tvShows

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import com.example.submission3bajpdicoding.data.source.ItemsRepository
import com.example.submission3bajpdicoding.data.source.local.entity.Items
import com.example.submission3bajpdicoding.utilities.DataDummy
import org.junit.Assert.*

import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito.`when`
import org.mockito.Mockito.verify
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class TvViewModelTest {

    private lateinit var tvViewModel: TvViewModel

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    @Mock
    private lateinit var itemsRepository: ItemsRepository

    @Mock
    private lateinit var observer: Observer<List<Items>>

    @Before
    fun setUp() {
        tvViewModel = TvViewModel(itemsRepository)
    }

    @Test
    fun getTvShows(){
        val itemDummy = DataDummy.generateDummyTvShow()
        val tvShows = MutableLiveData<List<Items>>()
        tvShows.value = itemDummy

        `when`(itemsRepository.getAllTvShows()).thenReturn(tvShows)
        val items =  tvViewModel.getTVShows().value
        verify(itemsRepository).getAllTvShows()
        assertNotNull(items)
        assertEquals(2, items?.size)

        tvViewModel.getTVShows().observeForever(observer)
        verify(observer).onChanged(itemDummy)
    }
}