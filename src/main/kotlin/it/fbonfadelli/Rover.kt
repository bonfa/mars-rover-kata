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
    this.state = moveForward(state)
  }

  fun turnRight() {
    this.state = rotateRight(this.state)
  }

  fun turnLeft() {
    this.state = rotateLeft(this.state)
  }

  fun moveBackward() {
    this.state = this.state.copy(x = this.state.x - 1)
  }

  companion object {

    private fun moveForward(state: State): State =
      when (state.direction) {
        Direction.North -> state.copy(y = state.y + 1)
        Direction.West -> state.copy(x = state.x - 1)
        Direction.South -> state.copy(y = state.y - 1)
        else -> state.copy(x = state.x + 1)
      }

    private fun rotateRight(state: State): State =
      state.copy(direction = rightRotationMap[state.direction]!!)

    private fun rotateLeft(state: State): State =
      state.copy(direction = leftRotationMap[state.direction]!!)
  }
}
