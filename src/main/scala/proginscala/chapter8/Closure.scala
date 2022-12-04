package proginscala.chapter8

object Closure extends App:

  /** The function value (the object) that's created at runtime from this function literal is called a closure.
    */
  var more = 5
  val addMore = (x: Int) => x + more
  println(s"addMore by 7 = ${addMore(7)}")

  // If the variable captured changes after the closure is created, then the closure sees the change
  more = 8
  println(s"addMore by 7 after more changes: ${addMore(7)}")

  // Changes made by a closure to a captured variable are visible outside the closure
  val numbers = List(9, 11, -14, -23, 30)
  var sum = 0
  numbers.foreach(sum += _)
  println(s"sum = $sum")

  // The captured variable instance used is the one that was active at the time the closure was created.
  def makeIncreaser(more: Int) = (x: Int) => x + more
  // Each time the function is called it will create a new closure, which will access the more variable that was active
  //  when the closure was created.
  val inc1 = makeIncreaser(1)
  val inc999 = makeIncreaser(999)
  println(s"inc1 by 5 = ${inc1(5)}")
  println(s"inc999 by 5 = ${inc999(5)}")
