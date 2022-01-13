package com.example.submission3bajpdicoding.ui.movies

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import androidx.paging.PagedList
import com.example.submission3bajpdicoding.data.source.ItemsRepository
import com.example.submission3bajpdicoding.data.source.local.entity.Items
import com.example.submission3bajpdicoding.utilities.DataDummy
import com.example.submission3bajpdicoding.utilities.SortUtils
import com.example.submission3bajpdicoding.vo.Resource
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
    private val sort = SortUtils.NEWEST

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    @Mock
    private lateinit var itemsRepository: ItemsRepository

    @Mock
    private lateinit var observer: Observer<Resource<PagedList<Items>>>

    @Mock
    private lateinit var pagedList: PagedList<Items>

    @Before
    fun setUp() {
        movieViewModel = MovieViewModel(itemsRepository)
    }

    @Test
    fun getMovie(){
        val dataDummy = Resource.success(pagedList)
        `when`(dataDummy.data?.size).thenReturn(2)
        val movie = MutableLiveData<Resource<PagedList<Items>>>()
        movie.value = dataDummy

        `when`(itemsRepository.getAllMovies(sort)).thenReturn(movie)
        val item  = movieViewModel.getMovies(sort).value?.data
        verify(itemsRepository).getAllMovies(sort)

        assertNotNull(item)
        assertEquals(2, item?.size)

        movieViewModel.getMovies(sort).observeForever(observer)
        verify(observer).onChanged(dataDummy)
    }
}