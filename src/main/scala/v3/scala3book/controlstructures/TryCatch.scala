package learn.nkcoder.scala3book.controlstructures

@main def tryCatch(): Unit = 
  try
    println(s"10/0 = ${10 / 0}")
  catch
    case ae: ArithmeticException => println(s"Got an ArithmeticException: ${ae.getMessage}")
    case nfe: NumberFormatException => println(s"Got a NumberFormatException: ${nfe.getMessage}")
  finally
    println("cleanup your resources here")
