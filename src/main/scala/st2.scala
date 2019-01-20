
val x = List(1, 2, 3, 4)
x.filter(a => a % 2 == 0)

val a = Array(1, 2, 3)
a(1)

val m = Map("one" -> 1, "two" -> 2, "three" -> 3)
m("two")

(1 to Integer.MAX_VALUE - 1).take(5)

1 :: 2 :: 3 :: Nil

val xy = List(1, 2, 3)
99 :: xy

val xxx = List(1, 2, 3)
val yyy = List(99, 98, 97)
xxx ::: yyy

List(1, 2, 3).filter(x => x % 2 == 1)

List(1, 2, 3).remove(x => x % 2 == 1)

def isOdd(x: Int) = x % 2 == 1
List(1, 2, 3, 4, 5).filter(isOdd)

"99 Red Balloons".toList.filter(Character.isDigit)
"Elwood eats mice".takeWhile(c => c != ' ')

List("A", "Cat").map(s => s.toLowerCase)
List("A", "Cat").map(_.toLowerCase)
List("A", "Cat").map(_.length)

//trait Person { def first: String }
//val dd = new Person { def first = "David"}
//val ee = new Person { def first = "Elwood"}
//val aa = new Person { def first = "Archer"}
//List(dd, ee, aa).map(_.first)
//List(dd, ee, aa).map(n => <li>{n.first}</li>)

List(99, 2, 1, 45).sort(_ < _)

List("b", "a", "elwood", "archer").sort(_ < _)
List("b", "a", "elwood", "archer").
  sort(_.length > _.length)

trait Person {
  def age: Int
  def first: String
  def valid: Boolean
}

def validByAge(in: List[Person]) =
    in.filter(_.valid).
    sort(_.age < _.age).
    map(_.first)
