package com.example.project7

import android.util.Log

class Balloons {
    private var balloonList : ArrayList<Balloon> = arrayListOf<Balloon>()
    private var attemptsUsed: Int = 0
    private var attemptsAllowed: Int = 0

    constructor() {
        // The constructor should be empty.
    }

    // Adds a balloon to balloonList.
    fun add(balloon: Balloon) {
        balloonList.add(balloon)
    }

    // Runs through each balloon and determines if the click happened within
    // the radius of the balloon.
    fun findBalloonClicked(clickX : Double, clickY : Double) {
        var balloonPopped : Boolean = false

        for (balloon in balloonList) {
            var xPart = Math.pow((clickX - balloon.getX().toDouble()), 2.0)
            var yPart = Math.pow((clickY - balloon.getY().toDouble()), 2.0)
            var distance = Math.sqrt(xPart + yPart)


            if (distance <= balloon.getRadius() && !balloon.isPopped()) {
                balloon.pop()
                balloonPopped = true
            }
        }

        incrementAttempts()
    }

    // Returns the ArrayList of Balloon objects.
    fun getBalloons() : ArrayList<Balloon> {
        return balloonList
    }

    fun incrementAttempts() : Unit {
        attemptsUsed++
    }

    fun setAttemptLimit(limit: Int): Unit {
        attemptsAllowed = limit
    }

    fun gameWon(): Boolean {
        for (balloon in balloonList) {
            if (!balloon.isPopped()) {
                return false
            }
        }
        return true
    }

    fun gameLost(): Boolean {
        return (!gameWon() && (attemptsUsed >= attemptsAllowed))
    }
}
