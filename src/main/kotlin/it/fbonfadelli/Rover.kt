package it.fbonfadelli

data class State(val x: Int, val y: Int, val direction: Direction = Direction.North)

enum class Direction {
  North,
  South,
  East,
  West
}

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
    this.state = rotateRight(this.state)
  }

  fun turnLeft() {
    // nothing to do on X axis
  }

  companion object {

    private fun rotateRight(state: State): State {
      val direction = when (state.direction) {
        Direction.North -> Direction.East
        Direction.East -> Direction.South
        Direction.South -> Direction.West
        else -> Direction.North
      }

      return state.copy(direction = direction)
    }
  }
}
