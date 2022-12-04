object TailRecursion extends App:
  def isGoodEnough(guess: Double) = true
  def improve(guess: Double) = guess

  /** Functions which call themselves as their last action are called tail recursive.
    *
    * A tail-recursive function will not build a new stack frame for each call, all calls will execute in a single
    * frame.
    *
    * Tail-call optimization is limited to situations where a method or nested function calls itself directly as its
    * last operation, without going through a function value or some other intermediary.
    */
  def approximate(guess: Double): Double =
    if isGoodEnough(guess) then guess
    else approximate(improve(guess))

  /** The loop version: as for the execution time, the tail recursive version is almost exactly the same as the loop
    * version.
    */
  def approximateLoop(initialGuess: Double): Double =
    var guess = initialGuess
    while !isGoodEnough(guess) do guess = improve(guess)
    guess

  // It's not tail-recursive because the function doesn't call itself directly
  val funValue = nestedFun
  def nestedFun(x: Int): Unit = 
    if x != 0 then
      println(x)
      funValue(x - 1)
