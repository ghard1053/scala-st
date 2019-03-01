
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

