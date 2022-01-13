package com.example.submission3bajpdicoding.data.source

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import com.example.submission3bajpdicoding.data.source.local.LocalDataSource
import com.example.submission3bajpdicoding.data.source.remote.RemoteDataSource
import com.example.submission3bajpdicoding.utilities.AppExecutors
import com.example.submission3bajpdicoding.utilities.DataDummy
import com.example.submission3bajpdicoding.utilities.SortUtils
import org.junit.Rule
import androidx.paging.DataSource
import com.example.submission3bajpdicoding.data.source.local.entity.Items
import com.example.submission3bajpdicoding.util.LiveDataTestUtils
import com.example.submission3bajpdicoding.util.PagedLIstUtils
import com.example.submission3bajpdicoding.vo.Resource
import junit.framework.Assert.assertEquals
import junit.framework.Assert.assertNotNull
import org.junit.Test
import org.mockito.Mockito.*

class ItemRepositoryTest {
    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    private val sort = SortUtils.NEWEST

    private val remote = mock(RemoteDataSource::class.java)
    private val local = mock(LocalDataSource::class.java)
    private val appExecutors = mock(AppExecutors::class.java)

    private val itemRepository = FakeItemRepository(remote, local, appExecutors)

    private val movieResponse = DataDummy.generateDummyMovies()
    private val movieId = movieResponse[0].id

    private val tvResponse = DataDummy.generateDummyTvShow()
    val tvId = tvResponse[0].id

    @Test
    fun getAllMovies(){
        val dummyMovies = mock(DataSource.Factory::class.java) as DataSource.Factory<Int, Items>
        `when`(local.getAllMovies(sort)).thenReturn(dummyMovies)
        itemRepository.getAllMovies(sort)

        val movieItem = Resource.success(PagedLIstUtils.mockPagedList(DataDummy.generateDummyMovies()))
        verify(local).getAllMovies(sort)
        assertNotNull(movieItem.data)
        assertEquals(movieResponse.size.toLong(), movieItem.data?.size?.toLong())
    }

    @Test
    fun getMovieById(){
        val dummyMovie = MutableLiveData<Items>()
        dummyMovie.value = DataDummy.generateDummyMovies()[0]
        `when`(local.getMovie(movieId!!)).thenReturn(dummyMovie)

        val movieItem = LiveDataTestUtils.getValue(itemRepository.getMovieById(movieId)).data
        verify(local).getMovie(movieId)
        val movieResponse = movieResponse[0]

        assertNotNull(movieItem)
        if (movieItem != null){
            assertEquals(movieResponse.id, movieItem.id)
            assertEquals(movieResponse.title, movieItem.title)
            assertEquals(movieResponse.OriginalTitle, movieItem.OriginalTitle)
            assertEquals(movieResponse.ReleaseDate, movieItem.ReleaseDate)
            assertEquals(movieResponse.popularity, movieItem.popularity)
            assertEquals(movieResponse.score, movieItem.score)
            assertEquals(movieResponse.poster, movieItem.poster)
            assertEquals(movieResponse.synopsis, movieItem.synopsis)
            assertEquals(movieResponse.isFavorite, movieItem.isFavorite)
            assertEquals(movieResponse.isTvShow, movieItem.isTvShow)
        }
    }

    @Test
    fun getAllTvShow(){
        val dummyTv = mock(DataSource.Factory::class.java) as DataSource.Factory<Int, Items>
        `when`(local.getAllTvShows(sort)).thenReturn(dummyTv)
        itemRepository.getAllTvShows(sort)

        val tvItems = Resource.success(PagedLIstUtils.mockPagedList((DataDummy.generateDummyTvShow())))
        verify(local).getAllTvShows(sort)
        assertNotNull(tvItems.data)
        assertEquals(tvResponse.size.toLong(), tvItems.data?.size?.toLong())
    }

    @Test
    fun getTvShowId(){
        val dummyTv = MutableLiveData<Items>()
        dummyTv.value = DataDummy.generateDummyTvShow()[0]
        `when`(local.getTvShow(tvId!!)).thenReturn(dummyTv)

        val tvItem = LiveDataTestUtils.getValue(itemRepository.getTvShowsById(tvId)).data
        verify(local).getTvShow(tvId)
        val tvResponse = tvResponse[0]

        assertNotNull(tvItem)
        if (tvItem != null){
            assertEquals(tvResponse.id, tvItem.id)
            assertEquals(tvResponse.title, tvItem.title)
            assertEquals(tvResponse.OriginalTitle, tvItem.OriginalTitle)
            assertEquals(tvResponse.ReleaseDate, tvItem.ReleaseDate)
            assertEquals(tvResponse.popularity, tvItem.popularity)
            assertEquals(tvResponse.score, tvItem.score)
            assertEquals(tvResponse.poster, tvItem.poster)
            assertEquals(tvResponse.synopsis, tvItem.synopsis)
            assertEquals(tvResponse.isFavorite, tvItem.isFavorite)
            assertEquals(tvResponse.isTvShow, tvItem.isTvShow)
        }
    }

    @Test
    fun getFavoriteMovies(){
        val dataFavoriteMovies = mock(DataSource.Factory::class.java) as DataSource.Factory<Int, Items>
        `when` (local.getAllfavoriteMovies()).thenReturn(dataFavoriteMovies)
        itemRepository.getFavoriteMovies()

        val favoriteItem = Resource.success(PagedLIstUtils.mockPagedList(DataDummy.generateDummyMovies()))
        verify(local).getAllfavoriteMovies()
        assertNotNull(favoriteItem.data)
        assertEquals(movieResponse.size.toLong(), favoriteItem.data?.size?.toLong())
    }

    @Test
    fun getFavoriteTvShow(){
        val dataFavoriteTv = mock(DataSource.Factory::class.java) as DataSource.Factory<Int, Items>
        `when`(local.getAllFavoriteTvShow()).thenReturn(dataFavoriteTv)
        itemRepository.getFavoriteTvShow()

        val favoriteTvItems = Resource.success(PagedLIstUtils.mockPagedList(DataDummy.generateDummyTvShow()))
        verify(local).getAllFavoriteTvShow()
        assertNotNull(favoriteTvItems.data)
        assertEquals(tvResponse.size.toLong(), favoriteTvItems.data?.size?.toLong())
    }
}




