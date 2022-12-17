package proginscala.chapter9

object Currying extends App:
	def plainOldSum(x: Int, y: Int) = x + y
	println(s"plainOldSum: ${plainOldSum(3, 5)}")

	def curriedSum(x: Int)(y: Int) = x + y
	println(s"curriedSum: ${curriedSum(3)(5)}")

	// onePlus has type: Int => Int
	val onePlus = curriedSum(1)
	onePlus(4)
	val twoPlus = curriedSum(2)
	twoPlus(5)


  
