

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

