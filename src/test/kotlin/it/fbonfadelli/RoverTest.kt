package it.fbonfadelli

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test

class RoverTest {

/*
AXIS
  - world dimension [1,2] - [X]
  - command [F,B,L,R] - WIP
  - number of commands [1,2, ..., n]
  -

* hardcoded starting position and direction - move forward only - x-axis only
* different starting position - move forward only - x-axis only
* */

    @Test
    internal fun `move forward twice`() {
        val rover = Rover(State(1, 0, Direction.East))
        rover.moveForward()
        rover.moveForward()

        val position = rover.getState()

        assertThat(position).isEqualTo(State(3, 0, Direction.East))
    }

    @Nested
    inner class TurnRight {

        @Test
        internal fun `turn right - from north`() {
            val rover = Rover(State(1, 0, Direction.North))
            rover.turnRight()

            val position = rover.getState()

            assertThat(position).isEqualTo(State(1, 0, Direction.East))
        }

        @Test
        internal fun `turn right - from east`() {
            val rover = Rover(State(1, 0, Direction.East))
            rover.turnRight()

            val position = rover.getState()

            assertThat(position).isEqualTo(State(1, 0, Direction.South))
        }

        @Test
        internal fun `turn right - from south`() {
            val rover = Rover(State(1, 0, Direction.South))
            rover.turnRight()

            val position = rover.getState()

            assertThat(position).isEqualTo(State(1, 0, Direction.West))
        }

        @Test
        internal fun `turn right - from west`() {
            val rover = Rover(State(1, 0, Direction.West))
            rover.turnRight()

            val position = rover.getState()

            assertThat(position).isEqualTo(State(1, 0, Direction.North))
        }
    }

    @Nested
    inner class TurnLeft {

        @Test
        internal fun `turn left - from north`() {
            val rover = Rover(State(1, 0, Direction.North))
            rover.turnLeft()

            val position = rover.getState()

            assertThat(position).isEqualTo(State(1, 0, Direction.West))
        }

        @Test
        internal fun `turn left - from west`() {
            val rover = Rover(State(1, 0, Direction.West))
            rover.turnLeft()

            val position = rover.getState()

            assertThat(position).isEqualTo(State(1, 0, Direction.South))
        }

        @Test
        internal fun `turn left - from south`() {
            val rover = Rover(State(1, 0, Direction.South))
            rover.turnLeft()

            val position = rover.getState()

            assertThat(position).isEqualTo(State(1, 0, Direction.East))
        }

        @Test
        internal fun `turn left - from east`() {
            val rover = Rover(State(1, 0, Direction.East))
            rover.turnLeft()

            val position = rover.getState()

            assertThat(position).isEqualTo(State(1, 0, Direction.North))
        }
    }

    @Nested
    inner class MoveForward {
        @Test
        internal fun `move forward - from east`() {
            val rover = Rover(State(0, 0, Direction.East))
            rover.moveForward()

            val position = rover.getState()

            assertThat(position).isEqualTo(State(1, 0, Direction.East))
        }

        @Test
        internal fun `move forward - from east - different x`() {
            val rover = Rover(State(1, 0, Direction.East))
            rover.moveForward()

            val position = rover.getState()

            assertThat(position).isEqualTo(State(2, 0, Direction.East))
        }

        @Test
        internal fun `move forward - from south`() {
            val rover = Rover(State(0, 0, Direction.South))
            rover.moveForward()

            val position = rover.getState()

            assertThat(position).isEqualTo(State(0, -1, Direction.South))
        }

        @Test
        internal fun `move forward - from west`() {
            val rover = Rover(State(0, 0, Direction.West))
            rover.moveForward()

            val position = rover.getState()

            assertThat(position).isEqualTo(State(-1, 0, Direction.West))
        }

        @Test
        internal fun `move forward - from north`() {
            val rover = Rover(State(0, 0, Direction.North))
            rover.moveForward()

            val position = rover.getState()

            assertThat(position).isEqualTo(State(0, 1, Direction.North))
        }
    }

    @Nested
    inner class MoveBackward {
        @Test
        internal fun `move backward - from east`() {
            val rover = Rover(State(0, 0, Direction.East))
            rover.moveBackward()

            val position = rover.getState()

            assertThat(position).isEqualTo(State(-1, 0, Direction.East))
        }

        @Test
        internal fun `move backward - from south`() {
            val rover = Rover(State(0, 0, Direction.South))
            rover.moveBackward()

            val position = rover.getState()

            assertThat(position).isEqualTo(State(0, 1, Direction.South))
        }

        @Test
        internal fun `move backward - from west`() {
            val rover = Rover(State(0, 0, Direction.West))
            rover.moveBackward()

            val position = rover.getState()

            assertThat(position).isEqualTo(State(1, 0, Direction.West))
        }

        @Test
        internal fun `move backward - from north`() {
            val rover = Rover(State(0, 0, Direction.North))
            rover.moveBackward()

            val position = rover.getState()

            assertThat(position).isEqualTo(State(0, -1, Direction.North))
        }
    }
}
