package com.example.project7

import android.util.Log
import org.xml.sax.Attributes
import org.xml.sax.helpers.DefaultHandler

class SAXHandler : DefaultHandler() {

    private var balloons : Balloons = Balloons()
    private var validText : Boolean = false
    private var currentBalloon : Balloon? = null
    private var element : String = ""

    override fun startElement(uri: String?, localName: String?, qName: String?, attributes: Attributes?) {
        super.startElement(uri, localName, qName, attributes)
        
        validText = true
        if(qName != null) {
            element = qName
            if(element.equals("balloon")) {
                currentBalloon = Balloon()
            }
        }
    }

    override fun endElement(uri: String?, localName: String?, qName: String?) {
        super.endElement(uri, localName, qName)
        
        validText = false
        if(currentBalloon != null && qName != null && qName.equals("balloon")) {
            balloons.add(currentBalloon!!)
            Log.w("MainActivity", "x: " + currentBalloon!!.getX().toString() + ", y: " + currentBalloon!!.getY().toString()  + ", radius: " + currentBalloon!!.getRadius().toString())
        }
        balloons.setAttemptLimit(balloons.getBalloons().size + 3)
    }

    override fun characters(ch: CharArray?, start: Int, length: Int) {
        super.characters(ch, start, length)
        
        if(ch != null) {
            var text: String = String(ch!!, start, length)
            
            if (currentBalloon != null && element.equals("x") && validText) {
                currentBalloon!!.setX(text.toInt())
            }
            else if (currentBalloon != null && element.equals("y") && validText) {
              currentBalloon!!.setY(text.toInt())
            }
            else if (currentBalloon != null && element.equals("radius") && validText) {
              currentBalloon!!.setRadius(text.toInt())
            }
        }
    }

    fun getBalloons() : Balloons {
        return balloons
    }
}
