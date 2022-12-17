package proginscala.chapter9

object Exists extends App:
  val data = List(11, 5, 28, -23, 90, 55)

  /** The `exists` method is a special-purpose looping construct provided by the scala library, rather than built into
    * the Scala language like while or for. Because it's public in Scala's collections API, the code duplication it
    * reduces is client code of that API.
    */
  val containsNegative = data.exists(_ < 0)
  val containsOdd = data.exists(_ % 2 == 1)
  println(s"containsNegative: $containsNegative, containsOdd: $containsOdd")
