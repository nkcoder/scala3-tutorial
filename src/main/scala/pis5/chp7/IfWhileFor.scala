package pis5.chp7

object IfWhileFor extends App:

	/**
	  * Scala's if is an expression that results in a value.
		* Using val is a functional style and it tells readers of the code that the variable will never 
		* 	change, saving them from scanning all code in the variable's scope to see if it ever changes.
		* A second advantage to using a val instead of a var is that it better supports equational reasoning.
		* Looking for opportunities to use vals as they can make your code both easier to read and easier to refactor.
	  */
	val files = Array("1.txt", "2.txt")
	val file = if !files.isEmpty then files(0) else "default.txt"
	println(s"n = $file")

	/**
	  * The while construct is called a loop, not an expression, because it doesn't result in an interesting value.
		* The type of the result is Unit and is written ().
		* In general, we recommend you challenge while loops in your code in the same way you challenge vars. In fact,
		* 	while loops and vars often go hand in hand.
	  */
	var x = 10
	var y = 1
	while x > 0 do
		y = y * 2
		x = x - 1
	println(s"result = $y")	

	/**
	  * num <- numbers is called a generator.
		* The for expression syntax works for any kind of collection, not just arrays.
	  */
	val numbers = Array(1, 4, 5, 44, 19)
	for num <- numbers do
		println(num)
	// create a Range using `to`
	for i <- 1 to 4 do
		println(s"iteration: $i")
	// create a Range to exclude the upper bound using `until`	
	for i <- 1 until 4 do
		println(s"iteration: $i")

	// you can filter elements with a for expression by adding a filter, an if clause inside the for's parentheses
	for j <- 1 to 100 if j % 10 == 0 do
		println(s"divide by 10 = $j")
	// you can include more filters if you want, just keep adding if clauses
	for 
		j <- 1 to 100
		if j % 10 == 0
		if j % 3 == 0
	do
		println(s"divide by 3 and 10: $j")

	// if you add multiple <- clauses, you will get nested "loops"
	for 
		i <- 1 to 10 if i % 2 == 0
		j <- 1 to 10 if j % 2 == 1
	do
		println(s"i = $i, j = $j")

	// You can bind the result to a new variable using an equals sign(=).
	// The bound variable is introduced and used just like a val, only with val keyword left out
	val cities = List("Melbourne", "Canberra", "Beijing", "Chengdu")
	for
		city <- cities
		allUpper = city.toUpperCase
		if allUpper.startsWith("MEL")
	do 
		println(s"the city is $allUpper")
		
	// You can prefix the body of the for expression by the keyword yield instead of do to generate
	// 	a value to remember for each iteration.
	val citiesStartsWithC = for 
		city <- cities
		allUpper = city.toUpperCase
		if allUpper.startsWith("C")
	yield allUpper
	println(s"citiesStartsWithC = $citiesStartsWithC")



	








	
  
