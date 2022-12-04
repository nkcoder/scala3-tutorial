package proginscala.chapter8

object SpecialForms extends App:
  /** To denote a repeated parameter, place an asterisk(*) after the type of the parameter. SCala allows you to indicate
    * that the last parameter to a function may be repeated.
    *
    * The type of the repeated parameter is a Seq of the declared type of the parameter. But you cannot pass Seq[]
    * directly, you have to append the sequence argument with a asterisk(*) symbol. This notation tells the compiler to
    * pass each elements of seq as its own argument, rather than all of it as a single argument.
    */
  def echo(args: String*) =
    for arg <- args do println(arg)
  echo("hi")
  echo("hello", "world")
  echo("hello", "world", "!")
  val argSeq = Seq("hello", "world", "!!")
  echo(argSeq*)
  val argList = List("hello", "world", "!!!")
  echo(argList*)

  /** Named arguments allow you to pass arguments to a function in different order. Name arguments are most frequently
    * used in combination with default parameter values.
    */
  def speed(distance: Float, time: Float) = distance / time
  println(s"speed = ${speed(120, 13)}")
  println(s"speed = ${speed(distance = 120, time = 13)}")
  println(s"speed = ${speed(time = 13, distance = 120)}")
  // It is possible to mix positional and named arguments: positional arguments come first.
  println(s"speed = ${speed(120, time = 15)}")

  /** Scala lets you specify default values for function parameters. The argument for such a parameter can optionally be
    * omitted from a function call, in which case the corresponding argument will be filled in with the default.
    */
  def point(x: Int = 0, y: Int = 0) = (x, y)
  println(point(3, 4))
  println(point(x = 3, y = 4))
  println(point(x = 4))
  println(point(y = 6))
