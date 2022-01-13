package com.example.submission3bajpdicoding.ui.detail

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import com.example.submission3bajpdicoding.data.source.ItemsRepository
import com.example.submission3bajpdicoding.data.source.local.entity.Items
import com.example.submission3bajpdicoding.utilities.DataDummy
import com.example.submission3bajpdicoding.vo.Resource
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito.`when`
import org.mockito.Mockito.verify
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class DetailViewModelTest {

    private lateinit var detailViewModel: DetailViewModel
    private val dataDummyMovies = DataDummy.generateDummyMovies()[0]
    private val dataDummyTV = DataDummy.generateDummyTvShow()[0]
    private val tvId = dataDummyTV.id
    private val movieId = dataDummyMovies.id

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    @Mock
    private lateinit var itemsRepository: ItemsRepository

    @Mock
    private lateinit var observer: Observer<Resource<Items>>

    @Before
    fun setUp() {
        detailViewModel = DetailViewModel(itemsRepository)
        detailViewModel.setSelectedMovie(movieId!!)
        detailViewModel.setSelectedTV(tvId!!)
    }

    @Test
    fun getDetailMovie(){
        val movieDetail = Resource.success(dataDummyMovies)
        val movie = MutableLiveData<Resource<Items>>()
        movie.value = movieDetail

        `when`(itemsRepository.getMovieById(movieId!!)).thenReturn(movie)
        detailViewModel.movieDetail.observeForever(observer)
        verify(observer).onChanged(movieDetail)
    }

    @Test
    fun getDetailTv(){
        val tvDetail = Resource.success(dataDummyMovies)
        val movie = MutableLiveData<Resource<Items>>()
        movie.value = tvDetail

        `when`(itemsRepository.getMovieById(movieId!!)).thenReturn(movie)
        detailViewModel.movieDetail.observeForever(observer)
        verify(observer).onChanged(tvDetail)
    }
}