package proginscala.chapter21

/** Because the compiler looks for givens by type, and you don't need to refer to a given's term at all, you can declare
  * your given value anonymously.
  *
  * For anonymous givens, the compiler would synthesize a name for you. Thus if all you care about is that a given will
  * be provided implicitly as context parameters, you need not declare a term for it.
  */

object AnonymousGiven:
  given Ord[Int] with
    def compare(x: Int, y: Int) = if x == y then 0 else if x > y then -1 else 1

  given Ord[String] with
    def compare(x: String, y: String) = -x.compare(y)
  
