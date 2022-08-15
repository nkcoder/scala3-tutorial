package learn.nkcoder.classandobjects

object CaseClassDemo extends App:

  case class Person(name: String, age: Int)

  // the compiler will create a companion object and place the `apply()` factory method in it
  val p = Person("Daniel", 30)
  val p2 = Person.apply("Daniel", 30)

  // the compile will store all class parameters in fields and generate accessor methods with the same name
  println(s"p.name=${p.name}, p.age=${p.age}, p2.name=${p2.name}, p2.age=${p2.age}")

  // the compiler will provide an implementation of `toString`
  println(s"p=${p.toString}")

  // the compiler will generate an implementation of `hashcode` and `equals` based on class parameters
  println(p == p2)
  println(p.hashCode() == p2.hashCode())
  println(p == Person("Van", 28))
  println(p.hashCode() == Person("Van", 28).hashCode())

  // the compile will provide a `copy` method
  val p3 = p.copy(age = 50)
  println(s"p3=${p3.toString}")

  // also the `unapply` method
  val Person(p3Name, p3Age) = p3
  println(s"p3.name=$p3Name, p3.age=$p3Age")
  val Person(p2Name, p2Age) = Person.unapply(p2)
  println(s"p2.name=$p2Name, p2.age=$p2Age")


