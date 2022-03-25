package it.fbonfadelli

data class Position(val x: Int, val y: Int)

class Rover(x: Int = 0) {

  private var position: Position

  init {
    position = Position(x, 0)
  }

  fun moveForward() {
    this.position = this.position.copy(x = this.position.x + 1)
  }

  fun getPosition(): Position {
    return this.position
  }

  fun moveBackward() {
    this.position = this.position.copy(x = this.position.x - 1)
  }

  fun turnRight() {
    // nothing to do on X axis
  }

  fun turnLeft() {
    // nothing to do on X axis
  }
}