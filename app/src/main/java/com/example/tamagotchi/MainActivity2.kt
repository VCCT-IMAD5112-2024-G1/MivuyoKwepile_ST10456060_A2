package com.example.tamagotchi

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView

class MainActivity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        val feedButton = findViewById<Button>(R.id.feedButton)
        val playButton = findViewById<Button>(R.id.playButton)
        val cleanButton = findViewById<Button>(R.id.cleanButton)
        val imageView2: ImageView = findViewById(R.id.imageView2)
        val textView5 = findViewById<TextView>(R.id.textView5)
        val textView6 = findViewById<TextView>(R.id.textView6)
        val textView7 = findViewById<TextView>(R.id.textView7)

        feedButton.setOnClickListener {
            // Change ImageView to show image for "Feed"
            imageView2.setImageResource(R.drawable.mame5)
            textView5.text = "80%"
        }

        cleanButton.setOnClickListener {
            // Change ImageView to show image for "Clean"
            imageView2.setImageResource(R.drawable.mame3)
            textView6.text = "50%"
        }

        playButton.setOnClickListener {
            // Change ImageView to show image for "Happy"
            imageView2.setImageResource(R.drawable.mame4)
            textView7.text = "75%"
        }
    }
}