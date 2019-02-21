

val seq = Seq("A", "B", "C")
seq(1)

val set = Set("A", "B", "C")
set.contains("D")

val map = Map("A" -> 10, "C" -> 20, "B" -> 30)
map("B")

val immutableSeq = scala.collection.immutable.Seq(1, 2, 3)
val mutableSeq = scala.collection.mutable.Seq(1, 2, 3)
mutableSeq(0) = 10
immutableSeq(0) = 10 // error

seq.apply(1)
seq(1)
seq.head
seq.last

val seqEmpty = Seq()
seqEmpty.headOption // None or Some

seq.tail
seq.init

val seq1 = Seq(1, 2)
10 +: seq
seq :+ 10

val seq2 = Seq(3, 4, 5)
seq1 ++ seq2

val seq3: Seq[String] = Seq("A", "B", "C")
seq3.take(2)
seq3.takeRight(2)

val seq4 = Seq(1, 2, 3, 4, 5, 1, 2)
seq4.takeWhile(_ < 3) // Seq[Int] = List(1, 2)

seq4.drop(2)
seq4.dropRight(3)
seq4.dropWhile(_ < 3)

seq4.filter(_ > 2)

Seq(5, 1, 4, 2).sorted
Seq("abc", "bcd", "ab").sorted
Seq(5, 1, 4, 2).reverse

case class MyClass(i: Int, j: Int)
Seq(MyClass(3, 1), MyClass(1, 3), MyClass(2, 2)).sortBy(_.i)
Seq(MyClass(3, 1), MyClass(1, 3), MyClass(2, 2)).sortBy(_.j)

Seq("Hello", "Scala", "world").map(_.head)
Seq("Hello", "Scala", "world").map(_.length)
Seq(Seq(1, 2), Seq(), Seq(3, 4)).flatten
Seq("Hello", "Scala").map(_.toSeq).flatten
Seq("Hello", "Scala").flatMap(_.toSeq)

Seq(1, 2, 3).foldLeft(0)((accumulator, element) =>
  accumulator + element
)
Seq(1, 2, 3).foldLeft(0)(_ + _)
Seq(1, 2, 3).foldRight(0)(_ + _)

Seq("Hello", "Scala").foldLeft(0)(_ + _.length)
Seq("Hello", "Scala").foldRight(0)(_.length + _)

def reverseByFoldleft[A](seq: Seq[A]) =
  seq.foldLeft(Seq[A]())((a, e) => e +: a)

def reverseByFoldRight[A](seq: Seq[A]) =
  seq.foldRight(Seq[A]())((e, a) => a :+ e)

reverseByFoldRight(Seq(1, 2, 3))

Seq(1, 2, 3, 4, 5).reduceLeft(_ * _)
Seq(1, 2, 3, 4, 5).reduceRight(_ * _)

Seq(1, 2, 3, 1, 2).toSet
Seq("hello" -> 1, "world" -> 2).toMap

val s = mutable.Seq(1, 2)
s.update(1, 3)