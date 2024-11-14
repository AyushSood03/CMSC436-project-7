package com.example.project7

class Balloon {
    private var x : Int = 0
    private var y : Int = 0
    private var radius : Int = 0
    private var popped : Boolean = false

    constructor() {
        // The constructor should be empty.
    }

    // Sets the X coordinate of the balloon.
    fun setX(newX : Int) {
        x = newX
    }

    // Sets the Y coordinate of the balloon.
    fun setY(newY : Int) {
        y = newY
    }

    // Sets the radius of the balloon.
    fun setRadius(newRadius : Int) {
        radius = newRadius
    }

    // Returns the X coordinate of the balloon.
    fun getX() : Int {
        return x
    }

    // Returns the X coordinate of the balloon.
    fun getY() : Int {
        return y
    }

    // Returns the X coordinate of the balloon.
    fun getRadius() : Int {
        return radius
    }

    fun isPopped(): Boolean {
        return popped
    }

    fun pop(): Unit {
        popped = true
    }
}
