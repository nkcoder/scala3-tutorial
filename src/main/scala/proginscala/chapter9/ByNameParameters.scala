package proginscala.chapter9

object ByNameParameters extends App:

  var assertionEnabled = true

  /** Version 1
    */
  def myAssert(predicate: () => Boolean) =
    if assertionEnabled && !predicate() then throw new AssertionError
  myAssert(() => 100 > 30)

  /** We cannot leave out the empty parameter: Found: (true : Boolean), Required: () => Boolean
    */
  // myAssert(100 > 30)

  /** Version 2: To make a by-name parameter, you give the parameter a type starting with => instead of () =>. A by-name
    * type, in which the empty parameter list, (), is left out, is only allowed for parameters. There is no such thing
    * as by-name variable or by-name field.
    */
  def byNameAssert(predicate: => Boolean) =
    if assertionEnabled && !predicate then throw new AssertionError
  // Now we can leave out the empty parameter and the function looks exactly like using a built-in control
  // structure.
  byNameAssert(100 > 30)

  /** Version 3
    */
  def boolAssert(predicate: Boolean) =
    if assertionEnabled && !predicate then throw new AssertionError
  boolAssert(100 > 30)

  /** Difference between Version 2 and Version 3:
    *
    * Version 2: because the type of bollAssert's parameter is Boolean, the expression inside the parentheses in
    * bollAssert is evaluated before the call to bollAssert. 100 > 30 yields true which is passed to boolAssert.
    *
    * Version 3: because the type of byNameAssert's predicate parameter is => Boolean, the expression inside the
    * parentheses in ByNameAssert is not evaluated before the call to byNameAssert. Instead a function value will be
    * created whose apply method will evaluate 100 > 30 a nd this function value will be passed to byNameAssert.
    *
    * If assertionsEnabled is disabled, you'll see any side effects that the expression inside the parentheses may have
    * in boolAssert, but not in byNameAssert.
    */
  val x = 5
  assertionEnabled = false
  // ERROR: Caused by: java.lang.ArithmeticException: / by zero
  boolAssert(x / 0 == 0)
  // Returns normally
  byNameAssert(x / 0 == 0)
