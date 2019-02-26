
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

// デフォルト引数
def join(list: List[String], separator: String): String =
  list.mkString(separator)
join(List("a", "b", "c"), "") // "abc"

def join2(list: List[String], separator: String = ""): String =
  list.mkString(separator)
join(List("a", "b", "c")) // "abc"
