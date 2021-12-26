package com.example.submission2bajpdicoding.tvShows

import com.example.submission2bajpdicoding.R
import com.example.submission2bajpdicoding.data.source.local.entity.Items
import com.example.submission2bajpdicoding.ui.tvShows.TvViewModel
import org.junit.Assert.*

import org.junit.Before
import org.junit.Test

class TvViewModelTest {

    private lateinit var viewModel: TvViewModel
    private lateinit var items: Items

    @Before
    fun setUp() {
        viewModel = TvViewModel()
        items = Items(
            0,
            "Naruto Shippuden",
            "02/15/2007",
            "Animation, Comedy, Drama",
            "25 minutes / episode",
            "87%",
            "Naruto Shippuuden is the continuation of the original animated TV series " +
                    "Naruto.The story revolves around an older and slightly more matured Uzumaki " +
                    "Naruto and his quest to save his friend Uchiha Sasuke from the grips of the " +
                    "snake-like Shinobi, Orochimaru. After 2 and a half years Naruto finally " +
                    "returns to his village of Konoha, and sets about putting his ambitions to " +
                    "work, though it will not be easy, as He has amassed a few (more dangerous) " +
                    "enemies, in the likes of the shinobi organization; Akatsuki.",
            R.drawable.poster_naruto_shipudden
        )
    }

    @Test
    fun getTVShows() {
        assertNotNull(items)
        assertEquals(10, this.viewModel.getTVShows().size)
    }

    @Test
    fun getDetailTV() {
        val choosenItems = viewModel.getDetailTV(0)
        assertNotNull(choosenItems)
        assertEquals(items.id, choosenItems.id)
        assertEquals(items.title, choosenItems.title)
        assertEquals(items.ReleaseDate, choosenItems.ReleaseDate)
        assertEquals(items.OriginalTitle, choosenItems.OriginalTitle)
        assertEquals(items.popularity, choosenItems.popularity)
        assertEquals(items.score, choosenItems.score)
        assertEquals(items.synopsis, choosenItems.synopsis)
        assertEquals(items.poster, choosenItems.poster)
    }
}