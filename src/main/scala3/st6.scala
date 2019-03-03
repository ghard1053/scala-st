
// companion object
class Person private(name: String, age: Int)
object Person {
  def apply(name: String, age: Int): Person = new Person(name, age)
}

// pertial function
val dbl: PartialFunction[Int, Int] = { case n if n >= 0 => n * 2 }
dbl.isDefinedAt(1) // true
dbl.isDefinedAt(0) // true
dbl.isDefinedAt(-1) // false
dbl.apply(1) // 2
dbl(1) // 2

List(1, 2, 3).collect { case n if n < 3 => n * 2 }

// default parameter
def join(list: List[String], separator: String): String =
  list.mkString(separator)
join(List("a", "b", "c"), "") // "abc"

def join2(list: List[String], separator: String = ""): String =
  list.mkString(separator)
join(List("a", "b", "c")) // "abc"

// 名前付き引数
def drawCircle(x: Int, y: Int, radius: Int) = ???
drawCircle(x = 100, y = 100, radius = 5)
drawCircle(radius = 5, x = 100, y = 100)

// 値クラス
case class Meter(value: Int)

case class Meter2(value: Int) extends AnyVal

implicit class StringExtention(val self: String) extends AnyVal {
  def display(): Unit = println(self)
}
"F00".display()

// 型メンバ
class TypeMembers {
  type T = String
  val t: T = "FOO"
}

trait Stacks {
  type T
  sealed abstract class Stack {
    def isEmpty: Boolean
    def top: T
    def pop: Stack
    def push(e: T): Stack = NonEmptyStack(e, this)
  }
  case class NonEmptyStack(head: T, tail: Stack) extends Stack {
    def isEmpty: Boolean = false
    def top: T = head
    def pop: Stack = tail
  }
  case object EmptyStack extends Stack {
    def isEmpty: Boolean = true
    def top: T = ???
    def pop: Stack = ???
  }
}

class IntStacks extends Stacks {
  type T = Int
  val stack = EmptyStack.push(1).push(2).push(3)
  println(stack.top) // 3
}

// 自分型アノテーション
trait ModuleA {
  def methodA(): Unit
}

trait ModuleB {self: ModuleA =>
  def methodB(): Unit = {
    methodA
  }
}

//
List(1, 2, 3).map((x) => { println(x); x + 1})
List(1, 2, 3).map{x => println(x); x + 1}

//
def each[T](list: List[T])(f: T => Unit): Unit = {
  list.foreach(f)
}
each(List(1, 2, 3)){x =>
  println(x)
}

val f = each(List(1, 2, 3)) _
f{x => print(x)} // 123

// eta(η) expansion
List(1, 2, 3, 4, 5).foreach(println _)
List(1, 2, 3, 4, 5).foreach(println)
List(1, 2, 3, 4, 5).foreach(x => println(x))

// by-name parameter

// extractor
object Positive {
  def unapply(n: Int): Option[Int] = if (n > 0) Some(n) else None
}

1 match {
  case Positive(_) =>
    println("1 is positive")
  case _ =>
    println("1 is not positive")
}
-1 match {
  case Positive(_) =>
    println("-1 is positive")
  case _ =>
    println("-1 is not positive")
}

object Positive2 {
  def unapply(n: Int): Boolean = n > 0
}

1 match {
  case Positive2() =>
    println("is positive")
  case _ =>
    print("is not positive")
}

// implicit
package hoge
trait Adder[T] {
  def zero: T
  def plus(x: T, y: T)
}
object Adder {
  implicit object IntAdder extends Adder[Int] {
    def zero: Int = 0
    def plus(x: Int, y: Int): Int = x + y
  }
  implicit object StringAdder extends Adder[String] {
    def zero: String = ""
    def plus(x: String, y: String): String = x + y
  }
}

import hoge.Adder
def sum[T](list: List[T])(implicit adder: Adder[T]): T =
  list.foldLeft(adder.zero) {
    (x, y) => adder.plus(x, y)
  }

sum(List(1, 2, 3))
sum(List("A", "B", "C"))


// 式指向
import scala.annotation.tailrec

def sumUp(start: Int, end: Int): Int = {
  @tailrec
  def doSumUp(current: Int, subtotal: Int): Int =
    if (current > end)
      subtotal
    else
      doSumUp(current + 1, subtotal + current)

  doSumUp(start, 0)
}

def sumUp2(start: Int, end: Int): Int = (start to end).sum

