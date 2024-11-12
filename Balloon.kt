package com.example.project7

class Balloons {
    private lateinit var balloonList : ArrayList<Balloon>

    constructor() {
        // The constructor should be empty.
    }

    // Adds a balloon to balloonList.
    fun add(balloon: Balloon) {
        balloonList.add(balloon)
    }

    // Returns the ArrayList of Balloon objects.
    fun getBalloons() : ArrayList<Balloon> {
        return balloonList
    }
}
