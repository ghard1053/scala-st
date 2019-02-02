// 9-


object FileMatcher {
  private def filesHere = (new java.io.File(".")).listFiles

//  def filesEnding(query: String) =
//    for (file <- filesHere; if file.getName.endsWith(query))
//      yield file

//  def filesContaining(query: String) =
//    for (file <- filesHere; if file.getName.contains(query))
//      yield file

//  def filesRegex(query: String) =
//    for (file <- filesHere; if file.getName.matches(query))
//      yield file

  def filesMatching(query: String,
                    matcher: (String, String) => Boolean) = {
    for (file <- filesHere; if matcher(file.getName, query))
      yield file
  }

  def filesEnding(query: String) =
    filesMatching(query, _.endsWith(_))
  def filesContaining(query: String) =
    filesMatching(query, _.contains(_))
  def filesRegex(query: String) =
    filesMatching(query, _.matches(_))
}

object FileMatcher2 {
  private def filesHere = (new java.io.File(".")).listFiles
  private def filesMatching(matcher: String => Boolean) =
    for (file <- filesHere; if matcher(file.getName))
      yield file

  def filesEnding(query: String) =
    filesMatching(_.endsWith(query))
  def filesContaining(query: String) =
    filesMatching(_.contains(query))
  def filesRegex(query: String) =
    filesMatching(_.matches(query))
}


def containsNeg(nums: List[Int]): Boolean = {
  var exists = false
  for (num <- nums)
    if (num < 0)
      exists = true
  exists
}
containsNeg(List(1, 2, 3, 4))

def containsNeg2(nums: List[Int]) = nums.exists(_ < 0)

def containsOdd(nums: List[Int]): Boolean = {
  var exists = false
  for (num <- nums)
    if (num % 2 == 1)
      exists = true
  exists
}

def containsOdd2(nums: List[Int]) = nums.exists(_ % 2 == 1)


def plainOldSum(x: Int, y: Int) = x + y
def curriedSum(x: Int)(y: Int) = x + y
def first(x: Int) = (y: Int) => x + y
val second = first(1)
second(2)
val onePlus = curriedSum(1)_
onePlus(2)
val twoPlus = curriedSum(2)_
twoPlus(2)

def twice(op: Double => Double, x: Double) = op(op(x))
twice(_ + 1, 5)


import java.io.{File, PrintWriter}

def withPrintWriter(file: File, op: PrintWriter => Unit) = {
  val writer = new PrintWriter(file)
  try {
    op(writer)
  } finally {
    writer.close()
  }
}
withPrintWriter(
  new File("date.txt"),
  writer => writer.println(new java.util.Date)
)

def withPrintWriter2(file: File)(op: PrintWriter => Unit) = {
  val writer = new PrintWriter(file)
  try {
    op(writer)
  } finally  {
    writer.close()
  }
}
val file = new File("date.txt")
withPrintWriter2(file) { writer =>
  writer.println(new java.util.Date)
}


var assertionsEnabled = true
def myAssert(predicate: () => Boolean) =
  if (assertionsEnabled && !predicate())
    throw new AssertionError

def byNameAssert(predicate: => Boolean) =
  if (assertionsEnabled && !predicate)
    throw new AssertionError
