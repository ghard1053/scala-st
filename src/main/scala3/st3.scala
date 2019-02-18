

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

val seqq: Seq[String] = Seq("A", "B", "C")
