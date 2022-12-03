package pis5.chp7

object ScopeAndMatch extends App:
  /** For now, just consider using match to select among a number of alternatives. The default case is specified with
    * and underscore(_), a wild card symbol frequently used in Scala as a placeholder for a completely unknown value.
    * Difference from Java:
    *   - any kind of constant can be used in cases in Scala
    *   - no breaks at the end of each alternative, instead the break is implicit and there is no fall through from one
    *     alternative to the next
    *   - the match expression results in a value
    */
  def capital(input: String): String =
    input match
      case "AU" => "Canberra"
      case "CN" => "Beijing"
      case "US" => "Washington"
      case _    => "Unknown?"

  println(s"AU = ${capital("AU")}")
  println(s"Unknown = ${capital("Other")}")

  /** Variable scope: the most common example of scoping is that indentation generally introduces a new scope, so anything
    * defined at a particular indentation level leaves scope after an outdent.
    *
    * Once a variable is defined, you can't define a new variable with the same name in the same scope. You can, on the
    * other hand , define a variable in an inner scope that has the same name as a variable in the an outer scope. In a
    * Scala program, an inner variable is said to shadow a like-named outer variable, because the outer variable becomes
    * invisible in the inner scope. But it is usually better to choose a new, meaningful variable name rather than to
    * shadow an outer variable.
    */
  def variableScope() =
    val a = 1
    // val a = 2  // does not compile
    if a == 1 then
      val a = 2
      println(s"inner a = $a")
    println(s"outer a = $a")

  variableScope()
