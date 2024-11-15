package com.example.project7
//Team Members: Will Duis, Ayush Sood, Leo Suber

import android.graphics.Rect
import android.os.Bundle
import android.text.method.Touch
import android.util.Log
import android.view.GestureDetector
import android.view.MotionEvent
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    private lateinit var gameView : GameView
    private lateinit var detector : GestureDetector
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
        // Log.w("MainActivity", "Top: " + (height - rectangle.top))

        gameView = GameView(this, width, height - rectangle.top)
        balloons = gameView.getBalloons()
        setContentView(gameView)

        var th : TouchHandler = TouchHandler()
        detector = GestureDetector(this, th)
    }

    // Apparently, this is necessary for the taps to be detected.
    override fun onTouchEvent(event: MotionEvent?): Boolean {
        if (event != null)
            detector.onTouchEvent(event)
        return super.onTouchEvent(event)
    }

    inner class TouchHandler : GestureDetector.SimpleOnGestureListener() {
        // The method that triggers when the user taps on anything.
        override fun onSingleTapConfirmed(e: MotionEvent): Boolean {
            gameView.whenClicked(e)
            balloons = gameView.getBalloons()
            if (balloons.gameWon()) {
                Toast.makeText(this@MainActivity, "YOU WON", Toast.LENGTH_LONG).show()
            }
            if (balloons.gameLost()) {
                finish()
            }
            updateView()
            return super.onSingleTapConfirmed(e)
        }
    }
}
