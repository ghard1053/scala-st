// 8-


import scala.io.Source

object LongLines {
  def processFile(filename: String, width: Int) = {
    val source = Source.fromFile(filename)
    for (line <- source.getLines())
      processLine(filename, width, line)
  }
  private def processLine(filename: String,
                          width: Int, line: String) = {
    if (line.length > width)
      println(filename + ": " + line.trim)
  }
}

object FindLongLines {
  def main(args: Array[String]) = {
    val width = args(0).toInt
    for (arg <- args.drop(1))
      LongLines.processFile(arg, width)
  }
}

// ---------------------------

object LongLines {
  def processFile(filename: String, width: Int) = {
    def processLine(line: String) = {
      if (line.length > width)
        println(filename + ": " + line.trim)
    }
    val source = Source.fromFile(filename)
    for (line <- source.getLines())
      processLine(line)
  }
}


var increase = (x: Int) => x + 1
increase(10)

val someNumbers = List(-11, -10, -5, 0, 5, 10)
someNumbers.foreach((x: Int) => println(x))
someNumbers.filter((x: Int) => x > 0)

someNumbers.filter((x) => x > 0)
someNumbers.filter(x => x > 0)

someNumbers.filter(_ > 0)

val f = (_: Int) + (_: Int)

someNumbers.foreach(println _)
someNumbers.foreach(println)

val a = sum _

val b = sum(1, _: Int, 3)


var more = 1
val addMore = (x: Int) => x + more
addMore(10) // 11

var sum = 0
someNumbers.foreach(sum += _)

def makeIncreaser(more: Int) = (x: Int) => x + more
val inc1 = makeIncreaser(1)
val inc9999 = makeIncreaser(9999)
inc1(10)
inc9999(10)


def echo(args: String*) =
  for (arg <- args) println(arg)

var arr = Array("a", "b", "c")
echo(arr: _*)

def printTime(out: java.io.PrintStream = Console.out) =
  out.println("time = " + System.currentTimeMillis())

def printTime2(out: java.io.PrintStream = Console.out, divisor: Int = 1) =
  out.println("time = " + System.currentTimeMillis()/divisor)
printTime2(out = Console.err)
printTime2(divisor = 1000)


def approximate(guess: Double): Double =
  if (isGoodEnough(guess)) guess
  else approximate(improve(guess))

def bang(x: Int): Int =
  if (x == 0) throw new Exception("bang!")
  else bang(x - 1)
