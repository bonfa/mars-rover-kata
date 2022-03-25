package it.fbonfadelli

class Rover(initialX: Int = 0) {

  private var x: Int = initialX

  fun moveForward() {
    this.x = this.x + 1
  }

  fun getX(): Int {
    return x
  }

  fun moveBackward() {
    this.x = this.x - 1
  }

  fun turnRight() {
    // nothing to do on X axis
  }

  fun turnLeft() {
    // nothing to do on X axis
  }
}