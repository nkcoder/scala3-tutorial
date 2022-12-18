package proginscala.chapter11

import scala.collection.mutable.ArrayBuffer

/** A trait definition looks just like a class definition except that it uses the keyword `trait`.
  *
  * Once a trait is defined, it can be mixed in to a class using either the `extends` or `with` keywords, or a comma.
  * Methods inherited from a trait can be used just like methods inherited from a superclass.
  */
trait Philosophical:
  def philosophize = "I consume memory, therefore I am."

/** You can use the `extends` keyword to mix in a trait, in that case you implicitly inherit the trait's superclass.
  */
class Frog extends Philosophical:
  override def toString(): String = "green"

/** If you wise to mix a trait into a class that explicitly extends a superclass, you use `extends` to indicate the
  * superclass and a comma(or `with`) to mix in a trait.
  */
class Animal
trait HasLegs
class Duck extends Animal with Philosophical with HasLegs
class Tiger extends Animal, Philosophical, HasLegs:
  override def philosophize: String = "Hi there."

/** In fact, you can do anything in a trait definition that you can do in a class definition, and the syntax looks
  * exactly the same.
  *
  * The key difference between classes and traits is that whereas in classes, `super` calls are statically bound, in
  * traits, they are dynamically bound.
  *
  * One major use of traits is to automatically add methods to a class in terms of methods the class already has. That
  * is, traits can enrich a thin interface, making it into a rich interface.
  */

/** Comparison is so common that Scala provides a trait to help with it. The trait is called `Ordered`.
  *
  * To use it, you replace all of the individual comparison methods with a single `compare` method. The `Ordered` trait
  * then defines >, <, <= and >= for you in terms of this one method. Thus, trait `Ordered` allows you to enrich a class
  * with comparison methods by implementing only one method, `compare`.
  *
  * Any time you implement a class that is ordered by some comparison, you should consider mixing in the `Ordered`
  * trait. If you do, you will provide the class's users with a rich set of comparison methods.
  */
case class Person(age: Int) extends Ordered[Person]:
  /** Define the `compare` method for comparing two objects:
    *   - return 0 if the objects are the same
    *   - negative if receiver is less than the argument
    *   - positive is the receiver is greater than the argument
    */
  def compare(that: Person): Int = this.age - that.age

abstract class IntQueue:
  def get(): Int
  def put(x: Int): Unit

class BasicIntQueue extends IntQueue:
  private val buf = ArrayBuffer.empty[Int]
  def get(): Int = buf.remove(0)
  def put(x: Int): Unit = buf += x

/** The trait `Doubling` has two funny things:
  *   - it declares a superclass, which means that it can only be mixed into a class that also extends `IntQueue`.
  *   - it has a `super` call on a method declared abstract. Since `super` calls in a trait are dynamically bound, the
  *     `super` call in trait `Doubling` will work so long as the trait is mixed in after another trait or class that
  *     gives a concrete definition to the method.
  *
  * The order of mixins is significant: when you call a method on a class with mixins, the method in the trait furthest
  * to the right is called first. If that method calls super, it invokes the method in the next trait to its left, and
  * so on.
  */
trait Doubling extends IntQueue:
  abstract override def put(x: Int) = super.put(2 * x)

trait Incrementing extends IntQueue:
  abstract override def put(x: Int) = super.put(x + 1)

trait Filtering extends IntQueue:
  abstract override def put(x: Int) = if x >= 0 then super.put(x)

object Traits extends App:
  val frog = new Frog
  println(frog.philosophize)

  /** The type of `phil` is `Philosophical`, a trait. Thus, variable `phil` could have been initialized with any object
    * whose class mixes in `Philosophical`.
    */
  val phil: Philosophical = frog
  println(phil.philosophize)

  class MyQueue extends BasicIntQueue, Doubling
  val queue1 = new MyQueue
  queue1.put(10)
  println(s"queue1.get: ${queue1.get()}")

  // Since `MyQueue` defines no new code, so we could supply `BasicIntQueue with Doubling` directly to the `new instead
  // of defining a named class.
  val queue2 = new BasicIntQueue with Doubling
  queue2.put(10)
  println(s"queue2.get: ${queue2.get()}")

  // order: Filter -> Incrementing
  val queue3 = new BasicIntQueue with Incrementing with Filtering
  queue3.put(-1)
  queue3.put(0)
  queue3.put(1)
  println(s"queue3.get_1: ${queue3.get()}") // 1
  println(s"queue3.get_2: ${queue3.get()}") // 2

  // order: Incrementing -> Filtering
  val queue4 = new BasicIntQueue with Filtering with Incrementing
  queue4.put(-1)
  queue4.put(0)
  queue4.put(1)
  println(s"queue4.get_1: ${queue4.get()}") // 0
  println(s"queue4.get_2: ${queue4.get()}") // 1
  println(s"queue4.get_3: ${queue4.get()}") // 2
