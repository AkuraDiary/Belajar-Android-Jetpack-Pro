package com.example.submission1bajpdicoding.ui.activities

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.submission1bajpdicoding.databinding.ActivitySplashscreenBinding

@SuppressLint("CustomSplashScreen")
class Splashscreen : AppCompatActivity() {

    private lateinit var bindingSplash : ActivitySplashscreenBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bindingSplash = ActivitySplashscreenBinding.inflate(layoutInflater)
        setContentView(bindingSplash.root)

        supportActionBar?.hide() //hiding the action bar
        val background = object :Thread(){
            override fun run() {
                try {
                    /* simulating some workloads here */
                    sleep(2500)
                    /* simulating some workloads here */

                    //continue into next activity
                    val intent = Intent(this@Splashscreen, MainActivity::class.java)
                    startActivity(intent)
                }catch (e : Exception){
                    e.printStackTrace()
                }
            }
        }
        background.start()
    }
}