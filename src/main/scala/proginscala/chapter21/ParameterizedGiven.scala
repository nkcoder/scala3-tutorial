package proginscala.chapter21

trait Ord[T]:
  def compare(x: T, y: T): Int
  def lteq(x: T, y: T): Boolean = compare(x, y) < 1

/** A good home for natural givens is the companion object of the `invoked` type.
  */
object Ord:
  /** Alias given: the name to the left of the equals sign is an alias for the value to the right.
    *
    * So this is not yet an idiomatic way, and I have to comment out it because we'll define a more idiomatic one.
    */
  /*
  given intOrd0: Ord[Int] = new Ord[Int]:
    def compare(x: Int, y: Int) = if x == y then 0 else if x > y then 1 else -1
   */

  /** Because it is common to define an anonymous instance of a trait or class to the right of the equals sign when
    * declaring an alias given, Scala offers a shorthand syntax that replaces the equals sign and the `new class name`
    * portion of the alias given with just the keyword `with`.
    *
    * This is the idiomatic way.
    */
  given intOrd: Ord[Int] with
    def compare(x: Int, y: Int) = if x == y then 0 else if x > y then 1 else -1

  given stringOrd: Ord[String] with
    def compare(x: String, y: String) = x.compare(y)

object Sort:
  def isort[T](xs: List[T])(using ord: Ord[T]): List[T] =
    if xs.isEmpty then Nil
    else insert(xs.head, isort(xs.tail))

  private def insert[T](x: T, xs: List[T])(using ord: Ord[T]): List[T] =
    if xs.isEmpty || ord.lteq(x, xs.head) then x :: xs
    else xs.head :: insert(x, xs.tail)

object ParameterizedGiven extends App:
  import Sort.isort

  /** When you omit the second context parameter, the compiler looks for a given value it can pass as that second
    * parameter based on the parameter's type.
    *
    * Although the compiler will first look in lexical scope for a given Ord[Int], if it does not find any, it will look
    * as a second step in the companion objects of the invoked types `Ord` and `Int`.
    */
  val scores = List(-10, -30, 13, 5, 21, 87, 11)
  println(isort(scores))

  val cities = List("Melbourne", "Sydney", "New York", "Shanghai")
  println(isort(cities))
