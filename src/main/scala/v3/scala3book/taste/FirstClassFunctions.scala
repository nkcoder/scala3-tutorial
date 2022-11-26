package learn.nkcoder.scala3book.taste

@main def firstClassFunctions(): Unit = 
  val a = List(1, 2, 3).map(i => i * 2)
  val b = List(1, 2, 3).map(_ * 2)

  println(s"a = $a, b = $b")

  val c = (1 to 10).toList
  val r = c.filter(_ > 3).filter(_ < 8).map(_ * 10)

  println(s"r = $r")
  
