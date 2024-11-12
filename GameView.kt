package com.example.project7

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.view.View

class GameView: View {
    private lateinit var paint : Paint

    private var width : Int = 0
    private var height : Int = 0
    private lateinit var balloons : Balloons

    constructor(context: Context, width : Int, height : Int): super(context) {
        this.width = width
        this.height = height
        paint = Paint()
        paint.isAntiAlias = true
        paint.color = Color.BLUE
        paint.strokeWidth = 20.0f
        paint.textSize = 70f

        TODO("Assign balloons.")
    }

    // Most of this is just adjustments from my Project 5 - Leo.
    override fun onDraw(canvas : Canvas) {
        super.onDraw(canvas)

        var balloonList : ArrayList<Balloon> = balloons.getBalloons()

        for (balloon in balloonList) {
            var x : Float = balloon.getX().toFloat()
            var y : Float = balloon.getY().toFloat()
            var radius : Float = balloon.getRadius().toFloat()
            canvas.drawCircle(x, y, radius, paint)
        }
        // Drawing the balloons.
    }
}
