package proginscala.chapter11

/** You define traits that take parameters the same way you define classes that take parameters.
  */
trait Philosophical2(message: String):
  def philosophize = message

class Animal2

/** You must specify a trait's parameter value when defining a class that mixes in the trait.
  *
  * Trait parameters are evaluated immediately before the trait initializers. As with a class parameter, a trait
  * parameter is by default only available to the trait body.
  */
class Frog2 extends Animal2, Philosophical2("I'm a Frog, therefore I am.")
class Duck2 extends Animal2, Philosophical2("I'm a Duck, therefore I am.")

// 1. If a class's superclass doesn't itself extends the trait, you must specify the trait parameter when defining the class.
class ProfoundAnimal extends Animal2, Philosophical2("In the beginning was the deed.")

// 2. On the other hand, if the class's superclass also extends the trait, then you can no longer provide the trait parameter when defining
// the class.
class Frog3 extends ProfoundAnimal with Philosophical2

trait PhilosophicalAnimal extends Animal2 with Philosophical2

// 3. A trait cannot pass parameters to its parent traits: the follow definition is invalid
// class Duck3 extends PhilosophicalAnimal("I'm a bad duck!")

object TraitParameters extends App:
  val frog = new Frog2
  println(frog.philosophize)
  val duck = new Duck2
  println(duck.philosophize)
