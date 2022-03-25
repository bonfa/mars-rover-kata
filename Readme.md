Solution in TDD of mars-rover-kata.

#Comments
- By looking at the commits it is possible to see how the solution has been built incrementally
- I tried to maintain as much cohesion as possible while refactoring, and using a functional approach whenever I could
- As a result, all the operations have the same signature: they receive a state and return a state (updated) and they also are based on a map, even if the ones of linear movements are a bit more complicated
- All the functions are pure functions and the state change is isolated inside the Rover class, whose only responsibility is to orchestrate everything and keep the last version of the state updated.  

#Kata Description
You’re part of the team that explores Mars by sending remotely controlled vehicles to the surface of the planet. Develop an API that translates the commands sent from earth to instructions that are understood by the rover.

##Requirements
You are given the initial starting point (x,y) of a rover and the direction (N,S,E,W) it is facing.
The rover receives a character array of commands.
- Implement commands that move the rover forward/backward (f,b).
- Implement commands that turn the rover left/right (l,r).
- Implement wrapping at edges. But be careful, planets are spheres. Connect the x edge to the other x edge, so (1,1) for x-1 to (5,1), but connect vertical edges towards themselves in inverted coordinates, so (1,1) for y-1 connects to (5,1).
- Implement obstacle detection before each move to a new square. If a given sequence of commands encounters an obstacle, the rover moves up to the last possible point, aborts the sequence and reports the obstacle.


#Link
https://kata-log.rocks/mars-rover-katas