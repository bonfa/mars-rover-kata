package it.fbonfadelli

import it.fbonfadelli.Rover.Direction.*

class Rover(private var state: State) {
  fun execute(commands: List<Char>): State {
    val applyCommands = commands.map { commandMap[it]!! }.reduce { acc, command -> { state -> command(acc(state)) } }

    this.state = applyCommands(this.state)
    return this.state
  }

  data class State(val position: Position, val direction: Direction)

  data class Position(val x: Int, val y: Int)

  enum class Direction {
    North,
    South,
    East,
    West
  }

  private val moveForward: (State) -> State = { state -> state.copy(position = moveForwardMap[state.direction]!!.invoke(state.position)) }
  private val moveBackward: (State) -> State = { state -> state.copy(position = moveBackwardMap[state.direction]!!.invoke(state.position)) }
  private val rotateRight: (State) -> State = { state -> state.copy(direction = rightRotationMap[state.direction]!!) }
  private val rotateLeft: (State) -> State = { state -> state.copy(direction = leftRotationMap[state.direction]!!) }

  private val commandMap = mapOf(
    'r' to rotateRight,
    'l' to rotateLeft,
    'f' to moveForward,
    'b' to moveBackward,
  )

  private val incrementX: (Position) -> Position = { position -> position.copy(x = position.x + 1) }
  private val decrementX: (Position) -> Position = { position -> position.copy(x = position.x - 1) }
  private val incrementY: (Position) -> Position = { position -> position.copy(y = position.y + 1) }
  private val decrementY: (Position) -> Position = { position -> position.copy(y = position.y - 1) }

  private val moveForwardMap = mapOf(
    North to incrementY,
    West to decrementX,
    South to decrementY,
    East to incrementX,
  )

  private val moveBackwardMap = mapOf(
    North to decrementY,
    West to incrementX,
    South to incrementY,
    East to decrementX,
  )

  private val rightRotationMap = mapOf(
    North to East,
    East to South,
    South to West,
    West to North,
  )

  private val leftRotationMap = mapOf(
    North to West,
    West to South,
    South to East,
    East to North,
  )
}


