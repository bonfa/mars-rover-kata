package it.fbonfadelli

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test

class RoverTest {

/*
AXIS
  - command [F,B,L,R] - X
  - number of commands [1,2, ..., n]
  - world dimension [1,2]
  -

* hardcoded starting position and direction - move forward only - x-axis only
* different starting position - move forward only - x-axis only
* */

    @Test
    internal fun `move forward`() {
        val rover = Rover(State(0, 0, directionn = Direction.North))
        rover.moveForward()

        val position = rover.getPosition()

        assertThat(position).isEqualTo(State(1, 0, directionn = Direction.North))
    }

    @Test
    internal fun `move forward - different starting position`() {
        val rover = Rover(State(1, 0, directionn = Direction.North))
        rover.moveForward()

        val position = rover.getPosition()

        assertThat(position).isEqualTo(State(2, 0, directionn = Direction.North))
    }

    @Test
    internal fun `move forward twice`() {
        val rover = Rover(State(1, 0, directionn = Direction.North))
        rover.moveForward()
        rover.moveForward()

        val position = rover.getPosition()

        assertThat(position).isEqualTo(State(3, 0, directionn = Direction.North))
    }

    @Test
    internal fun `move backward`() {
        val rover = Rover(State(1, 0, directionn = Direction.North))
        rover.moveBackward()

        val position = rover.getPosition()

        assertThat(position).isEqualTo(State(0, 0, directionn = Direction.North))
    }

    @Nested
    inner class TurnRight {
        @Test
        internal fun `turn right - from north`() {
            val rover = Rover(State(1, 0, directionn = Direction.North))
            rover.turnRight()

            val position = rover.getPosition()

            assertThat(position).isEqualTo(State(1, 0, Direction.East))
        }

        @Test
        internal fun `turn right - from east`() {
            val rover = Rover(State(1, 0, Direction.East))
            rover.turnRight()

            val position = rover.getPosition()

            assertThat(position).isEqualTo(State(1, 0, Direction.South))
        }

        @Test
        internal fun `turn right - from south`() {
            val rover = Rover(State(1, 0, Direction.South))
            rover.turnRight()

            val position = rover.getPosition()

            assertThat(position).isEqualTo(State(1, 0, Direction.West))
        }

        @Test
        internal fun `turn right - from west`() {
            val rover = Rover(State(1, 0, Direction.West))
            rover.turnRight()

            val position = rover.getPosition()

            assertThat(position).isEqualTo(State(1, 0, directionn = Direction.North))
        }
    }

    @Test
    internal fun `turn left`() {
        val rover = Rover(State(1, 0, directionn = Direction.North))
        rover.turnLeft()

        val position = rover.getPosition()

        assertThat(position).isEqualTo(State(1, 0, directionn = Direction.North))
    }
}
