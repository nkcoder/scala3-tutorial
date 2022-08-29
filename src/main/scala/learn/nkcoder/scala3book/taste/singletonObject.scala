package learn.nkcoder.scala3book.taste

@main def singletonObject(): Unit = 
  // utility methods
  object StringUtils:
    def isNullOrEmpty(s: String): Boolean = s == null || s.trim.isEmpty
    def leftTrim(s: String): String = s.replaceAll("^\\s+", "")
    def rightTrim(s: String): String = s.replaceAll("\\s+$", "")

  println(StringUtils.isNullOrEmpty(""))
  println(StringUtils.leftTrim("   Hello"))


  // companion object
  import scala.math.*
  class Circle(radius: Double):
    import Circle.*
    def area: Double = calculateArea(radius)

  object Circle:
    private def calculateArea(radius: Double): Double = 
      Pi * pow(radius, 2.0)

  val circle = Circle(10.0)
  println(s"circle.area = ${circle.area}") 


  // create modules from traits
  trait AddService:
    def add(a: Int, b: Int): Int = a + b

  trait MultiplyService:
    def multiply(a: Int, b: Int): Int = a * b

  object MathService extends AddService, MultiplyService

  import MathService.*
  println(add(1, 5))
  println(multiply(3, 4))



