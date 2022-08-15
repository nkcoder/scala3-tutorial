package org.nkcoder.classandobjects

object SemicolonDemo extends App:
  /* semicolon inference */
  // the semicolon at the end of a statement is usually optional
  val world = "world"
  println(world)

  // a semicolon is required if you write multiple statements on the same line
  val hello = "hello"; println(hello)
