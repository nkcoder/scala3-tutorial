package learn.nkcoder.scala3book.taste

@main def domainModeling(): Unit =
  // OO domain modeling
  trait Speaker:
    def speak(): String // has no body, so it’s abstract

  trait TailWagger:
    def startTail(): Unit = println("tail is wagging")

    def stopTail(): Unit = println("tail is stopped")

  trait Runner:
    def startRunning(): Unit = println("I’m running")

    def stopRunning(): Unit = println("Stopped running")

  class Dog(name: String) extends Speaker, TailWagger, Runner :
    def speak(): String = "Woof!"

  class Cat(name: String) extends Speaker, TailWagger, Runner :
    def speak(): String = "Meow"

    override def startRunning(): Unit = println("Yeah ... I don’t run")

    override def stopRunning(): Unit = println("No need to stop")

  val d = Dog(name = "Rover")
  val c = Cat(name = "Morris")
  println(d.speak())
  d.startRunning()
  d.stopRunning()
  println(c.speak())
  c.startTail()
  c.stopTail()

  // FP domain modeling
  enum CrustSize:
    case Small, Medium, Large

  enum CrustType:
    case Thin, Thick, Regular

  import CrustSize._
  val crustSize = Small
  crustSize match
    case Large => println("Large crust size")
    case Medium => println("Medium crust size")
    case Small => println("Small crust size")

  case class Person(name: String, vocation: String)
  val p = Person("Lebron James", "NBA player")
  println(p)
  val p2 = p.copy(name = "Steph Curry")
  println(p2)





