package pis5.chp7

object RefactorImperative extends App:
  /** There is no break or continue in Scala because they do not mesh with function literals. The simplest approach is
    * to replace every continue by an if and every break by a boolean variable which are vars. If you want to get rid of
    * the vars, you can try to rewrite the loop as a recursive function.
    */
  def searchFrom(i: Int, data: List[String]): Int =
    if i >= data.size then -1
    else if data(i).startsWith("-") then searchFrom(i + 1, data)
    else if data(i).endsWith(".scala") then i
    else searchFrom(i + 1, data)
  println(searchFrom(0, List("-Test.scala", "Object.scala", "Class.Scala")))

  /** Refactoring imperative-style code
    */
  private def makeRowSeq(row: Int) =
    for col <- 1 to 10 yield
      val prod = (row * col).toString
      val padding = " " * (4 - prod.length)
      padding + prod

  private def makeRow(row: Int) = makeRowSeq(row).mkString

  def multiTable(n: Int) =
    val tableSeq = for row <- 1 to 10 yield makeRow(row)
    tableSeq.mkString("\n")

  println(s"multiply table by 10: \n: ${multiTable(10)}")
