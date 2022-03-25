package it.fbonfadelli

class Rover(private var x: Int = 0) {

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