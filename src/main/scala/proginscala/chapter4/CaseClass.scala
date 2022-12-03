package proginscala.chapter4

object CaseClass extends App:

  // you declare a case class by placing the case modifier in front of class
  case class Person(name: String, age: Int)

  // 1. the compiler will create a companion object and place the `apply()` factory method in it
  // actually the compiler will rewrite this line of code to an invocation of the generated factory method
  val p = Person("Daniel", 30)
  val p2 = Person.apply("Daniel", 30)

  // 2. the compile will store all class parameters in fields and generate accessor methods with the same name
  println(s"p.name=${p.name}, p.age=${p.age}, p2.name=${p2.name}, p2.age=${p2.age}")

  // 3. the compiler will provide an implementation of `toString`
  println(s"p=${p.toString}")

  // 4. the compiler will generate an implementation of `hashcode` and `equals` based on class parameters
  println(p == p2)
  println(p.hashCode() == p2.hashCode())
  println(p == Person("Van", 28))
  println(p.hashCode() == Person("Van", 28).hashCode())

  // 5. the compile will provide a `copy` method in the class
  val p3 = p.copy(age = 50)
  println(s"p3=${p3.toString}")

  // 6. also the `unapply` method in the companion
  val Person(p3Name, p3Age) = p3
  println(s"p3.name=$p3Name, p3.age=$p3Age")
  val Person(p2Name, p2Age) = Person.unapply(p2)
  println(s"p2.name=$p2Name, p2.age=$p2Age")

  // 7. the compile will not generate any method that you implement yourself. It will use your implementation.

