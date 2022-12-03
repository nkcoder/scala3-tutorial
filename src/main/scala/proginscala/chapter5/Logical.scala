package proginscala.chapter5

object Logical extends App:
	// the && and || operations will short-circuit as in Java
	// &&: if the left-hand side evaluates to false, the result is false and the right-hand side is not evaluated
	// ||: if the left-hand side evaluates to true, the result is true and the right-hand side is not evaludated
	def salt() = 
		println("salt")
		false
	
	def pepper() = 
		println("pepper")
		true

	println(s"&& = ${salt() && pepper()}")
	println(s"&& = ${pepper() && salt()}")
	println(s"|| = ${salt() || pepper()}")
	println(s"|| = ${pepper() || salt()}")

	// if you want to evaluate the right hand side no matter what, use & and | instead.
	// the & method performs a logical and operation, and | a logical or, but don't short-circuit like && and ||.
	println(s"& = ${salt() & pepper()}")
	println(s"| = ${pepper() | salt()}")

