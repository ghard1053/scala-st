
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

List(8, 6, 22, 2).reduceLeft(_ max _)
List(1, 2, 3, 4).foldLeft(0) (_ + _)

val n = (1 to 3).toList
n.map(i => n.map(j => i * j))
n.flatMap(i => n.map(j => i * j))

def isOdd(in: Int) = in % 2 == 1
def isEven(in: Int) = !isOdd(in)
val n = (1 to 10).toList
for  { i <- n if isEven(i); j <- n if isOdd(j)} yield i * j

def sumSq(in: List[Double]): (Int, Double, Double) =
  in.foldLeft((0, 0d, 0d))((t, v) => (t._1 + 1, t._2 + v, t._3 + v * v))

def sumSq(in: List[Double]) : (Int, Double, Double) =
  in.foldLeft((0, 0d, 0d)) {
    case ((cnt, sum, sq), v) => (cnt + 1, sum + v, sq + v * v)}
  }

var p = Map(1 -> "David", 9 -> "Elwood")
p + 8 -> "Archer"
p = p + 8 -> "Archer"
p += 8 -> "Archer"
p(9)
p.get(88) // None
p.get(9) // Some(Elwood)

p.getOrElse(99, "Nobody")

p -= 9
p.contains(1) // Boolean = true

p.keys.reduceLeft(_ max _)
p.values.reduceLeft((a, b) => if (a > b) a else b)
p.values.exists(_.contains("z"))
p ++= List(5 -> "Cat", 6 -> "Dog")
p --= List(8, 6)

def removeInvalid(in: Map[Int, Person]) = in.filter(kv => kv._2.valid)


def findPerson(key: Int): Option[Person]
def ageFromKey(key: Int): Option[Int] = findPerson(key).map(_.age)

import java.lang.{Boolean => JBool}

def tryo[T](f: => T): Option[T] = try {Some(f)} catch {case _ => None}
def toInt(s: String): Option[Int] = tryo(s.toInt)
def toBool(s: String) = tryo(JBool.parseBoolean(s))

def personFromParams(p: Map[String, String]): Option[Person] =
  for {name <- p.get("name")
       ageStr <- p.get("age")
       age <- toInt(ageStr)
       validStr <- p.get("valid")
       valid<- toBool(validStr)}
   yield new Person(name, age, valid)

Some(3).getOrElse(44)
None.getOrElse(44)