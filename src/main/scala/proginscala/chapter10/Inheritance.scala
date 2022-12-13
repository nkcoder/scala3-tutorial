package proginscala.chapter10

/** A class with abstract members must itself be declared abstract.
  *
  * You cannot instantiate an abstract class.
  */
abstract class Element:
  /** A method is abstract if it does not have an implementation (i.e., no equals sign or body).
    */
  def contents: Vector[String]

  /** The recommended convention is to use a parameterless method whenever there are not parameters and the method
    * accesses state only by reading fields of the containing object(in particular, it does not change mutable state).
    */
  def height: Int = contents.length
  def width: Int = if height == 0 then 0 else contents(0).length

  /** Uniform access principle: client code should not be affected by a decision to implement an attribute as a field or
    * method. We can implement width and height as fields, instead of methods, simply by changing the def in each
    * definition to a val.
    */

  /** You can leave off the empty parentheses on an invocation of any function defined in Java or Scala 2 that takes no
    * arguments.
    *
    * However, it's still recommended to write the empty parentheses when the invoked method represents more than a
    * property of its receiver object.
    *
    * To summarize, it is encouraged in Scala to define methods that take no parameters and have no side effects. If the
    * function you're calling performs an operation, use the parentheses. But if it merely provides access to a
    * property, leave the parentheses off.
    */
  def parentheses() =
    "hello, world".length // no () because no side-effect
    println() // better to not drop the ()

/** The `extends` clause has two effects:
  *   - it makes class VectorElement inherit all non-private members from class Element
  *   - it makes type VectorElement a subtype of the type Element
  *
  * Inheritance means that all members of the superclass are also members of the subclass, with two exceptions:
  *   - private members of the superclass are not inherited in the subclass
  *   - a member of a superclass is not inherited if a member with the same name and parameters is already implemented
  *     in the subclass: we say the member of the subclass overrides the member of the superclass.
  *
  * There are only two namespaces in Scala:
  *   - values (fields, methods, packages, and singleton objects)
  *   - types (class and trait names)
  *
  * Because fields and methods belong to the same namespace, this makes it possible for a field to override a
  * parameterless method.
  *
  * val before the class parameter: defines at the same time a parameter and field with the same name.
  */
class VectorElement(val contents: Vector[String]) extends Element

object Inheritance extends App:
  // subtyping means that a value of the subclass can be used wherever a value of the superclass is required.
  val e: Element = VectorElement(Vector("hello", "world"))
  println(s"e, height: ${e.height}, width = ${e.width}")

  /** You can also prefix a class parameter with var, in which case the corresponding field would be reassignable. It is
    * possible to add modifiers, such as private, protected, or override to these parametric fields, just as you can for
    * any class members.
    */
  class Cat:
    val dangerous = false
  class Tiger(
      override val dangerous: Boolean,
      private var age: Int
  ) extends Cat
