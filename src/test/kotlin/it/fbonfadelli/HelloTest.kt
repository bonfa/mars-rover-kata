package it.fbonfadelli

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class HelloTest {

/*
AXIS
  - command [F,B,L,R]
  - number of commands [1,2, ..., n]
  - world dimension [1,2]
  -

* hardcoded starting position and direction - move forward only - x-axis only
* different starting position - move forward only - x-axis only
* */

    @Test
    internal fun `hardcoded starting position and direction - move forward only - x-axis only`() {
        val rover = Rover()
        rover.moveForward()

        val position = rover.getX()

        assertThat(position).isEqualTo(1)
    }

    @Test
    internal fun `different starting position - move forward only - x-axis only`() {
        val rover = Rover(1)
        rover.moveForward()

        val position = rover.getX()

        assertThat(position).isEqualTo(2)
    }

    @Test
    internal fun `different starting position - move forward many times - x-axis only`() {
        val rover = Rover(1)
        rover.moveForward()
        rover.moveForward()

        val position = rover.getX()

        assertThat(position).isEqualTo(3)
    }

    @Test
    internal fun `different starting position - move backward only - x-axis only`() {
        val rover = Rover(1)
        rover.moveBackward()

        val position = rover.getX()

        assertThat(position).isEqualTo(0)
    }

    @Test
    internal fun `different starting position - turn right - x-axis only`() {
        val rover = Rover(1)
        rover.turnRight()

        val position = rover.getX()

        assertThat(position).isEqualTo(1)
    }

    @Test
    internal fun `different starting position - turn left - x-axis only`() {
        val rover = Rover(1)
        rover.turnLeft()

        val position = rover.getX()

        assertThat(position).isEqualTo(1)
    }


    class Rover(initialX: Int = 0) {
        private var x: Int = initialX

        fun moveForward() {
            this.x = this.x + 1
        }

        fun getX():Int  {
            return x
        }

        fun moveBackward() {
            this.x = this.x - 1
        }

        fun turnRight() {
            // nothing to do on X axis
        }

        fun turnLeft() {
            // nothing to do on X axis
        }
    }
}

