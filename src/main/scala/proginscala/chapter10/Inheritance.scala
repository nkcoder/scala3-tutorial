package proginscala.chapter10

/** A class with abstract members must itself be declared abstract.
  *
  * You cannot instantiate an abstract class.
  */
import Element.elem
abstract class Element:
  /** A method is abstract if it does not have an implementation (i.e., no equals sign or body).
    */
  def contents: Vector[String]

  /** The recommended convention is to use a parameterless method whenever there are not parameters and the method
    * accesses state only by reading fields of the containing object(in particular, it does not change mutable state).
    */
  def height: Int = contents.length
  def width: Int = if height == 0 then 0 else contents(0).length

  def above(that: Element): Element = elem(this.contents ++ that.contents)

  def beside(that: Element): Element =
    val contents = for (line1, line2) <- this.contents.zip(that.contents) yield line1 + line2
    elem(contents)

  def widen(w: Int): Element = 
    if w < width then this
    else
      val left = elem(' ', (w - width) / 2, height)
      val right = elem(' ', w - width - left.width, height)
      left beside this beside right

  def heighten(h: Int): Element = 
    if h <= height then this
    else 
      val top = elem(' ', width, (h - height) / 2)
      val bot = elem(' ', width, h - height - top.height)
      top above this above bot

  override def toString: String = contents.mkString("\n")
end Element

/** A factory object contains methods that construct other objects. Clients would then use these factory methods to
  * construct objects, rather than constructing the objects directly via their constructors.
  *
  * An advantage of this approach is that object creation can be centralized and the details of how objects are
  * represented with classes can be hidden. This hiding will both make your library simpler for clients to understand,
  * because less detail is exposed, an d provide you with more opportunities to change your library's implementation
  * later without breaking client code.
  *
  * The companion object is a good place for factory methods.
  * 
  * In Scala, you can define classes and singleton objects inside other classes and singleton objects.
  */
object Element:
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
  private class VectorElement(val contents: Vector[String]) extends Element

  /** To invoke a superclass constructor, you simply place the argument or arguments you want to pass in parentheses
    * following the name of the superclass.
    *
    * Scala requires the `override` modifier for all members that override a concrete member in a parent class. The
    * modifier is optional if a member implements an abstract member with the same name. The modifier is forbidden if a
    * member does not override or implement some other member in a base class.
    */
  private class LineElement(s: String) extends VectorElement(Vector(s)):
    override def height: Int = 1
    override def width: Int = s.length

  private class UniformElement(chr: Char, override val width: Int, override val height: Int) extends  Element:
    private val line = chr.toString * width
    def contents = Vector.fill(height)(line)

  def elem(contents: Vector[String]): Element = VectorElement(contents)

  def elem(chr: Char, width: Int, height: Int): Element = UniformElement(chr, width, height)

  def elem(line: String): Element = LineElement(line)

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

/** Composition and inheritance are two ways to define a new class in terms of another existing class.
  *
  * If what you're after is primarily code reuse, you should in general prefer composition to inheritance. Only
  * inheritance suffers from the fragile base class problem, in which you can inadvertently break subclasses by changing
  * a super class.
  *
  * Inheritance:
  *   - whether it models an is-a relationship
  *   - whether clients will want to use the subclass type as a superclass type
  */
object Inheritance extends App:
  // subtyping means that a value of the subclass can be used wherever a value of the superclass is required.
  val e: Element = Element.elem(Vector("hello", "world"))
  println(s"e, height: ${e.height}, width = ${e.width}")
