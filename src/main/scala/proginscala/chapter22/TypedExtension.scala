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

extension [N](n: N)(using tc: TwosComplement[N])
  def isMinValue: Boolean = tc.equalsMinValue(n)
  def absOption: Option[N] =
    if !isMinValue then Some(tc.absOf(n)) else None
  def negateOption: Option[N] =
    if !isMinValue then Some(tc.negationOf(n)) else None

object TypedExtension extends App:
	println(Byte.MinValue.absOption)
	println(Short.MaxValue.negateOption)
	println(-100L.absOption)
