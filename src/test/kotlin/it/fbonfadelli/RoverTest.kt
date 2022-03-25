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
    internal fun `hardcoded starting position and direction - move forward only - x-axis only`() {
        val rover = Rover(Position(0, 0))
        rover.moveForward()

        val position = rover.getPosition()

        assertThat(position).isEqualTo(Position(1, 0))
    }

    @Test
    internal fun `different starting position - move forward only - x-axis only`() {
        val rover = Rover(position = Position(1, 0))
        rover.moveForward()

        val position = rover.getPosition()

        assertThat(position).isEqualTo(Position(2, 0))
    }

    @Test
    internal fun `different starting position - move forward many times - x-axis only`() {
        val rover = Rover(position = Position(1, 0))
        rover.moveForward()
        rover.moveForward()

        val position = rover.getPosition()

        assertThat(position).isEqualTo(Position(3, 0))
    }

    @Test
    internal fun `different starting position - move backward only - x-axis only`() {
        val rover = Rover(position = Position(1, 0))
        rover.moveBackward()

        val position = rover.getPosition()

        assertThat(position).isEqualTo(Position(0, 0))
    }

    @Test
    internal fun `different starting position - turn right - x-axis only`() {
        val rover = Rover(position = Position(1, 0))
        rover.turnRight()

        val position = rover.getPosition()

        assertThat(position).isEqualTo(Position(1, 0))
    }

    @Test
    internal fun `different starting position - turn left - x-axis only`() {
        val rover = Rover(position = Position(1, 0))
        rover.turnLeft()

        val position = rover.getPosition()

        assertThat(position).isEqualTo(Position(1, 0))
    }


}
