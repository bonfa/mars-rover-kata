package it.fbonfadelli

import org.assertj.core.api.Assertions.assertThat
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
        val rover = Rover(Position(0, 0, "n"))
        rover.moveForward()

        val position = rover.getPosition()

        assertThat(position).isEqualTo(Position(1, 0, "n"))
    }

    @Test
    internal fun `move forward - different starting position`() {
        val rover = Rover(position = Position(1, 0, direction = "n"))
        rover.moveForward()

        val position = rover.getPosition()

        assertThat(position).isEqualTo(Position(2, 0, "n"))
    }

    @Test
    internal fun `move forward twice`() {
        val rover = Rover(position = Position(1, 0, direction = "n"))
        rover.moveForward()
        rover.moveForward()

        val position = rover.getPosition()

        assertThat(position).isEqualTo(Position(3, 0, "n"))
    }

    @Test
    internal fun `move backward`() {
        val rover = Rover(position = Position(1, 0, direction = "n"))
        rover.moveBackward()

        val position = rover.getPosition()

        assertThat(position).isEqualTo(Position(0, 0, "n"))
    }

    @Test
    internal fun `turn right`() {
        val rover = Rover(position = Position(1, 0, "n"))
        rover.turnRight()

        val position = rover.getPosition()

        assertThat(position).isEqualTo(Position(1, 0, "e"))
    }

    @Test
    internal fun `turn left`() {
        val rover = Rover(position = Position(1, 0, direction = "n"))
        rover.turnLeft()

        val position = rover.getPosition()

        assertThat(position).isEqualTo(Position(1, 0, "n"))
    }
}
