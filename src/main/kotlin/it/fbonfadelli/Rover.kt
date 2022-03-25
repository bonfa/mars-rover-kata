package it.fbonfadelli

data class Position(val x: Int, val y: Int, val direction: String)

class Rover(private var position: Position) {

  fun getPosition(): Position {
    return this.position
  }

  fun moveForward() {
    this.position = this.position.copy(x = this.position.x + 1)
  }

  fun moveBackward() {
    this.position = this.position.copy(x = this.position.x - 1)
  }

  fun turnRight() {
    this.position = this.position.copy(direction = "e")
  }

  fun turnLeft() {
    // nothing to do on X axis
  }
}