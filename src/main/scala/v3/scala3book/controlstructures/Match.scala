package learn.nkcoder.scala3book.controlstructures

@main def matchExpression(): Unit = 
  // match is an expression
  def weekday(i: Int): String = 
    i match
      case 0 => "Sunday"
      case 1 => "Monday"
      case 2 => "Tuesday"
      case 3 => "Wednesday"
      case 4 => "Thursday"
      case 5 => "Friday"
      case 6 => "Saturday"
      case _ => "invalid day"

  println(s"day for 3 = ${weekday(3)}")
  println(s"day for 8 = ${weekday(8)}")


  // use a variable to access the catch-all default value
  val x = 10
  x match
    case 0 => println("0")
    case 1 => println("1")
    case what => println(s"You give me: $what")


      
  // A name beginning with an uppercase letter does not introduce a variable, but matches a value in Scope
  val N = 10
  x match
    case 0 => println("0")
    case 1 => println("1")
    case N => println("10")
    case n => println(s"You gave me: $n")
  

  // you can use multiple possible pattern matches in each case statement
  val evenOrOdd = x match
    case 1 | 3 | 5 | 7 | 9 => println("odd")
    case 2 | 4 | 6 | 8 | 10 => println("even")
    case _ => println("some other number")


  // use guard in the case statement
  x match 
    case 1 => println("one, a lonely number")
    case x if x == 2 || x == 3 => println("two's company, there's a crowd")
    case x if x > 3 => println("4+, that's a party")
    case _ => println("I'm guessing your number is zero or less")


  // case class and match expressions
  case class Person(name: String)
  def speak(p: Person) = p match
    case Person(name) if name == "Fred" => println(s"$name say, Yubba dubba doo")
    case Person(name) if name == "Bam Bam" => println(s"$name says, Bam bam!")
    case _ => println("Watch the Flintstones!")

  speak(Person("Fred"))
  speak(Person("Bam Bam"))

  // using a match expression as the body of a method
  def isTruthy(a: Matchable) = a match
    case 0 | "" | false => false
    case _ => true

  println(isTruthy(0))
  println(isTruthy(false))
  println(isTruthy(""))
  println(isTruthy(1))
  println(isTruthy(" "))


  // match expression support many different types of patterns
  case class Dog(name: String)
  def pattern(x: Matchable): String = x match
    // constant patterns
    case 0 => "zero"
    case true => "true"
    case "hello" => "hello"
    case Nil => "an empty list"

    // sequence patterns
    case List(0, _, _) => "a 3-element listing with 0 as the first element"
    case List(1, _*) => "list, starts with 1, has any number of elements"
    case Vector(1, _*) => "vector, start with 1, has any number of elements"
  
    // tuple patterns
    case (a, b) => s"got $a and $b"
    case (a, b, c) => s"got $a, $b and $c"

    // tpye test patterns
    case s: String => s"got a string: $s"
    case i: Int => s"got an int: $i"
    case f: Float => s"got a float: $f"
    case a: Array[Int] => s"array of int: $a"
    case as: Array[String] => s"string array: $as"
    case d: Dog => s"dog: ${d.name}"
    case list: List[?] => s"got a list: $list"
    case m: Map[?, ?] => m.toString
  
    // the default wildcad pattern
    case _ => "Unknown"

  println(pattern(true))
  println(pattern(List(1, 2, 3, 4, 5)))
  println(pattern(List(0, 2, 4)))
  println(pattern(4, 5))
  println(pattern(4, 5, 6))
  println(pattern(Map("1" -> true, "0" -> false)))
  println(pattern(Dog("jay")))


  



  



