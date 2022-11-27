package pis5.chp5

object RichOperations extends App:
	// RichInt
	val r1 = 0.max(5)
	val r2 = 0.min(5)

	// RichDouble
	val r3 = -3.5.abs
	val r4 = -5.788.round
	val r5 = 2.9.isInfinity
	val r6 = (2.0/0).isInfinity

	// RichInt
	val r7 = 4 to 8

	// StringOps
	val r8 = "awesome".capitalize
	val r9 = "better".drop(2)

	
