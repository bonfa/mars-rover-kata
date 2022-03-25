package it.fbonfadelli

data class State(val x: Int, val y: Int, val directionn: Direction = Direction.North)

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
    val direction =
      if (state.directionn == Direction.North) Direction.East
      else if (state.directionn == Direction.East) Direction.South
      else if (state.directionn == Direction.South) Direction.West
      else Direction.North

    this.state = this.state.copy(directionn = direction)
  }

  fun turnLeft() {
    // nothing to do on X axis
  }
}
