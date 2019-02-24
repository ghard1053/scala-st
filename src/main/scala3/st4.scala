
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

val either: Either[String, Long] = Right(1)
either.map(_ * 2)
either.right.map(_ * 2)
either.left.map(_ + "!")

val rr: Either[String, Long] = Right(100)
rr.flatMap(l => Right(l * 5)) // Right(500)
rr.flatMap(_ => Left("Error")) // Left(Error)
val l1: Either[String, Long] = Left("Error 1")
l1.flatMap(l => Right(l * 5)) // Left(Error 1)

Right(1).getOrElse(100)
Left("foo").getOrElse(100)

val intEither = Right(123)
intEither.merge // 123
val stringEither: Either[String, String] = Left("foo")
stringEither.merge // foo


// try
import scala.util.Try

def div(a: Int, b: Int): Try[Int] = Try(a / b)
div(10, 3) // Success(3)
div(10, 0) // Failure

div(10, 3).foreach(println) // 3
div(10, 0).foreach(println)
div(10, 3).failed.foreach(println)
div(10, 0).failed.foreach(println)

div(10, 3).map(_ * 3) // Success(9)
div(10, 0).map(_ * 3)
div(10, 3).flatMap(i => div(12, i)) //Success(4)
div(10, 0).flatMap(i => div(12, i))

div(10, 0).recover {
  case e: ArithmeticException => 0
} // Success(0)
div(10, 0).recoverWith {
  case e: ArithmeticException => Try(1 + 1)
} // Success(2)

div(10, 3).getOrElse(-1) // 3
div(10, 0).getOrElse(-1) // -1