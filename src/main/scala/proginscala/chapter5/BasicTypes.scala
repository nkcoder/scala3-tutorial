package proginscala.chapter5

object BasicTypes extends App:

  /** numerci types: Byte, Short, Int, Long, Char, Float, Double
    */

  // Int: 0x or 0X starts a hexadecimal number
  val hex  = 0x6
  val hex2 = 0x00fe
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

  // If an Int liternal is assigned to a variable of type Short or Byte, the literal is treated as if it were a Short or Byte 
  // so long as the literal value is within the valid range for that type.
  val litte: Short = 367
  val litter: Byte = 35

  // Double: decimal digits + an optional decimal point + an optional E or e
  val double1 = 3.456
  val double2 = 3.456e2
  val double3 = 1_000_000e3
  println(s"double1 = $double1, double2 = $double2, double3 = $double3")

  // Float: ends in an F or f
  val float1 = 2.456f
  val float2 = 1_000_000f
  println(s"float1 = $float1, float2 = $float2")

  // import scala.language.experimental.genericNumberLiterals
  // val invoice: BigInt= 1_000_000_000_000_000_000_000_000
  // val pi: BigDecimal = 3.1415926535897932384626433833

  // Char: any Unicode character between single quotes
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
  println(s"welcome = $welcome")

  // String interpolation: s, raw, f
  // raw: behaves like s, except it does not recognize character lieteral escape sequences.
  // f: allows you to attach printf-style formatting instructions to embedded expressions.
  println(s"6 * 7 = ${6 * 7}")
  println(raw"No\\\\escape!")
  println(f"${math.Pi}%.5f")

  // Boolean
  val b1 = true
  val b2 = false
  println(s"b1 = $b1, b2 = $b2")
