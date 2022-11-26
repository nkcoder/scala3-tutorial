package learn.nkcoder.scala3fetures.syntax

object UniversalApply extends App :

  class Computer(brand: String):
    def description = s"My brand is $brand"

  object Computer:
    def max(x: Int, y: Int): Int = if x > y then x else y

  /*
   A constructor proxy companion object C is created for a concrete class C, provided:
   - the class does not have already a companion,
   - and there is also no other value or method named C defined or inherited in the scope where C is defined.

   Constructor proxy `apply` methods are generated for a concrete class provided:
    - the class has a companion object (which might have been generated in step 1), and
      that companion object does not already define a member named apply.
    - Each generated apply method forwards to one constructor of the class. It has the same type and value parameters
      as the constructor.

  object Computer:
    inline def apply(brand: String): Computer = new Computer(brand)
  */

  val macBookPro = Computer("Apple")
  val sony = Computer("sony")
  println(s"${macBookPro.description}")
  println(s"${sony.description}")


