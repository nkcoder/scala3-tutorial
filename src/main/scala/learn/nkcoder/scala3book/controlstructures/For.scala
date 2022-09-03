package learn.nkcoder.scala3book.controlstructures

@main def forExample(): Unit = 

  // for...do
  val ints = Seq(1, 3, 5)
  for x <- ints do println(x)

  // for can have multiple generators
  for 
    i <- 1 to 2
    j <- 'a' to 'b'
    k <- 1 to 10 by 5
  do
    println(s"i = $i, j = $j, k = $k")


  // for with guards
  for 
    i <- 1 to 10
    if i > 3
    if i < 6
    if i % 2 == 0
  do
    println(s"i = $i")

  // for with Maps
  val states = Map(
    "AK" -> "Alaska",
    "AL" -> "Alabama",
    "AR" -> "Arizona"
  )
  for (abbrev, fullname) <- states do println(s"$abbrev: $fullname")

  // for expressions to yield/return values
  val list = for i <- 10 to 12 yield i * 2
  println(s"list = $list")

  // the for expression is equivalent to the map method call
  val list2 = (10 to 12).map(i => i * 2)
  println(s"list2 = $list2")

  // you can put a block of code after the yield
  val names = List("_olivia", "_water", "_peter")
  val capNames = for name <- names yield
    val nameWithoutUnderscore = name.drop(1)
    val capName = nameWithoutUnderscore.capitalize
    capName
  println(s"capNames: $capNames")

  // using a for expression as the body of a method
  def between3And10(xs: List[Int]): List[Int] =
    for 
      x <- xs 
      if x > 3
      if x < 10
    yield x

  println(s"between3And10((8 to 12)) = ${between3And10((8 to 12).toList)}")
     
      
    




