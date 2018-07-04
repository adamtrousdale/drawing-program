package uk.co.adamtrousdale.drawingprogram

import org.scalatest.FunSuite
 
class MainTest extends FunSuite {

  test("draws a canvas with width 20 and height 5") {
    assert(Canvas(20, 5).draw == frame)
  }

  test("draws a horizontal line") {
    val canvas = Canvas(20, 5).line(0, 2, 6, 2).draw
    assert(canvas == horizontalLine)
  }

  test("draws a vertical line") {
    val canvas = Canvas(20, 5).line(6, 0, 6, 2).draw
    assert(canvas == verticalLine)
  }

  test("draws a rectangle") {
    val canvas =
      Canvas(20, 5)
        .rectangle(14, 1, 19, 4).draw
    assert(canvas == rect)
  }

  test("draws a horizontal and vertical line, then adds a rectangle") {
    val canvas =
      Canvas(20, 5)
        .line(0, 2, 6, 2)
        .line(6, 0, 6, 2)
        .rectangle(14, 1, 19, 4).draw
    assert(canvas == multipleLines)
  }

  val frame: String =
    """
      |----------------------
      ||                    |
      ||                    |
      ||                    |
      ||                    |
      ||                    |
      |----------------------
    """.stripMargin.trim

  val horizontalLine: String =
    """
      |----------------------
      ||                    |
      ||                    |
      ||xxxxxxx             |
      ||                    |
      ||                    |
      |----------------------
    """.stripMargin.trim

  val verticalLine: String =
    """
      |----------------------
      ||      x             |
      ||      x             |
      ||      x             |
      ||                    |
      ||                    |
      |----------------------
    """.stripMargin.trim

  val rect: String =
    """
      |----------------------
      ||                    |
      ||              xxxxxx|
      ||              x    x|
      ||              x    x|
      ||              xxxxxx|
      |----------------------
    """.stripMargin.trim

  val multipleLines: String =
    """
      |----------------------
      ||      x             |
      ||      x       xxxxxx|
      ||xxxxxxx       x    x|
      ||              x    x|
      ||              xxxxxx|
      |----------------------
    """.stripMargin.trim

}
