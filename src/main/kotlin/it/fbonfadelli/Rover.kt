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
    val direction =
      if (state.direction == "n") "e"
      else if (state.direction == "e") "s"
      else if (state.direction == "s") "w"
      else "n"

    this.state = this.state.copy(direction = direction)
  }

  fun turnLeft() {
    // nothing to do on X axis
  }
}
