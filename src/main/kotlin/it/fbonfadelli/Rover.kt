package it.fbonfadelli

data class State(val x: Int, val y: Int, val directionn: Direction = Direction.north)

enum class Direction {
  north,
  south,
  east,
  west
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
      if (state.directionn == Direction.north) Direction.east
      else if (state.directionn == Direction.east) Direction.south
      else if (state.directionn == Direction.south) Direction.west
      else Direction.north

    this.state = this.state.copy(directionn = direction)
  }

  fun turnLeft() {
    // nothing to do on X axis
  }
}
