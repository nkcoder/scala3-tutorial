package learn.nkcoder.scala3book.controlstructures

@main def ifElse(): Unit = 

  val x = 1
  if x == 1 then println(x)


  if x == 1 then
    println("x is 1, as you can see")
    println(x)
  

  if x < 0 then
    println("negative")
  else if x == 0 then
    println("zero")
  else
    println("positive")

  // end if: only supported in scala 3
  if x == 1 then
    println("x is 1, as you can see")
    println(x)
  end if

  // if...else: always returns a value
  val str = if x > 0 then "positive" else "non positive"
  println(s"str = $str")

    



  

