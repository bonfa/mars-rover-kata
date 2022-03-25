package it.fbonfadelli

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
    this.state = moveBackward(state)
  }
}

data class Position(val x: Int, val y: Int)

data class State(val position: Position, val direction: Direction = Direction.North)

enum class Direction {
  North,
  South,
  East,
  West
}

private fun moveForward(state: State): State =
  state.copy(position = moveForwardMap[state.direction]!!.invoke(state.position))

private fun moveBackward(state: State): State =
  state.copy(position = moveBackwardMap[state.direction]!!.invoke(state.position))

private fun rotateRight(state: State): State =
  state.copy(direction = rightRotationMap[state.direction]!!)

private fun rotateLeft(state: State): State =
  state.copy(direction = leftRotationMap[state.direction]!!)

private val incrementX: (Position) -> Position = { position -> position.copy(x = position.x + 1) }
private val decrementX: (Position) -> Position = { position -> position.copy(x = position.x - 1) }
private val incrementY: (Position) -> Position = { position -> position.copy(y = position.y + 1) }
private val decrementY: (Position) -> Position = { position -> position.copy(y = position.y - 1) }

val moveForwardMap = mapOf(
  Direction.North to incrementY,
  Direction.West to decrementX,
  Direction.South to decrementY,
  Direction.East to incrementX,
)

val moveBackwardMap = mapOf(
  Direction.North to decrementY,
  Direction.West to incrementX,
  Direction.South to incrementY,
  Direction.East to decrementX,
)

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
