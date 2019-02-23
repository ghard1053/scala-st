

// Option
val size1 = fileSize(new File("README.md"))
size1.foreach(println)

Option(123L).map(_.toString)
None.map(_.toString)

def fileSize(file: File): Option[Long] =
  if (file.exists()) Option(file.length()) else None

val maybeFile = Option(new File("abc.txt"))

maybeFile.flatMap(fileSize)

def plus(option1: Option[Int], option2: Option[Int]): Option[Int] =
  option1.flatMap(i => option2.map(j => i + j))

plus(Option(2), Option(3)) // Some(5)
plus(Option(2), None) // None

def plus2(option1: Option[Int], option2: Option[Int]): Option[Int] =
  for (i <- option1; j <- option2) yield i + j

def getIntOrZero(option: Option[Int]): Int = option.getOrElse(0)
getIntOrZero(Option(123)) // 123
getIntOrZero(None) // 0


// Either
import java.io.File

def fileSize(file: File): Either[String, Long] =
  if (file.exists()) Right(file.length()) else Left("File not exists")

val r: Either[String, Int] = Right(100)
r.foreach(println)

val l: Either[String, Int] = Left("Hello")
l.foreach(println)

r.left.foreach(println)
l.left.foreach(println)

