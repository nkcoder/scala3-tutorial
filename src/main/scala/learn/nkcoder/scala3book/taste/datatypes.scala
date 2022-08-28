package learn.nkcoder.scala3book.taste

@main def dataTypes(): Unit =
  val x = 1
  var y = 2
  y = 20
  val s = "hello, world"
  val nums = List(2, 4, 6)

  val a = 3L
  val b = 5.1D
  val c = 3.5F

  val m = BigInt(1_234_567_898_765_432L)
  val n = BigDecimal(123_456.789)

  // string interpolation
  val firstName = "John"
  val mi = 'C'
  val lastName = "Doe"
  println(s"Name: $firstName, $mi, $lastName")
  println(s"2 + 2 = ${2 + 2}")
  println(s"(-2).abs = ${(-2).abs}")

