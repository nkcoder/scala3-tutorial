package pis5.chp6

// if a class doesn't have a body, you don't need to specify empty curly braces and cannot terminate with a colon.

// n and d are called class parameters. The Scala compiler will gather up these two class parameters and create a 
// 	primary constructor that takes the same two parameters.
class Rational(n: Int, d: Int):
	// The Scala compile will compile any code you place in the class body, which isn't part of a field or method definition,
	// 	into the primary constructor	
	println(s"Created $n/$d")

	// precondition on parameters
	require(d != 0)

	private val g = gcd(n.abs, d.abs)

	// define two fields and initialize with class parameters
	val numer: Int = n / g
	val denom: Int = d / g

	// In Scala, constructors other the primary constructor are called auxiliary constructors.
	// Every auxiliary constructor must invoke another constructor of the same class as its first action.
	// The net effect of this rule is that every constructor invocation in Scala will end up eventually calling the primary
	// 	constructor of the class.
	// The primary constructor is thus the single point of entry of a class.
	// In a Scala class, only the primary constructor can invoke a superclass constructor.
	def this(n: Int) = this(n, 1)

	// You can override the default implementation of toString
	override def toString: String = s"$numer/$denom"

	def add(that: Rational): Rational = 
		Rational(numer * that.denom + that.numer * denom, denom * that.denom)

	// The method name is overloaded because each name is now being used by multiple methods.
	// The choose overloaded version is the one that best matches the static types of the arguments,
	// 		sometimes there is no unique best matching version and the compiler will give you "ambiguous reference" error.
	def +(that: Rational): Rational = this.add(that)
	def +(i: Int): Rational = Rational(numer + i * denom, denom)

	def -(that: Rational): Rational = Rational(numer * that.denom - denom * that.numer, denom * that.denom)
	def -(i: Int): Rational = Rational(numer - i * denom, denom)

	def *(that: Rational): Rational = Rational(numer * that.numer, denom * that.denom)
	def *(i: Int): Rational = Rational(numer * i, denom)

	def /(that: Rational): Rational = Rational(numer * that.denom, denom * that.numer)
	def /(i: Int): Rational = Rational(numer, denom * i)

	private def gcd(a: Int, b: Int): Int = 
		if b == 0 then a else gcd(b, a % b)

	/**
	  * Identifiers in user programs should not contain $ characters, even though it will compile; 
		* 	if they do, this might lead to name clashes with identifiers generated by the Scala compile.
		* 
		* Although underscores are legal in identifiers, they are not used that often in Scala programs,
		* 	because underscores have many other non-identifiers uses in Scala code.
		* 
		* In Scala, the word constant does not just mean val. Even though a val does remain constant after
		* 	it's initialized, it is still a variable. For example, method parameters are vals, but each time 
		* 	the method is called those vals can hold different values.
		* As constant is more permanent. For example, 
		* 	- scala.math.Pi is unlikely to change over. 
		* 	- you can also use constants to give names to values that would otherwise be magic numbers in your code.
		* 	- you may also want to define constants for use in pattern matching
		* 	The Scala convention is to use camel case for constants, such as XOffSet.
	  */
	val DefaultBasePrice = 500.0

	/**
	  * A literal identifier is an arbitrary string enclosed in back ticks(``). The idea is that you can put any
		* 	that's accepted by the runtime as an identifier between back ticks.
	  */
	val `yield` = true


/**
  * This defines four extension methods on Int, each of which take a Rational.
  */	
extension (x: Int)
	def +(y: Rational) = Rational(x) + y
	def -(y: Rational) = Rational(x) - y
	def *(y: Rational) = Rational(x) * y
	def /(y: Rational) = Rational(x) / y



/**
  * If used unartfully, both operator methods and extension methods can give rise to client that is hard to 
	* 	read and understand:
	*		- extension methods are applied implicitly by the compiler, not explicitly written down in the source code
	*		- operator methods will usually make client code more concise, they will only make it more readable to the
	* 	- the extent client programmers will be able to recognize and remember the meaning of each operator.
  */


object Start extends App:
	val r = new Rational(2, 3)
	println(s"r = $r")

	// When instantiating classes that take parameters, you can optionally leave off the new keyword.
	// Such an expression is using what is called a universal apply method.
	val r2 = Rational(5, 6)
	println(s"r2 = $r2, numer = ${r2.numer}, denom = ${r2.denom}")

	val oneHalf = Rational(1, 2)
	val twoThirds = Rational(2, 3)
	oneHalf.add(twoThirds)

	val rational5 = Rational(5)

	val r3 = Rational(66, 48)
	println(s"r3 = $r3")

	val x = Rational(2, 5)
	val y = Rational(4, 7)
	println(s"x + y = ${x + y}, x * y = ${x * y}")
	println(s"x + y = ${x.+(y)}, x * y = ${x.*(y)}")
	println(s"x + x * y = ${x + x * y}")	// operator precedence: * is higher thant + 

	val r4 = 2 * Rational(3)
	val r5 = 3 + Rational(5)
	println(s"r4 = $r4, r5 = $r5")

	

