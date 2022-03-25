package it.fbonfadelli

data class State(val x: Int, val y: Int, val direction: String)

class Rover(private var state: State) {

  fun getPosition(): State {
    return this.state
  }

  fun moveForward() {
    this.state = this.state.copy(x = this.state.x + 1)
  }

  fun moveBackward() {
    this.state = this.state.copy(x = this.state.x - 1)
  }

  fun turnRight() {
    this.state = this.state.copy(direction = "e")
  }

  fun turnLeft() {
    // nothing to do on X axis
  }
}