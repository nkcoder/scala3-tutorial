package pis5.chp4

import scala.collection.mutable
import scala.util.Random

object SingletonObject:
  private val cache = mutable.Map.empty[String, Int]
  private val random = new Random

  def calculate(s: String): Int = 
    if cache.contains(s) then
      cache(s)
    else
      val value = random.nextInt(1000)
      cache.put(s, value)
      value
