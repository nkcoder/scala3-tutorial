package proginscala.chapter8

/** SAM: single abstract method Scala allows a function type to be used where an instance of a class or trait declaring
  * a single abstract method(SAM) is required.
  */
object SamTypes extends App:

  trait Increaser:
    def increase(i: Int): Int

  def increaseOne(increaser: Increaser): Int = increaser.increase(1)

  // You can pass in an anonymous instance of the trait
  val x = increaseOne(new Increaser { def increase(i: Int): Int = i + 5 })
  println(s"x = $x")

  // You can just use a function literal because Increaser is a SAM type
  val y = increaseOne(i => i + 5)
  println(s"y = $y")
