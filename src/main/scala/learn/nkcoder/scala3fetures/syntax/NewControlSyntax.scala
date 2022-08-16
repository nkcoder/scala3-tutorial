package learn.nkcoder.scala3fetures.syntax

/**
 * Scala 3 has a new "quiet" syntax for control expressions that does not rely on enclosing the condition in
 * parentheses, and also allows to drop parentheses or braces around the generators of a for-expression.
 *
 * Rules:
 * - The condition of an if-expression can be written without enclosing parentheses if it is followed by a then.
 * - The condition of a while-loop can be written without enclosing parentheses if it is followed by a do.
 * - The enumerators of a for-expression can be written without enclosing parentheses or braces if they are followed
 * by a yield or do.
 * - A do in a for-expression expresses a for-loop.
 */
object NewControlSyntax extends App :
  // The condition of an if-expression can be written without enclosing parentheses if it is followed by a then.
  def ifFunc(x: Int): String =
    if x < 0 then
      "negative"
    else if x == 0 then
      "zero"
    else
      "positive"

  def ifFunc2(x: Int): String = if x < 0 then "negative" else if x == 0 then "zero" else "positive"

  def ifFunc2WithParentheses(x: Int): String = if (x < 0) "negative" else if (x == 0) "zero" else "positive"


  // The condition of a while-loop can be written without enclosing parentheses if it is followed by a do.
  // do...while is dropped in scala 3
  def whileDoFunc(x: Int) = while x > 0 do ifFunc(x)

  def whileDoFuncWithParentheses(x: Int) = while (x > 0) ifFunc(x)


  // The enumerators of a for-expression can be written without enclosing parentheses or braces if they are followed
  // * by a yield or do.
  def forYieldFunc(xs: List[Int]): List[Int] = for x <- xs if x > 0 yield x * x

  def forDoFunc(xs: List[Int], ys: List[Int]): Unit =
    for
      x <- xs
      y <- ys
    do
      println(x * y)

  def forFunc(xs: List[Int]): Unit = for (x <- xs) print(x)


  println(s"ifFunc(3)=${ifFunc(3)}")
  println(s"ifFunc2(3)=${ifFunc2(3)}")
  println(s"whileDoFunc(0)=${whileDoFunc(0)}")
  println(s"forYieldFunc(List[Int])=${forYieldFunc(List(1, 2, 3))}")
  println(s"forDoFunc(List[Int], List[Int])=${forDoFunc(List(1, 2, 3), List(4, 5, 6))}")




