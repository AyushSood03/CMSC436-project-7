package com.example.project7

class Balloons {
    private lateinit var balloonList : ArrayList<Balloon>
    private var attemptsUsed: Int = 0
    private var attemptsAllowed: Int = 0

    constructor() {
        // The constructor should be empty.
        balloonList = arrayListOf<Balloon>()
    }

    // Adds a balloon to balloonList.
    fun add(balloon: Balloon) {
        balloonList.add(balloon)
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
