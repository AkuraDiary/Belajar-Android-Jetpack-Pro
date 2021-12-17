package com.example.submission1bajpdicoding.utilities

import com.example.submission1bajpdicoding.R
import com.example.submission1bajpdicoding.models.Items

object DataDummy {
    val listOfMovies = ArrayList<Items>()
    val listOfTV = ArrayList<Items>()



    fun getMovie(): ArrayList<Items> {

        listOfMovies.add(
            Items(
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
        )

        listOfMovies.add(
            Items(
                1,
                "Aquaman",
                "21/12/2018",
                "Action, Adventure, Fantasy",
                "2 hours 24 minutes",
                "69%",
                "Once home to the most advanced civilization on Earth, Atlantis is now an " +
                        "underwater kingdom ruled by the power-hungry King Orm. With a vast army at " +
                        "his disposal, Orm plans to conquer the remaining oceanic people and then " +
                        "the surface world. Standing in his way is Arthur Curry, Orms half-human, " +
                        "half-Atlantean brother and true heir to the throne.",
                R.drawable.poster_aquaman
            )
        )

        listOfMovies.add(
            Items(
                2,
                "Fantastic Beasts: The Crimes of Grindelwald",
                "16/11/2018",
                "Adventure, Fantasy, Drama",
                "2 hours 14 minutes",
                "69%",
                "Gellert Grindelwald has escaped imprisonment and has begun gathering " +
                        "followers to his cause—elevating wizards above all non-magical beings. The " +
                        "only one capable of putting a stop to him is the wizard he once called his" +
                        " closest friend, Albus Dumbledore. However, Dumbledore will need to seek" +
                        "help from the wizard who had thwarted Grindelwald once before, his former " +
                        "student Newt Scamander, who agrees to help, unaware of the dangers that lie " +
                        "ahead. Lines are drawn as love and loyalty are tested, even among the truest" +
                        " friends and family, in an increasingly divided wizarding world.",
                R.drawable.poster_crimes
            )
        )

        listOfMovies.add(
            Items(
                3,
                "Avengers: Infinity War",
                "27/04/2018",
                "Adventure, Action, Science Fiction",
                "2 hours 29 minutes",
                "83%",
                "As the Avengers and their allies have continued to protect the world from " +
                        "threats too large for any one hero to handle, a new danger has emerged from" +
                        " the cosmic shadows: Thanos. A despot of intergalactic infamy, his goal is " +
                        "to collect all six Infinity Stones, artifacts of unimaginable power, and " +
                        "use them to inflict his twisted will on all of reality. Everything the " +
                        "Avengers have fought for has led up to this moment - the fate of Earth and " +
                        "existence itself has never been more uncertain.",
                R.drawable.poster_infinity_war
            )
        )

        listOfMovies.add(
            Items(
                4,
                "Alita: Battle Angle",
                "14/02/2019",
                "Action, Science Fiction, Adventure",
                "2 hours 2 minutes",
                "71%",
                "When Alita awakens with no memory of who she is in a future world she does " +
                        "not recognize, she is taken in by Ido, a compassionate doctor who realizes " +
                        "that somewhere in this abandoned cyborg shell is the heart and soul of a " +
                        "young woman with an extraordinary past.",
                R.drawable.poster_alita
            )
        )

        listOfMovies.add(
            Items(
                5,
                "How to Train Your Dragon: The Hidden World",
                "22/02/2019",
                "Animation, Family, Adventure",
                "1 hour 44 minutes",
                "78%",
                "As Hiccup fulfills his dream of creating a peaceful dragon utopia, Toothless’ " +
                        "discovery of an untamed, elusive mate draws the Night Fury away. When danger" +
                        " mounts at home and Hiccup’s reign as village chief is tested, both dragon " +
                        "and rider must make impossible decisions to save their kind.",
                R.drawable.poster_how_to_train
            )
        )

        listOfMovies.add(
            Items(
                6,
                "Glass",
                "18/01/2019",
                "Thriller, Drama, Science Fiction",
                "2 hours 9 minutes",
                "66%",
                "In a series of escalating encounters, former security guard David Dunn uses " +
                        "his supernatural abilities to track Kevin Wendell Crumb, a disturbed man who" +
                        " has twenty-four personalities. Meanwhile, the shadowy presence of Elijah " +
                        "Price emerges as an orchestrator who holds secrets critical to both men.",
                R.drawable.poster_glass
            )
        )

        listOfMovies.add(
            Items(
                7,
                "Overlord",
                "9/11/2018",
                "Horror, War, Science Fiction",
                "1 hour 50 minutes",
                "67%",
                "France, June 1944. On the eve of D-Day, some American paratroopers fall " +
                        "behind enemy lines after their aircraft crashes while on a mission to destroy" +
                        " a radio tower in a small village near the beaches of Normandy. After reaching" +
                        " their target, the surviving paratroopers realise that, in addition to fighting " +
                        "the Nazi troops that patrol the village, they also must fight against something else.",
                R.drawable.poster_overlord
            )
        )

        listOfMovies.add(
            Items(
                8,
                "Spider-Man: Into the Spider-Verse",
                "14/12/2018",
                "Action, Adventure, Animation, Science Fiction, Comedy",
                "1 hour 57 minutes",
                "84%",
                "Miles Morales is juggling his life between being a high school student and " +
                        "being a spider-man. When Wilson Kingpin Fisk uses a super collider, others" +
                        " from across the Spider-Verse are transported to this dimension.",
                R.drawable.poster_spiderman
            )
        )

        listOfMovies.add(
            Items(
                9,
                "Ralph Breaks the Internet",
                "21/11/2018",
                "Family, Animation, Comedy, Adventure",
                "1 hour 52 minutes",
                "72%",
                "Video game bad guy Ralph and fellow misfit Vanellope von Schweetz must risk " +
                        "it all by traveling to the World Wide Web in search of a replacement part " +
                        "to save Vanellopes video game, Sugar Rush. In way over their heads, Ralph " +
                        "and Vanellope rely on the citizens of the internet — the netizens — to help " +
                        "navigate their way, including an entrepreneur named Yesss, who is the head " +
                        "algorithm and the heart and soul of trend-making site BuzzzTube.",
                R.drawable.poster_ralph
            )
        )

        return listOfMovies
    }

    fun movieDetails(id:Int){
        TODO("Not yet Implemented")
    }

    fun getTVShow(){
        TODO("Not yet Implemented")
    }
    fun tvShowDetails(id:Int){
        TODO("Not yet Implemented")
    }
}