package learn.nkcoder.scala3book.taste

@main def collections(): Unit = 
  // List
  val a = List(1, 2, 3)
  val b = (1 to 5).toList
  val c = (1 to 10 by 2).toList
  val d = (1 until 5).toList
  val e = List.range(1, 5)
  val f = List.range(1, 10, 3)
  println(s"a = $a, b = $b, c = $c, d = $d, e = $e, f = $f")

  // Tuple
  case class Person(name: String)

  val t = (11, "eleven", Person("Eleven"))
  println(s"t(0) = ${t(0)}, t(1) = ${t(1)}, t(2) = ${t(2)}")

  val (num, str, person) = t
  println(s"num = $num, str = $str, person = $person")
  

