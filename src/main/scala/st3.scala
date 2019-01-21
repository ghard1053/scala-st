
val f: Int => String = x => "Dude: " + x
f.toString

def w42(f: Int => String) = f(42)
w42(f)

def fm(i: Int) = "fm " + i
w42((i: Int) => fm(i))
w42(i => fm(i))
w42(fm _)
w42(fm)

w42 {
  i =>
    val range = 1 to i
    range.mkString(",")
}

def plus(a: Int, b: Int) = "Result is: " + (a + b)
val p = (b: Int) => plus(42, b)

def add(a: Int)(b: Int) = "Result is: " + (a + b)
add(1)(2)

add(1){
  val r = new java.util.Random
  r.nextInt(100)
}

w42(add(1))

def f2 = add(1) _
w42(f2)

def t42[T](f: Int => T): T = f(42)

t42(f)
t42(1 +)

val intList: Int => List[Int] = i => (1 to i).toList
t42(intList)

t42[Int](1 +)

val foo = "dog"
val whoTo = (s: String) => s + " " + foo
whoTo("I love my")

var strs: List[String] = Nil
val strF = (s: String) => {strs ::= s; s + " Registered"}

strF("a")
strF("b")

List("p", "q", "r").map(strF)