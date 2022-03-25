package it.fbonfadelli

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test

class RoverTest {

    @Nested
    inner class TurnRight {

        @Test
        internal fun `turn right - from north`() {
            val rover = Rover(State(Position(1, 0), Direction.North))

            val finalState = rover.execute(listOf('r'))

            assertThat(finalState).isEqualTo(State(Position(1, 0), Direction.East))
        }

        @Test
        internal fun `turn right - from east`() {
            val rover = Rover(State(Position(1, 0), Direction.East))

            val finalState = rover.execute(listOf('r'))

            assertThat(finalState).isEqualTo(State(Position(1, 0), Direction.South))
        }

        @Test
        internal fun `turn right - from south`() {
            val rover = Rover(State(Position(1, 0), Direction.South))

            val finalState = rover.execute(listOf('r'))

            assertThat(finalState).isEqualTo(State(Position(1, 0), Direction.West))
        }

        @Test
        internal fun `turn right - from west`() {
            val rover = Rover(State(Position(1, 0), Direction.West))

            val finalState = rover.execute(listOf('r'))

            assertThat(finalState).isEqualTo(State(Position(1, 0), Direction.North))
        }
    }

    @Nested
    inner class TurnLeft {

        @Test
        internal fun `turn left - from north`() {
            val rover = Rover(State(Position(1, 0), Direction.North))

            val finalState = rover.execute(listOf('l'))

            assertThat(finalState).isEqualTo(State(Position(1, 0), Direction.West))
        }

        @Test
        internal fun `turn left - from west`() {
            val rover = Rover(State(Position(1, 0), Direction.West))

            val finalState = rover.execute(listOf('l'))

            assertThat(finalState).isEqualTo(State(Position(1, 0), Direction.South))
        }

        @Test
        internal fun `turn left - from south`() {
            val rover = Rover(State(Position(1, 0), Direction.South))

            val finalState = rover.execute(listOf('l'))

            assertThat(finalState).isEqualTo(State(Position(1, 0), Direction.East))
        }

        @Test
        internal fun `turn left - from east`() {
            val rover = Rover(State(Position(1, 0), Direction.East))

            val finalState = rover.execute(listOf('l'))

            assertThat(finalState).isEqualTo(State(Position(1, 0), Direction.North))
        }
    }

    @Nested
    inner class MoveForward {

        @Test
        internal fun `move forward - from east`() {
            val rover = Rover(State(Position(0, 0), Direction.East))

            val finalState = rover.execute(listOf('f'))

            assertThat(finalState).isEqualTo(State(Position(1, 0), Direction.East))
        }

        @Test
        internal fun `move forward - from east - different x`() {
            val rover = Rover(State(Position(1, 0), Direction.East))

            val finalState = rover.execute(listOf('f'))

            assertThat(finalState).isEqualTo(State(Position(2, 0), Direction.East))
        }

        @Test
        internal fun `move forward - from south`() {
            val rover = Rover(State(Position(0, 0), Direction.South))

            val finalState = rover.execute(listOf('f'))

            assertThat(finalState).isEqualTo(State(Position(0, -1), Direction.South))
        }

        @Test
        internal fun `move forward - from west`() {
            val rover = Rover(State(Position(0, 0), Direction.West))

            val finalState = rover.execute(listOf('f'))

            assertThat(finalState).isEqualTo(State(Position(-1, 0), Direction.West))
        }

        @Test
        internal fun `move forward - from north`() {
            val rover = Rover(State(Position(0, 0), Direction.North))

            val finalState = rover.execute(listOf('f'))

            assertThat(finalState).isEqualTo(State(Position(0, 1), Direction.North))
        }
    }

    @Nested
    inner class MoveBackward {

        @Test
        internal fun `move backward - from east`() {
            val rover = Rover(State(Position(0, 0), Direction.East))

            val finalState = rover.execute(listOf('b'))

            assertThat(finalState).isEqualTo(State(Position(-1, 0), Direction.East))
        }

        @Test
        internal fun `move backward - from south`() {
            val rover = Rover(State(Position(0, 0), Direction.South))

            val finalState = rover.execute(listOf('b'))

            assertThat(finalState).isEqualTo(State(Position(0, 1), Direction.South))
        }

        @Test
        internal fun `move backward - from west`() {
            val rover = Rover(State(Position(0, 0), Direction.West))

            val finalState = rover.execute(listOf('b'))

            assertThat(finalState).isEqualTo(State(Position(1, 0), Direction.West))
        }

        @Test
        internal fun `move backward - from north`() {
            val rover = Rover(State(Position(0, 0), Direction.North))

            val finalState = rover.execute(listOf('b'))

            assertThat(finalState).isEqualTo(State(Position(0, -1), Direction.North))
        }
    }

    @Nested
    inner class MultipleCommands {

        @Test
        internal fun `move forward twice`() {
            val rover = Rover(State(Position(0, 0), Direction.East))

            val finalState = rover.execute(listOf('f', 'f'))

            assertThat(finalState).isEqualTo(State(Position(2, 0), Direction.East))
        }

        @Test
        internal fun `complex case`() {
            val rover = Rover(State(Position(0, 0), Direction.East))

            val finalState = rover.execute(listOf('f', 'f', 'l', 'f', 'l', 'f', 'l', 'f', 'l', 'f', 'r', 'b', 'b', 'b', 'r', 'b', 'l'))

            assertThat(finalState).isEqualTo(State(Position(3, 3), Direction.South))
        }
    }
}
