package it.fbonfadelli

data class State(val x: Int, val y: Int, val direction: Direction = Direction.North)

enum class Direction {
  North,
  South,
  East,
  West
}

val rightRotationMap = mapOf(
  Direction.North to Direction.East,
  Direction.East to Direction.South,
  Direction.South to Direction.West,
  Direction.West to Direction.North,
)

val leftRotationMap = mapOf(
  Direction.North to Direction.West,
  Direction.West to Direction.South,
  Direction.South to Direction.East,
  Direction.East to Direction.North,
)

class Rover(private var state: State) {

  fun getState(): State {
    return this.state
  }

  fun moveForward() {
    if (this.state.direction == Direction.North)
      this.state = this.state.copy(y = this.state.y + 1)

    else if (this.state.direction == Direction.West)
      this.state = this.state.copy(x = this.state.x - 1)

    else if (this.state.direction == Direction.South)
      this.state = this.state.copy(y = this.state.y - 1)

    else this.state = this.state.copy(x = this.state.x + 1)
  }

  fun moveBackward() {
    this.state = this.state.copy(x = this.state.x - 1)
  }

  fun turnRight() {
    this.state = rotateRight(this.state)
  }

  fun turnLeft() {
    this.state = rotateLeft(this.state)
  }

  companion object {

    private fun rotateRight(state: State): State {
      return state.copy(direction = rightRotationMap[state.direction]!!)
    }

    private fun rotateLeft(state: State): State {
      return state.copy(direction = leftRotationMap[state.direction]!!)
    }
  }
}