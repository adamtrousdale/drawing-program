drawing-program
=====

A small command line application to draw a canvas and then add lines and rectangles to it.

## To run

```bash
> sbt run
> enter command:
```

## To test

```bash
> sbt test
```

| Command | Description |
|---|---|
| ```C w h```  | Create a new canvas of width w and height h   |
| ```L x1 y1 x2 y2```  | Draw a new line from coordinates (x1, y1) to (x2, y2) horizontally or vertically. Lines are made up of the x character  |
| ```R x1 y1 x2 y2```  | Draw a new rectangle, with upper left corner at coordinate (x1, y1) and lower right coordinate at (x2, y2). Lines are made up of the x character  |
| ```Q``` | Quit the program |


## Example commands

```bash
enter command: C 20 5
----------------------
|                    |
|                    |
|                    |
|                    |
|                    |
----------------------
enter command: L 1 3 7 3
----------------------
|                    |
|                    |
|xxxxxxx             |
|                    |
|                    |
----------------------
enter command: L 7 1 7 3
----------------------
|      x             |
|      x             |
|xxxxxxx             |
|                    |
|                    |
----------------------
enter command: R 15 2 20 5
----------------------
|      x             |
|      x       xxxxxx|
|xxxxxxx       x    x|
|              x    x|
|              xxxxxx|
----------------------
enter command: Q
```
