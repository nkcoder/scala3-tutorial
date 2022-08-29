package learn.nkcoder.scala3book.taste

@main def methods(): Unit =

  // methods
  def makeConnection(url: String, timeout: Int = 5000): Unit =
    println(s"url = $url, timeout = $timeout")

  makeConnection("localhost", 3000)
  makeConnection("localhost")
  makeConnection(url = "localhost", timeout = 4000)

  // extension
  extension (s: String)
    def capitalize = s.capitalize

    def makeInt(radix: Int): Int = Integer.parseInt(s, radix)

  println("hello world".capitalize)
  println("100".makeInt(2))
  println("110".makeInt(radix = 2))

