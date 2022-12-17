package proginscala.chapter9

import java.io.PrintWriter
import java.io.File
import java.util.Date

object HigherOrderFunctions extends App:
  def twice(op: Double => Double, x: Double) = op(op(x))
  println(s"twice: ${twice(_ + 2, 5)}")

  /** In any method invocation in Scala in which you're passing in exactly one argument, you can opt to use curly braces
    * to surround the argument instead of parentheses. The purpose of this ability to substitute curly braces for
    * parentheses for passing in one argument is to enable client programmers to write function literals between curly
    * braces.
    */
  val greet = "Hello World"
  println(greet.charAt(1))
  println(greet.charAt{1})

  /** Any time you find a control pattern repeated in multiple parts of your code, you should think about implementing
    * it as a new control structure.
    */
  def withPrintWriter0(file: File, op: PrintWriter => Unit) =
    val writer = new PrintWriter(file)
    try op(writer)
    finally writer.close

  /** We can use currying to pull the first argument(file) into a separate argument, and leave the function as the lone
    * parameter of the second argument. Then we can use function literals in curly braces.
    */
  def withPrintWriter(file: File)(op: PrintWriter => Unit) =
    val writer = new PrintWriter(file)
    try op(writer)
    finally writer.close

  val file = new File("data.txt")
  withPrintWriter(file)(writer => writer.println(new Date))
