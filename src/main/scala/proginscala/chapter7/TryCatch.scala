package proginscala.chapter7

import java.io.FileReader
import java.io.FileNotFoundException
import java.io.IOException
import java.net.MalformedURLException
import java.net.URL

object TryCatch extends App:

  // In Scala, throw is an expression that has a result type.
  // Technically, an exception throw has type `Nothing`.
  def half(n: Int) =
    if n % 2 == 0 then n / 2
    else throw new RuntimeException("n  must be even")

  println(s"half of 10 = ${half(10)}")
  println(s"half of 11 = ${half(11)}")

  // The syntax for catch clauses was chosen for its consistency with pattern matching.
  // Scala does not require you to catch checked exceptions or declare them in a throws clause,
  // 		you can declare a throws clause if you wish with the @throws annotation, but it is not required.
  def readFile(fileName: String) =
    try
      val f = new FileReader(fileName)
      // use the file
      f.close()
    catch
      case ex: FileNotFoundException => println(s"file: ${fileName} not found")
      case ex: IOException           => println(s"other IO exception: $ex")
  readFile("not-exist-file.txt")

  // As with most other Scala control structures, try-catch-finally results in a value
  def urlFor(path: String) =
    try new URL(path)
    catch case e: MalformedURLException => new URL("http://www.scala-lang.org")

  // Scala's `finally` behavior is different from Java because the statement in `finally` in Java will overrule
  // 	any previous one that originated in the try block or one of its catch clauses.
  // It's usually best to avoid returning values from 'finally' clauses.
  // The best way to think of 'finally' clauses is as a way to ensure some side effect happens, such as
  // 	closing an open file.
  def dummy(x: Int): Int = 
    try 1 / x
    finally println("unexpected error.")



