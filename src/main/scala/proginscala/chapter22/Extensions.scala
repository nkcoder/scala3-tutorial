package proginscala.chapter22

object Extensions extends App:
  /** Define a method on String to remove the white spaces of each end, and replace multiple white spaces to one white
    * space.
    */
  def singleSpace0(s: String): String =
    s.trim.split("\\s+").mkString(" ")

  println(singleSpace0(" It was   the \t\tbest\nof times   "))

  /** The `extension` keyword allows you to create the illusion that you've added a member function to a class without
    * changing the class itself.
    *
    * In parentheses after `extension`, you place a single variable of the type to which you want to add the method. The
    * object referenced by this variable is called the receiver of the extension method.
    *
    * Actually, extension method definitions are rewritten in place to methods that take the receiver directly as a
    * parameter. For example, the compile will rewrite the extension method definition to the above `singleSpace0` but
    * gives it an internal marker identifying it as an extension method.
    */
  extension (s: String)
    def singleSpace: String =
      s.trim.split("\\s+").mkString(" ")
  // Uses of an extension method are called applications.
  val s = " It was   the \t\tbest\nof times   "
  println(s.singleSpace)

  /** To make an extension generic, you place one or more type parameters in square brackets after the `extension`
    * keyword, before the parentheses containing the receiver.
    */
  extension [T](xs: List[T])
    def tailOption: Option[List[T]] =
      if xs.nonEmpty then Some(xs.tail) else None

  println(List(1, 2, 3, 4).tailOption)
  println(List.empty[String].tailOption)
  println(List("hello", "world").tailOption)
  // if you want to give the type parameter explicitly, you must call the method directly
  println(tailOption[Int](List(3, 4, 5)))

  /** Collective extension: define multiple methods together to the same type.
    *
    * The methods defined together in a collective extension are called sibling methods. From a method in a collective
    * extension, you can invoke sibling methods as if they were members of the same class.
    */
  extension (n: Int)
    def isMinValue: Boolean = n == Int.MinValue
    def absOption: Option[Int] =
      if !isMinValue then Some(n.abs) else None
    def negateOption: Option[Int] =
      if !isMinValue then Some(-n) else None

  println(42.negateOption)
  println(-42.negateOption)
  println(Int.MaxValue.negateOption)
  println(Int.MinValue.negateOption)


  

