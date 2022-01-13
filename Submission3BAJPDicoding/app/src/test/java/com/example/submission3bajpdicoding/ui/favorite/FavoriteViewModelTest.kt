package com.example.submission3bajpdicoding.ui.favorite

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import androidx.paging.PagedList
import com.example.submission3bajpdicoding.data.source.ItemsRepository
import com.example.submission3bajpdicoding.data.source.local.entity.Items
import com.example.submission3bajpdicoding.util.PagedLIstUtils
import org.junit.Assert.*
import org.junit.Before
import org.junit.Rule

import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito.`when`
import org.mockito.Mockito.verify
import java.util.*

class FavoriteViewModelTest {

    private lateinit var viewModel: FavoriteViewModel

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    @Mock
    private lateinit var itemsRepository: ItemsRepository

    @Mock
    private lateinit var observer: Observer<PagedList<Items>>

    @Mock private lateinit var pagedList: PagedList<Items>

    @Before
    fun setUp(){
        viewModel = FavoriteViewModel(itemsRepository)
    }

    @Test
    fun getFavoriteMovies() {
        val dummyMovies = pagedList
        `when`(dummyMovies.size).thenReturn(2)
        val movie = MutableLiveData<PagedList<Items>>()
        movie.value = dummyMovies

        `when`(itemsRepository.getFavoriteMovies()).thenReturn(movie)
        val item = viewModel.getFavoriteMovies().value
        verify(itemsRepository).getFavoriteMovies()
        assertNotNull(item)
        assertEquals(2, item?.size)

        viewModel.getFavoriteMovies().observeForever(observer)
        verify(observer).onChanged(dummyMovies)
    }

    @Test
    fun getFavoriteTvShows() {
        val dummyTv = pagedList
        `when`(dummyTv.size).thenReturn(2)
        val tv = MutableLiveData<PagedList<Items>>()
        tv.value = dummyTv

        `when`(itemsRepository.getFavoriteTvShow()).thenReturn(tv)
        val item = viewModel.getFavoriteTvShows().value
        verify(itemsRepository).getFavoriteTvShow()
        assertNotNull(item)
        assertEquals(2, item?.size)

        viewModel.getFavoriteTvShows().observeForever(observer)
        verify(observer).onChanged(dummyTv)
    }

}