package pis5.chp5

object Arithmetic extends App:
	// when both the left and right operands are integral types(Int, Long, Byte, Short, or Char), the / operator will tell you
	// the whole number portion of the quotient, excluding any remainder.
	val r1 = 11 / 7
	// the % operator indicates the remainder of an implied division
	val q1 = 11.0 % 4.0
	// you can get an IEEE remainder by calling IEEEremainder on scala.math
	val r2 = math.IEEEremainder(11.0, 4.0)
	println(s"r1 = $r1, q1 = $q1, r2 = $r2")

  
