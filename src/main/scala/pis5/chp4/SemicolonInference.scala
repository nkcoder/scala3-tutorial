package pis5.chp4

/**
  * **The rules of semicolon inference**
    In short, a line ending is treated as a semicolon unless one of the following conditions is true:
    - The line in question ends in a word that would not be legal as the end of a statement, such as a period or an infix operator.
    - The next line begins with a word that cannot start a statement.
    - The line ends while inside parentheses (…) or brackets […], because they cannot contain multiple statements anyway.
  */
object SemicolonInference:

  @main def main(): Unit =
    /* semicolon inference */
    // the semicolon at the end of a statement is usually optional
    val world = "world"
    println(world)

    // a semicolon is required if you write multiple statements on the same line
    val hello = "hello"; println(hello)
