package com.example.submission2bajpdicoding.utilities

import com.example.submission2bajpdicoding.data.source.local.entity.Items

object DataDummy {

    fun generateDummyMovies(): List<Items> {
        val movies = ArrayList<Items>()
        movies.add(
            Items(
                464052,
                "Wonder Woman 1984",
                "2020-12-16",
                "Wonder Woman 1984",
                4167.11,
                7.3,
                "Wonder Woman comes into conflict with the Soviet Union during the Cold War in the 1980s and finds a formidable foe by the name of the Cheetah.",
                "/8UlWHLMpgZm9bx6QYh0NFoq67TZ.jpg"
            )
        )
        movies.add(
            Items(
                508442,
                "Soul",
                "Soul",
                "2020-12-25",
                3283.36,
                8.4,
                "Joe Gardner is a middle school teacher with a love for jazz music. After a successful gig at the Half Note Club, he suddenly gets into an accident that separates his soul from his body and is transported to the You Seminar, a center in which souls develop and gain passions before being transported to a newborn child. Joe must enlist help from the other souls-in-training, like 22, a soul who has spent eons in the You Seminar, in order to get back to Earth.",
                "/hm58Jw4Lw8OIeECIq5qyPYhAeRJ.jpg",
            )
        )
        return movies
    }

    fun generateDummyTvShow(): List<Items> {
        val tvShow = ArrayList<Items>()
        tvShow.add(
            Items(
                77169,
                "Cobra Kai",
                "2018-05-02",
                "Cobra Kai",
                1495.092,
                8.1,
                "This Karate Kid sequel series picks up 30 years after the events of the 1984 All Valley Karate Tournament and finds Johnny Lawrence on the hunt for redemption by reopening the infamous Cobra Kai karate dojo. This reignites his old rivalry with the successful Daniel LaRusso, who has been working to maintain the balance in his life without mentor Mr. Miyagi.",
                "/obLBdhLxheKg8Li1qO11r2SwmYO.jpg"
            )
        )
        tvShow.add(
            Items(
                79242,
                "Chilling Adventures of Sabrina",
                "2018-10-26",
                "Chilling Adventures of Sabrina",
                8.4,
                1097.927,
                "As her 16th birthday nears, Sabrina must choose between the witch world of her family and the human world of her friends. Based on the Archie comic.",
                "/yxMpoHO0CXP5o9gB7IfsciilQS4.jpg",
            )
        )
        return tvShow
    }

}