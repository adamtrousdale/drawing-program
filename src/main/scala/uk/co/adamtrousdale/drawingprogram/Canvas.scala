package uk.co.adamtrousdale.drawingprogram

case class Canvas(width: Int, height: Int, current: Seq[Char]) {

  def draw: String = {
    val frame = s"${"-" * (width + 2)}"
    val sides = (0 until height)
      .map(a => current.mkString.substring(a * width, a * width + width))
      .map(b => s"|$b|")
      .mkString("\n")

    s"$frame\n$sides\n$frame"
  }

  def fill(x: Int, y: Int): Canvas = {
    val sanitisedX = if (x < 0) 0 else if (x < width) x else width - 1
    val sanitisedY = if (y < 0) 0 else if (y < height) y else height - 1

    val location = sanitisedX + sanitisedY * width

    Canvas(width, height, current.mkString.substring(0, location) ++ "x" ++ current.mkString.substring(location + 1))
  }

  // adds a line to the current canvas, between the passed in values
  def line(x1: Int, y1: Int, x2: Int, y2: Int): Canvas = {
    val xCoords = if (x1 < x2) x1 to x2 else x2 to x1
    val yCoords = if (y1 < y2) y1 to y2 else y2 to y1

    if (xCoords.length > 1 && yCoords.length > 1) {
      throw new IllegalArgumentException("Lines can't be diagonal")
    } else {
      val coords = xCoords.flatMap(x => yCoords.map(y => (x, y)))
      coords.foldLeft(this)((canvas, xy) => canvas.fill(xy._1, xy._2))
    }
  }

  // add a rectangle with the top left (x1, y1) and bottom right (x2, y2)
  def rectangle(x1: Int, y1: Int, x2: Int, y2: Int): Canvas = {
    val coords = Seq(
      (x1, y1, x2, y1), // Top side
      (x2, y1, x2, y2), // Right side
      (x1, y2, x2, y2), // Bottom side
      (x1, y1, x1, y2) // Left side
    )
    coords.foldLeft(this)((canvas, coordinates) => canvas.line(coordinates._1, coordinates._2, coordinates._3, coordinates._4))
  }

}

object Canvas {
  def apply(width: Int, height: Int): Canvas = Canvas(width, height, " " * (width * height))
}
