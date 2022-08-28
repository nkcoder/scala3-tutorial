package learn.nkcoder.scala3book.taste

import scala.util.Random

@main def controlStructures(): Unit =
  // if...else...
  val x = Random.nextInt()
  if x > 0 then
    println("positive")
  else if x < 0 then
    println("negative")
  else
    println("zero")

  /* Scala 2
  if (x > 0) {
    println("positive")
  } else if (x < 0) {
    println("negative")
  } else {
    println("zero")
  }
  */

  // for...do loop
  val ints = List(1, 3, 4, 6, 8, 9)
  for i <- ints do println(i)
  // scala 2
  // for (i <- ints) println(i)

  for {
    i <- 1 to 3
    j <- 'a' to 'z'
    if i % 2 == 0
    if j < 'c'
  }
  do
    println(s"i = $i, j = $j")

  /* scala 2
  for {
    i <- 1 to 3
    j <- 'a' to 'z'
    if i % 2 == 0
    if j < 'c'
  } println(s"i = $i, j = $j")
  */

  // for...yield expression
  val fruits = List("apple", "banana", "pear", "orange")
  val fruitsCapitalized = for
    f <- fruits
    if f.length > 3
  yield
    f.capitalize
  println(s"fruitsCapitalized = $fruitsCapitalized")

  // match...case
  def getClassAsString(x: Matchable): String = x match
    case s: String => s"$s is a String"
    case _: Int => "Int"
    case _: Double => "Double"
    case _: Long => "Long"
    case _ => "Unknown"

  println(getClassAsString("Hello"))
  println(getClassAsString(10))
  println(getClassAsString(10.0D))
  println(getClassAsString(10L))
  println(getClassAsString(10.0F))

  // try...catch...finally
  try
    println(s"10/0 = ${10 / 0}")
  catch
    case ae: ArithmeticException => println(s"Got an ArithmeticException: ${ae.getMessage}")
    case nfe: NumberFormatException => println(s"Got a NumberFormatException: ${nfe.getMessage}")
  finally
    println("cleanup your resources here")


  // while...do loop
  var r = Random.nextInt(5)
  while r > 0 do
    println(r)
    r = r - 1

/* scala 2
while (r > 0) {
  println(r)
  r = r - 1
}
*/









