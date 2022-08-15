package learn.nkcoder.classandobjects

class ClassAndFieldsDemo:
  // private fields can only be accessed in the same class (and companion object)
  private var sum = 0

  // not explicitly specifying any access modifier means public in Scala
  val notUsed = 1

  def add(b: Byte): Unit =
    // method parameters are vals, not vars; so this won't compile, because b is a val
    // b = 2022
    // the method returns the last value computed by the method, and explicit `return` is not recommended
    sum += b

  // although the scala compile can infer the result type of the methods, the readers of the code will also need to
  // manually infer the result types by studying the bodies of the methods.
  // So it's often better to explicitly provide the result types of public methods declared in a class.
  def checksum(): Int = (sum & 0xFF) + 1














