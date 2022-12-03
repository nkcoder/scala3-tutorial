package proginscala.chapter5

object Equality extends App:
	// you can use == and != to compare two objects for equality
	println(1 == 2)
	println(1 != 3)

	// the operations actually apply to all objects, not just basic types	
	println(List(1, 2, 3) == List(1, 2, 3))
	println(List(1, 2, 3) == List(4, 5, 6))
	
	// you can even compare against null, or against things that might be null, no exception will be thrown
	println(List(1, 2, 3) == null)
	println(null == List(1, 2, 3))

  
