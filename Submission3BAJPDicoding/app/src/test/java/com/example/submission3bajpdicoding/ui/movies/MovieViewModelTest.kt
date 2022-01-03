package com.example.submission3bajpdicoding.ui.movies

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
class MovieViewModelTest {

    private lateinit var movieViewModel: MovieViewModel

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    @Mock
    private lateinit var itemsRepository: ItemsRepository

    @Mock
    private lateinit var observer: Observer<List<Items>>

    @Before
    fun setUp() {
        movieViewModel = MovieViewModel(itemsRepository)
    }

    @Test
    fun getMovie(){
        val dataDummyMovie = DataDummy.generateDummyMovies()
        val movie = MutableLiveData<List<Items>>()
        movie.value = dataDummyMovie

        `when`(itemsRepository.getAllMovies()).thenReturn(movie)
        val items = movieViewModel.getMovies().value
        verify(itemsRepository).getAllMovies()
        assertNotNull(items)
        assertEquals(2, items?.size)

        movieViewModel.getMovies().observeForever(observer)
        verify(observer).onChanged(dataDummyMovie)
    }
}