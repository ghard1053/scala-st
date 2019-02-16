

// object
object Foo {
  def foo(): Unit = {
    println("foo")
  }
}

// apply
object Add {
  def apply(x: Int, y: Int): Int = x + y
}

// unary_
class MyString(val content: String) {
  def unary_! : String = "!" + content
}
val s = new MyString("Taro")
!s // !Taro

// case class
case class Point(x: Int, y: Int)

val map = Map(Point(10, 10) -> 1, Point(20, 20) -> 2)
map(Point(10, 10)) // 1
map(Point(20, 20)) // 2

val p = Point(1, 2)
p match {
  case Point(x, y) =>
    println(x) // 1
    println(y) // 2
}

// for
for (x <- 1 to 3; y <- 1 until 3 if x != y) {
  println("x = " + x + " y = " + y)
}
for (e <- List(1, 2, 3)) println(e)
for (e <- List(1, 2, 3)) yield {
  e + 1
}

// match
def reverse[A](list: List[A], result: List[A]): List[A] = list match {
  case x::xs => reverse(xs, x::result)
  case Nil => result
}
reverse(List(1, 2, 3), Nil)

// guard
val lst = List("A", "B", "C", "D", "E")
lst match  {
  case List("A", b, c, d, e) if b != "B" =>
    println("b=" + b)
    ///
  case _ =>
    println("nothing")
}

def last2[A](list: List[A]): A = list match {
  case x::_::Nil => x
  case x::xs => last2(xs)
  case _ => sys.error("list should have 2 elements at least")
}
last2(List(1, 2, 3))
last2(List(1))

// throw
throw new RuntimeException("runtime exception")

// try
try {
  throw new RuntimeException("runtime exception")
} catch {
  case e: Exception => println(e.getMessage)
}

// local method
def factorial(n: Int): Int = {
  def f(m: Int, x: Int): Int = if (m == 0) {
    x
  } else {
    f(m - 1, x * m)
  }
  f(n, 1)
}

// lazy
class Circle(x: Int, y: Int, radius: Int) {
  lazy val area: Double = {
    radius * radius * math.Pi
  }
}
val c = new Circle(0, 0, 5)

// generics
class Cell[A](var value: A) {
  def put(newValue: A): Unit = {
    value = newValue
  }
  def get: A = value
}

val cell = new Cell[String]("Hello")
cell.get // Hello
cell.put("World")
cell.get // World

// package object
package object mypackage {
  def hello(): Unit = {
    println("Hello")
  }
}

// 無名クラス
new Thread {
  override def run(): Unit = {
    for(i <- 1 to 10) println(i)
  }
}.start()

// implicit conversion
implicit def intToBoolean(n: Int): Boolean = n != 0

class RichInt(val self: Int) {
  def isPositive: Boolean = self > 0
}
implicit def enrichInt(self: Int): RichInt = new RichInt(self)
1.isPositive