package learn.nkcoder.scala3book.taste

import scala.io.StdIn.readLine

@main
def helloInteractive(): Unit =
  println("please enter your name: ")
  val name = readLine()

  println("Hello, " + name + "!")

/* scala 2
import scala.io.StdIn.readLine

object helloInteractive {

  def main(args: Array[String]) = {
    println("Please enter your name:")
    val name = readLine()

    println("Hello, " + name + "!")
  }

}
*/
