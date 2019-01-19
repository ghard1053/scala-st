
//for { i <- 1 to 10 }
//  println(i)
//
//for { i <- 1 to 10
//      j <- 1 to 10 }
//  println(i * j)

import scala.io._

def toInt(in: String): Option[Int] =
  try {
    Some(Integer.parseInt(in.trim))
  } catch {
    case e: NumberFormatException => None
  }

def sum(in: Seq[String]) = {
  val ints = in.flatMap(s => toInt(s))
  ints.foldLeft(0)((a, b) => a + b)
}

println("Enter some numbers and press ctrl-D (Unix/Mac) ctrl-Z (Windows)")

val input = Source.fromInputStream(System.in)

val lines = input.getLines().collect()

println("Sum "+sum(lines))

"""Hello
   Multiline
   World
"""

class Foo

class Bar(name: String)

class Baz(name: String) {
  if (name == null) throw new Exception("Name is null")
}

trait Dog

class Fizz2(name: String) extends Bar(name) with Dog

trait Cat {
  def meow(): String
}

trait FuzzyCat extends Cat {
  override def meow(): String = "Meeow"
}

trait OtherThing {
  def hello() = 4
}

class Yep extends FuzzyCat with OtherThing

object OneMethod {
  def myMethod() = "Only One"
}

object Dude extends Yep

object Dude2 extends Yep {
  override def meow() = "Dude looks like a cat"
}

object OtherDude extends Yep {
  def twoMeows(param: Yep) = meow + ", " + param.meow
}

class HasYep {
  object myYep extends Yep {
    override def meow = "Moof"
  }
}

class HasClass {
  private class MyDude extends FuzzyCat
  def makeOne(): FuzzyCat = new MyDude
}

class Frog {
  import scala.xml._
  def n: NodeSeq = NodeSeq.Empty
}

