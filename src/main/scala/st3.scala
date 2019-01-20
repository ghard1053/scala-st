
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