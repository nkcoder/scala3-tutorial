package proginscala.chapter9

object FileMatcher extends App:
  private def filesHere = (new java.io.File(".")).listFiles

  private def filesMatching(matcher: String => Boolean) =
    for file <- filesHere if matcher(file.getName()) yield file

  /** One benefit of higher-order functions is they enable you to create control abstractions that allow you to reduce
    * code duplication.
    *
    * In the following three examples, the place holder(_) is the bound variable because it's taken from arguments to
    * the function, query is the free variable captured from outer functions.
    */
  def filesEnding(query: String) = filesMatching(_.endsWith(query))

  def filesContaining(query: String) = filesMatching(_.contains(query))

  def filesRegex(query: String) = filesMatching(_.matches(query))

  println(s"filesEnding: ${filesEnding(".scala")}")
  println(s"filesContaining: ${filesContaining("matcher")}")
  println(s"filesRegex: ${filesRegex("Mat")}")

