package proginscala.chapter8

object Functions extends App:

  /** You can define functions inside other functions. Just like local variables, such local functions are visible only
    * in their enclosing block.
    *
    * Local functions can access the parameters of their enclosing function.
    */
  def padLines(text: String, minWidth: Int): String =
    def padLine(line: String): String =
      if line.length() > minWidth then line
      else line + " " * (minWidth - line.length())
    val padLines = for line <- text.linesIterator yield padLine(line)
    padLines.mkString("\n")

  def firstClassFunction(): Unit =
    /** The => designates that this function converts the parameter on the left (any integer x) to the result of
      * evaluating the expression on the right (x + 1). So this is a function mapping any integer from x to x + 1.
      */
    val increase = (x: Int) => x + 1
    println(s"increase 10 = ${increase(10)}")

    // If you more than one statement in the function literal, just place one statement per line after the => in and
    // indented block
    val addBy5 = (x: Int) =>
      val increment = 5
      x + increment
    println(s"add 10 by 5 = ${addBy5(10)}")

    // foreach and filter on collections
    val data = List(1, 5, -9, 23, 54, 10, -30)
    data.foreach((x: Int) => println(x))
    data.filter((x: Int) => x > 0)

    // You can leave out the type and parentheses as they can be inferred by the compiler
    data.foreach(x => println(x))
    data.filter(x => x > 0)

    // To make a function literal even more concise, you can use underscores as placeholders for one or more parameters, as lone as
    //  each parameter appear only one time in the function literal.
    data.foreach(println)
    data.filter(_ > 0)
    // Sometimes the compiler might not have enough information to infer missing parameter types, you can specify the types using a colon:
    // Multiple underscores mean multiple parameters, not reuse of a single parameter repeatedly.
    val f = (_: Int) + (_: Int)
    println(s"f(5, 6) = ${f(5, 6)}")
