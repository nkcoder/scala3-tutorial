package proginscala.chapter21

/** This chapter is about context parameters, which are often simply called `givens`. It enables you to leave out
  * certain arguments when you invoke functions, relying on the compiler to fill in appropriate values for each context
  * based on the types.
  */

/**
  * Because the compiler selects context parameters by matching types of parameters against types of given instances, context
  * parameters should have `rare` or `special` enough types that accidental matches are unlikely.
  */
class PreferredPrompt(val preference: String)
class PreferredDrink(val preference: String)

/**   1. The context parameter should be placed into a separate parameter list marked with the `using` keyword.
 * NOTE: the `using` keyword applies to an entire parameter list, not to individual parameters.
  */
object Greeter:
  def greet(name: String)(using prompt: PreferredPrompt, drink: PreferredDrink) =
    println(s"Welcome, $name. The system is ready.")
    println(s"But while you work, why not enjoy a cup of ${drink.preference}")
    println(prompt.preference)

/** 2. To enable the compiler to supply the context parameter implicitly, you must define a given instance of the
  * expected type using the `given` keyword. (NOTE: there is no `val` or `var` in the `given` statement)
  */
object DanielsPrefs:
  given prompt: PreferredPrompt = PreferredPrompt("As you wish>")
  given drink: PreferredDrink = PreferredDrink("Beer")





object Given extends App:
  /** 3.1 The compiler won't supply the implicit argument unless it is in scope, you can import it:
    */
  import DanielsPrefs.{prompt, drink}
  Greeter.greet("Friend!")

  /** 3.2 Because the second parameter is declared as a context parameter, so you cannot pass the argument in explicitly
    * in the usual way. You must instead indicate you want to fill in a context parameter explicitly with the `using`
    * keyword at the call site.
    */
  Greeter.greet("Programmer!")(using prompt, drink)
