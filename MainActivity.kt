package com.example.project7
//Team Members: Will Duis, Ayush Sood, Leo Suber

import android.graphics.Rect
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    private lateinit var gameView : GameView
    private lateinit var balloons : Balloons

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)

        buildViewByCode()
        updateView()
    }

    fun updateView() {
        gameView.postInvalidate()
    }

    // The function that builds the view (mostly taken from my Project 5) - Leo.
    fun buildViewByCode() {
        var width : Int = resources.displayMetrics.widthPixels
        var height : Int = resources.displayMetrics.heightPixels

        val rectangle : Rect = Rect(0, 0, 0, 0)
        window.decorView.getWindowVisibleDisplayFrame(rectangle)

        gameView = GameView(this, width, height - rectangle.top)
        setContentView(gameView)
    }
}
