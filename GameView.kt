package com.example.project7

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.util.Log
import android.view.MotionEvent
import android.view.View
import java.io.InputStream
import javax.xml.parsers.SAXParser
import javax.xml.parsers.SAXParserFactory

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

        // Parses the balloons XML file. For the final submission, this should be balloons3.xml
        var factory : SAXParserFactory = SAXParserFactory.newInstance()
        var parser : SAXParser = factory.newSAXParser()
        var handler : SAXHandler = SAXHandler()
        var iStream : InputStream = resources.openRawResource(R.raw.balloons3)
        parser.parse(iStream, handler)
        // Assigns the parsed Balloons object to balloons.
        balloons = handler.getBalloons()
    }

    // This activates when the user tap anywhere on the screen. It adjusts and
    // converts the tap coordinates to doubles before calling findBalloonClicked().
    fun whenClicked(e : MotionEvent) {
        var x : Double = e.x.toDouble()
        // I had to manually offset the y-coordinate by 125 because for SOME REASON
        // it kept changing that on me!!! I SPENT ABOUT 1.5 HOURS ON THIS!!!
        var y : Double = e.y.toDouble() - 125
        balloons.findBalloonClicked(x, y)
    }

    // Most of this is just adjustments from my Project 5 - Leo.
    override fun onDraw(canvas : Canvas) {
        super.onDraw(canvas)
        Log.w("MainActivity", "" + height)

        var balloonList : ArrayList<Balloon> = balloons.getBalloons()

        for (balloon in balloonList) {
            if (!balloon.isPopped()) {
                var x : Float = balloon.getX().toFloat()
                var y : Float = balloon.getY().toFloat()
                var radius : Float = balloon.getRadius().toFloat()
                canvas.drawCircle(x, y, radius, paint)
            }
        }
    }
}
