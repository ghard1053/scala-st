

def isAlphanumeric(str: String): Boolean = str.matches("a-z")
//val isAlphamericF = isAlphanumeric _

//val isAlphamericF = (str: String) => str.matches("a-z")

val isAlphamericF = new Function1[String, Boolean] {
  def apply(str: String) = str.matches("a-z")
}

val words = Seq("Scala", "2.12")
val alphamericWords = words.filter(isAlphamericF)


val weight = 120
var message: String = null
if (weight <= 100) message = "OK"
else message = "over"

val message2 = if (weight <= 100) {
  "OK"
} else {
  "over"
}

val message3 = if (weight <= 100) "OK" else "over"

val n = 5
n match {
  case 1 => println("gold")
  case 2 => println("silver")
  case 3 => println("bronze")
  case other => println("no prize")
}

val maybeNum: Option[Int] = Some(123)
val maybeNum2: Option[Int] = None

val num: Int = maybeNum match {
  case Some(num) if num < 0 => 0
  case Some(num) => num
  case None => 0
}

num match  {
  case 1 | 2 | 3 => println("Less than 4")
  case 4 => println("Equal to 4")
  case other => println("Greater than 4")
}

var i = 0
while (i < 3) {
  println(i)
  i += 1
}

val filtered = Seq(1, 2, 3).filter(i => i > 1)
val doubled = Seq(1, 2, 3).map(i => i * 2)
Seq(1, 2, 3).filter(_ > 1)
Seq(1, 2, 3).map(_ * 2)

Seq(Seq(1, 2), Seq(3, 4)).flatMap { s => println(s); s }

val results: Seq[Int] = for {
  i <- (1 to 3)
  j <- (2 to 4)
  k <- (3 to 5)
  result = (i * j * k) if result % 3 == 0
} yield result


def puts(value: String): Unit = {
  println(value)
}
puts("Hello")

val x: Unit = ()
val y: Unit = x


def add(x: Int, y: Int): Int = ???

def requirePositive(n: Int): Int =
  if (n > 0) n else throw new IllegalArgumentException("n must be positive")

s"1 + 2 = ${1 + 2}"

val a = 1
s"a = $a"

val p: (Int, Int) = (10, 20)
p._1
p._2

val q: (Int, Int, Int) = (30, 40, 50)
q._1
q._2
q._3

q match {
  case (x, y, z) =>
    println(x)
    println(y)
    println(z)
}

//type Point = (Int, Int, Int)
//val p: Point = (60, 70, 80)

val person: (String, Int) = ("Taro", 18)
person._1
person._2


val p1: Point = new Point(10, 10)
val p2: Point = new Point(100, 100)
println(p1.distance(p2))
println(math.abs(p1.x - p2.x))
println(p1 + p2)

class Point(val x: Int, val y: Int) {
  def distance(that: Point): Int = {
    val xdiff = math.abs(this.x - that.x)
    val ydiff = math.abs(this.y - that.x)
    math.sqrt(xdiff * xdiff + ydiff * ydiff).toInt
  }
  def +(that: Point): Point =
    new Point(x + that.x, y + that.y)
}

abstract class Shape {
  def draw(): Unit = {
    println("不明な図形")
  }
}

class Triangle extends Shape {
  override def draw(): Unit = {
    println("三角形")
  }
}
class Rectangle extends Shape {
  override def draw(): Unit = {
    println("四角形")
  }
}
class UnknownShape extends Shape


trait Namable {
  val name: String
  def display(): Unit = println(name)
}

class Employee(val name: String) extends AnyRef with Namable

val taro = new Employee("taro")
taro.display()


import scala.collection.mutable.Buffer
trait Enumerable[A] {
  def foreach[B](fun: A => B): Unit

  final def map[B](f: A => B): List[B] = {
    var members = Buffer.empty[A]
    foreach {m =>
      members += f(m)
    }
    members.toList
  }

  final def filter(p: A => Boolean): List[A] = {
    val members = Buffer.empty[A]
    foreach {m =>
      if (p(m)) members += m
    }
    members.toList
  }

  final def toList: List[A] = {
    val members = Buffer.empty[A]
    foreach {m =>
      members += m
    }
    members.toList
  }
}

class Staff(val name: String, val age: Int)

class Shop(val name: String) extends AnyRef with Enumerable with Namable {
  private[this] staffs: List[Staff] = List("taro", "jiro")

  override def foreach[B](f: A => B): Unit = staffs.foreach(f)
  ///
}

///
val shop = ///
shop.filter(_.age >= 20)

shop.map(_.name)

shop.toList
shop.display()