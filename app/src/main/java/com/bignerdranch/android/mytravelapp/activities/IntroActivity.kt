package com.bignerdranch.android.mytravelapp.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.constraintlayout.widget.ConstraintLayout
import com.bignerdranch.android.mytravelapp.R

class IntroActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_intro)

        //retrieve ID for Constraint Layout that is responsible for being an intro button
        val intro: ConstraintLayout = findViewById(R.id.introBtn)
        intro.setOnClickListener {
            Log.d("MainActivity", "Get Started button clicked")

            //after clicking on the Constraint Layout, the MainActivity is triggered, we see another page
            startActivity(Intent(this@IntroActivity, MainActivity::class.java))
        }
    }
}