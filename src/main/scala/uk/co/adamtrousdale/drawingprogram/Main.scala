package uk.co.adamtrousdale.drawingprogram

import scala.annotation.tailrec

object Main extends App {

  @tailrec
  def readInput(canvasOpt: Option[Canvas]): Any = {

    val c = """C (\d+) (\d+)""".r
    val l = """L (\d+) (\d+) (\d+) (\d+)""".r
    val r = """R (\d+) (\d+) (\d+) (\d+)""".r

    val a = scala.io.StdIn.readLine("enter command: ")

    a match {

      case c(w, h) =>
        val canvas = Canvas(w.toInt, h.toInt)
        println(canvas.draw)
        readInput(Some(canvas))

      case l(x1, y1, x2, y2) =>
        canvasOpt match {
          case Some(canvas) =>
            val newCanvas = canvas.line(x1.toInt - 1, y1.toInt - 1, x2.toInt - 1, y2.toInt - 1)
            println(newCanvas.draw)
            readInput(Some(newCanvas))
          case None =>
            println(s"You need to create a canvas first")
            readInput(None)
        }

      case r(x1, y1, x2, y2) =>
        canvasOpt match {
          case Some(canvas) =>
            val newCanvas = canvas.rectangle(x1.toInt - 1, y1.toInt - 1, x2.toInt - 1, y2.toInt - 1)
            println(newCanvas.draw)
            readInput(Some(newCanvas))
          case None =>
            println(s"You need to create a canvas first")
            readInput(None)
        }

      case "Q" => System.exit(0)

      case _ =>
        println(s"Input not recognised")
        readInput(canvasOpt)

    }

  }

  readInput(None)

}
