package com.example.submission1bajpdicoding.ui.movies

import com.example.submission1bajpdicoding.R
import com.example.submission1bajpdicoding.models.Items
import org.junit.Assert.*

import org.junit.Before
import org.junit.Test

class MovieViewModelTest {

    private lateinit var viewModel: MovieViewModel
    private lateinit var items: Items

    @Before
    fun setUp() {
        viewModel = MovieViewModel()
        items = Items(
            0,
            "Bohemian Rhapsody",
            "02/11/2018",
            "Drama, Music",
            "2 hours 15 minutes",
            "80%",
            "Singer Freddie Mercury, guitarist Brian May, drummer Roger Taylor and bass " +
                    "guitarist John Deacon take the music world by storm when they form the rock " +
                    " and roll band Queen in 1970. Hit songs become instant classics. When Mercury" +
                    " s increasingly wild lifestyle starts to spiral out of control, Queen soon " +
                    "faces its greatest challenge yet – finding a way to keep the band together " +
                    "amid the success and excess.",
            R.drawable.poster_bohemian
        )
    }

    @Test
    fun getMovies() {
        assertNotNull(items)
        assertEquals(10, viewModel.getMovies().size)
    }

    @Test
    fun getDetailMovie() {
        val choosenItems = viewModel.getDetailMovie(0)
        assertNotNull(choosenItems)
        assertEquals(items.id, choosenItems?.id)
        assertEquals(items.judul, choosenItems?.judul)
        assertEquals(items.waktuRelease, choosenItems?.waktuRelease)
        assertEquals(items.genre, choosenItems?.genre)
        assertEquals(items.durasi, choosenItems?.durasi)
        assertEquals(items.score, choosenItems?.score)
        assertEquals(items.sinopsis, choosenItems?.sinopsis)
        assertEquals(items.poster, choosenItems?.poster)
    }
}