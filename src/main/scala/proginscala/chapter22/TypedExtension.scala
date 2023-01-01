package proginscala.chapter22

trait TwosComplement[N]:
  def equalsMinValue(n: N): Boolean
  def absOf(n: N): N
  def negationOf(n: N): N

object TwosComplement:
  given tcOfByte: TwosComplement[Byte] with
    def equalsMinValue(n: Byte) = n == Byte.MinValue
    def absOf(n: Byte): Byte = n.abs
    def negationOf(n: Byte): Byte = (-n).toByte

  given tcOfShort: TwosComplement[Short] with
    def equalsMinValue(n: Short) = n == Short.MinValue
    def absOf(n: Short) = n.abs
    def negationOf(n: Short) = (-n).toShort

  given tcOfInt: TwosComplement[Int] with
    def equalsMinValue(n: Int) = n == Int.MinValue
    def absOf(n: Int) = n.abs
    def negationOf(n: Int) = (-n).toInt

  given tcOfLong: TwosComplement[Long] with
    def equalsMinValue(n: Long) = n == Long.MinValue
    def absOf(n: Long) = n.abs
    def negationOf(n: Long) = (-n).toLong

/** The better place for the extension is a singleton object because the uses can import the extension methods to bring
  * them into lexical scope, which will make them applicable.
  */
object TwosComplementOps:
  extension [N](n: N)(using tc: TwosComplement[N])
    def isMinValue: Boolean = tc.equalsMinValue(n)
    def absOption: Option[N] =
      if !isMinValue then Some(tc.absOf(n)) else None
    def negateOption: Option[N] =
      if !isMinValue then Some(tc.negationOf(n)) else None

/** Because Scala searches given instances for applicable extensions, thus the best home for these extensions is not in
  * a singleton object like `TwosComplementOps`, but in the type class trait itself.
  */

/**
  * Scala divides extension method search into two phases:
	*	- first phase: looks in lexical scope:
	* 	- defined directly
	*   - imported
	* 	- inherited
	* - second phase: looks in three places:
	*		- the members of the given instances in lexical scope
	*		- the members of the companion objects of the receiver's class, super classes, and super traits
	*		- the members of given instances in those same companion objects
  */

object TypedExtension extends App:
  import TwosComplementOps.*

  println(Byte.MinValue.absOption)
  println(Short.MaxValue.negateOption)
  println(-100L.absOption)
