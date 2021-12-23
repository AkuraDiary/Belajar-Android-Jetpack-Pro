package com.example.myidlingresource

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import com.example.myidlingresource.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var activityMainBinding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        activityMainBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(activityMainBinding.root)

        activityMainBinding.button.setOnClickListener{
            delay1()
        }
    }

    private fun delay1(){
        Handler(Looper.getMainLooper()).postDelayed({
            activityMainBinding.textView.text = getString(R.string.delay1)
        }, 2000)
    }
}