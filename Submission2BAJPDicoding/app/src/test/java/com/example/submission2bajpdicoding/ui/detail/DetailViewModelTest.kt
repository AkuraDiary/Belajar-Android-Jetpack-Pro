package com.example.submission2bajpdicoding.ui.detail

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import com.example.submission2bajpdicoding.data.source.ItemsRepository
import com.example.submission2bajpdicoding.data.source.local.entity.Items
import com.example.submission2bajpdicoding.utilities.DataDummy
import org.junit.Assert.*

import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.Mockito.verify
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class DetailViewModelTest {

    private lateinit var detailViewModel: DetailViewModel
    private val dataDummyMovies = DataDummy.generateDummyMovies()[0]
    private val dataDummyTV = DataDummy.generateDummyTvShow()[0]
    private val tvId = dataDummyTV.id.toString()
    private val movieId = dataDummyMovies.id.toString()

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    @Mock
    private lateinit var itemsRepository: ItemsRepository

    @Mock
    private lateinit var observer: Observer<Items>

    @Before
    fun setUp() {
        detailViewModel = DetailViewModel(itemsRepository)
        detailViewModel.setSelectedMovie(movieId)
        detailViewModel.setSelectedTV(tvId)
    }

    @Test
    fun getDetailMovie(){
        val movie = MutableLiveData<Items>()
        movie.value = dataDummyMovies

        Mockito.`when`(itemsRepository.getMovieById(movieId)).thenReturn(movie)
        val movieItem = detailViewModel.getSelectedMovie(movieId).value as Items
        verify(itemsRepository).getMovieById(movieId)

        assertNotNull(movieItem)

        assertEquals(dataDummyMovies.id, movieItem.id)
        assertEquals(dataDummyMovies.title, movieItem.title)
        assertEquals(dataDummyMovies.OriginalTitle, movieItem.OriginalTitle)
        assertEquals(dataDummyMovies.ReleaseDate, movieItem.ReleaseDate)
        assertEquals(dataDummyMovies.score, movieItem.score)
        assertEquals(dataDummyMovies.popularity, movieItem.popularity)
        assertEquals(dataDummyMovies.synopsis, movieItem.synopsis)
        assertEquals(dataDummyMovies.poster, movieItem.poster)

        detailViewModel.getSelectedMovie(movieId).observeForever(observer)
        verify(observer).onChanged(dataDummyMovies)
    }

    @Test
    fun getDetailTv(){
        val tvShow = MutableLiveData<Items>()
        tvShow.value = dataDummyTV

        Mockito.`when`(itemsRepository.getMovieById(tvId)).thenReturn(tvShow)
        val tvItem = detailViewModel.getSelectedMovie(tvId).value as Items
        verify(itemsRepository).getMovieById(tvId)

        assertNotNull(tvItem)

        assertEquals(dataDummyTV.id, tvItem.id)
        assertEquals(dataDummyTV.title, tvItem.title)
        assertEquals(dataDummyTV.OriginalTitle, tvItem.OriginalTitle)
        assertEquals(dataDummyTV.ReleaseDate, tvItem.ReleaseDate)
        assertEquals(dataDummyTV.score, tvItem.score)
        assertEquals(dataDummyTV.popularity, tvItem.popularity)
        assertEquals(dataDummyTV.synopsis, tvItem.synopsis)
        assertEquals(dataDummyTV.poster, tvItem.poster)

        detailViewModel.getSelectedMovie(tvId).observeForever(observer)
        verify(observer).onChanged(dataDummyTV)
    }
}