package learn.nkcoder.scala3book.types

@main def firstLookAtTypes(): Unit =
  // type hierarchy: Any <- Matchable <- AnyVal, AnyRef
  val anyList: List[Any] = List(
    "a string",
    732, 
    'C',
    true,
    (),
    () => "an anonymous function returning a string"
  )

  anyList.foreach(println)

  // AnyVal
  // Int and Double are the default
  val aInt = 123
  val aDouble = 1.0

  // you can declare with types
  val b: Byte = 1
  val i: Int = 1
  val l: Long = 1
  val s: Short = 1
  val d: Double = 1
  val f: Float = 1

  // you can also append L, D, F to numbers to specify Long, Double, Float
  val aLong =  1_000L
  val anotherDouble = 2.2D
  val anotherFloat = 3.3F

  // BigInt and BigDecimal: for precise arithmetic
  val bi = BigInt(1_234_567_890_789_234L)
  val bd = BigDecimal(1_456.945944995)
  println(s"bd + bd = ${bd + bd}")
  println(s"bd * bd = ${bd * bd}")

  // string and char
  val str = "Bill"
  val c = 'x'

  // string interpolcation
  val firstName = "John"
  val middleName = "K"
  val lastName = "Doe"
  println(s"full name = $firstName $middleName, $lastName")

  println(s"2 + 2 = ${2 + 2}")

  // multiline string
  val quote = """The essence of Scala:
               |Fusion of functional and object-oriented
               |programming in a typed setting.""".stripMargin
  println(quote)

  // type casting: you can only cast to a type if there is no loss of information
  // otherwise you need to be explicit about the cast
  val b3: Byte = 127
  // it's OK
  val i3: Int = b   
  val x: Long = 987654321
  val y: Float = x.toFloat     
  // error
  // val z: Long = y  

  
  // Nothing: subtype of all types, also called the bottom type
  // Null: subtype of all reference types, should only be used with other JVM languages


