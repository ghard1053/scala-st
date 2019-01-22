
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


def bf: Int => Int => Int = i => v => i + v
val fs = (1 to 100).map(bf).toArray
fs(0)(1)


def randomName = "I" + Math.abs((new java.util.Random).nextLong)

trait JavaScript

var callbacks: Map[String, () => JavaScript] = Map()

def register(f: () => JavaScript) = {
  val name = randomName
  callbacks += name -> f
  <button onclick={"invokeServerCall('"+name+"')"}>ClickMe</button>
}


sealed trait Expr
  case class Add(left: Expr, right: Expr) extends Expr
  case class Mul(left: Expr, right: Expr) extends Expr
  case class Val(value: Int) extends Expr
  case class Var(name: String) extends Expr

def calc(expr: Expr, vars: Map[String, Int]): Int = expr match {
  case Add(left, right) => calc(left, vars) + calc(right, vars)
  case Mul(left, right) => calc(left, vars) * calc(right, vars)
  case Val(v) => v
  case Var(name) => vars(name)
}

def buildCalc(expr: Expr): Map[String, Int] => Int = expr match {
  case Add(left, right) =>
    val lf = buildCalc(left)
    val rf = buildCalc(right)
    m => lf(m) + rf(m)

  case Mul(left, right) =>
    val lf = buildCalc(left)
    val rf = buildCalc(right)
    m => lf(m) * rf(m)

  case Val(v) => m => v

  case Var(name) => m => m(name)
}
