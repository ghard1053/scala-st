
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

def nano() = {
  println("Getting nano")
  System.nanoTime()
}

def delayed(t: => Long) = {
  println("In delayed method")
  println("Param: "+t)
  t
}

44 match {
  case 44 => true
  case _ => false
}

"David" match {
  case "David" => 45
  case "Elwood" => 77
  case _ => 0
}

Stuff("David", 45) match {
  case Stuff("David", 45) => true
  case _ => false
}
Stuff("David", 45) match {
  case Stuff("David", _) => "David"
  case _ => "Other"
}
Stuff("David", 45) match {
  case Stuff("David", howOld) => "David, age: " + howOld
  case _ => "Other"
}
Stuff("David", 45) match {
  case Stuff("David", age) if age < 30 => "young David"
  case Stuff("David", _) => "old David"
  case _ => "Other"
}
x match {
  case d: java.util.Date => "The date in milliseconds is " + d.getTime
  case u: java.net.URL => "The URL path: " + u.getPath
  case s: String => "String: " + s
  case _ => "Something else"
}

if (exp) {
  println("Line one")
  println("Line two")
}

val i: Int = if (exp) 1 else 3
val i: Int = if (exp) 1
else {
  val j = System.currentTimeMillis()
  (j % 100L).toInt
}

for {i <- 1 to 3} println(i)
for {i <- 1 to 3
     j <- 1 to 3} println(i * j)

def isOdd(in: Int) = in % 2 == 1
for {i <- 1 to 5 if isOdd(i)} println(i)
for {i <- 1 to 5
     j <- 1 to 5 if isOdd(i * j)} println(i * j)

val lst = (1 to 18 by 3).toList
for {i <- lst if isOdd(i)} yield i

try {
  throw new Exception("Working...")
} finally {
  println("This will always be printed")
}

try {
  file.write(stuff)
} catch {
  case e: java.io.IOException => //
  case n: NullPointerException => //
}

def foo(): Int = synchronized {
  42
}