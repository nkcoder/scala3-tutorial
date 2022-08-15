package learn.nkcoder.basictypes

object BasicTypesDemo extends App :

  // Int: 0x or 0X starts a hexadecimal number
  val hex = 0x6
  val hex2 = 0X00FF
  println(s"hex = $hex, hex2 = $hex2")

  // you can use the underscore to improve the readability of large values
  val billion = 1_000_000_000
  println(s"billion=$billion")

  // Int: the default base is 10
  val dec1 = 456
  println(s"dec1 = $dec1")

  // Long: ends in an L or l
  val long1 = 45L
  println(s"long1 = $long1")

  // Double: decimal digits + an optional decimal point optionally + an optional E or e
  val double1 = 3.456
  val double2 = 3.456e2
  val double3 = 1_000_000e3
  println(s"double1 = $double1, double2 = $double2, double3 = $double3")

  // Float: ends in an F or f
  val float1 = 2.456F
  val float2 = 1_000_000F
  println(s"float1 = $float1, float2 = $float2")

  // Char: any Unicode between single quotes
  val c1 = 'A'
  val c2 = '\u0041'
  val c3 = '\\'
  println(s"c1 = $c1, c2 = $c2, c3 = $c3")

  // String: characters surrounded by double quotes
  val hello = "hello"
  // `raw` string syntax: can contain any characters including newlines, quotation marks and special characters,
  // you should use the pipe character (|) and then call `stripMargin` to remove the margins
  val welcome =
    """|Welcome to use brew.
       |Type "-h" or "--help" for help
       |""".stripMargin
  println(s"hello = $hello")
  println(s"$welcome")

  // Boolean
  val b1 = true
  val b2 = false
  println(s"b1 = $b1, b2 = $b2")
