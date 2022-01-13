package com.example.submission3bajpdicoding.ui.tvShows

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import androidx.paging.PagedList
import com.example.submission3bajpdicoding.data.source.ItemsRepository
import com.example.submission3bajpdicoding.data.source.local.entity.Items
import com.example.submission3bajpdicoding.utilities.DataDummy
import com.example.submission3bajpdicoding.utilities.SortUtils
import com.example.submission3bajpdicoding.vo.Resource
import okhttp3.internal.notify
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
        tvViewModel = TvViewModel(itemsRepository)
    }

    @Test
    fun getTvShows(){
        val dataDummy = Resource.success(pagedList)
        `when`(dataDummy.data?.size).thenReturn(2)
        val tv = MutableLiveData<Resource<PagedList<Items>>>()
        tv.value = dataDummy

        `when`(itemsRepository.getAllTvShows(sort)).thenReturn(tv)
        val item  = tvViewModel.getTVShows(sort).value?.data
        verify(itemsRepository).getAllTvShows(sort)

        assertNotNull(item)
        assertEquals(2, item?.size)

        tvViewModel.getTVShows(sort).observeForever(observer)
        verify(observer).onChanged(dataDummy)
    }
}