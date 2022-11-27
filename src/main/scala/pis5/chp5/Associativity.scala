package pis5.chp5

object Associativity extends App:
	// Given that Scala doesn't have operators, Scala decides precedence based on the first character
	// of the methods used in operator.
	// for example, if the method name starts with a *, it will have a higher precedence than a method starts with a +.
	println(s"${10 + 5 * 6 / 3}")

	// Exception: if an operator ends in an equals character(=), and the operator is not one of the comparison operators
	// (<=, >=, ==, !=), then the precedence of the operator is the same as that of simple assignment(=).
	// That is, it is lower that the precedence of any other operator.
	var x = 3
	x *= 10 + 1
	println(s"x = $x")


	// The associativity of an operator in Scala is determined by it's last character.
	// any method that ends in a colon(:) is invoked on it's right operand, passing in the left operand;
	// methods that end in any other character are invoked on their left operand, passing in the right operand.
	println(s"${10 * 2 == 10.*(2)}")
	println(s"${List(1, 2) ::: List(3, 4) == List(3, 4).:::(List(1, 2))}")

	// No matter what associativity an operator has, however, its operands are always evaluated left to right.


  
