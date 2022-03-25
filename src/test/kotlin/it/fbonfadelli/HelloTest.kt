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

  class Rover(initialX: Int = 0) {
    private var x: Int = initialX

      fun moveForward() {
          this.x = this.x + 1
        }

        fun getX():Int  {
            return x
        }
    }
}
