package proginscala.chapter5

/**
  * Operators are just a nice syntax for ordinary methods calls
	* In Scala, operators are not special language syntax. Any method that accepts a single parameter can be an operator.
  */
object Operators extends App:
	// infix operators
	val sum = 10 + 25
	val sum2 = 10.+(25)
	println(s"sum = $sum, sum2 = $sum2")

	val s = "Hello, world!"
	val index1 = s indexOf "w"
	val index2 = s.indexOf("w")
	println(s"index1 = $index1, index2 = $index2")
  
	// prefix operators: the name of the method has `unary_` prepended to the operator character
	// only +, -, ! and ~
	val negative = -2.0
	val negative2 = (2.0).unary_-
	println(s"negative = $negative, negative2 = $negative2")

	// posix operators: methods that take no arguments when they are invoked without a dot or parentheses
	// convention: leave off empty parentheses on method calls if the method has no side effects, otherwise include parentheses
	val s2 = "Hey, world!"
	println(s"s2.upperCase: ${s2.toUpperCase}")
	// you can alternatively leave off the dot and use postfix ooperator notation, but you need to import `postfixOps` first
	import scala.language.postfixOps
	println(s"s2.upperCase: ${s2 toUpperCase}")
	
