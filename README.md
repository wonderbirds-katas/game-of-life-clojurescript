# Game of Life

Game of Life kata implemented in ClojureScript.

## Overview

The Game of Life will be hosted in a ClojureScript based server. A HTML canvas is used for rendering the game.

## Development

To get an interactive development environment run:

    lein fig:build

This will auto compile and send all changes to the browser without the need to reload. After the compilation process is
complete, you will get a Browser Connected REPL. An easy way to try it is:

    (js/alert "Am I connected?")

and you should see an alert in the browser window.

To clean all compiled files:

	lein clean

To create a production build run:

	lein clean
	lein fig:min

## Links

### Game of Life

- [Wikipedia: Conway's Game of Life](https://en.wikipedia.org/wiki/Conway%27s_Game_of_Life) - contains visualization of
  the different shapes / generators / visual building blocks
- [Canvas visualizing an implementation of the Game of Life](https://playgameoflife.com/) - graphical visualization including rules
- YouTube: Conway's Game of Life in [Dylan Beattie: The Art of Code](https://www.youtube.com/watch?v=6avJHaC3C2U&t=263s) - NDC London, 2020.
- [Kata-Log: Game of Life Kata](https://kata-log.rocks/game-of-life-kata)

### ClojureScript

- [Transforming Data with ClojureScript](https://langintro.com/cljsbook/) - an interactive book on ClojureScript, data processing and the JavaScript canvas API.
- [mdn web docs: Canvas API](https://developer.mozilla.org/en-US/docs/Web/API/Canvas_API) - Mozilla Canvas Web API documentation (MDN).

### Used Libraries

- [core.async](https://github.com/clojure/core.async) - provides a timeout mechanism
