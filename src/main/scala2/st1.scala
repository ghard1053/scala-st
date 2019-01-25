// 1-3

import java.math.BigInteger

println("Hello world!")

val msg = "Hello world!"
val masg3: String = "Hello world!"

var greeting = "Hello world!"
greeting = "Hello, world!"

def max(x: Int, y: Int): Int = {
  if (x > y) x
  else y
}
def max2(x: Int, y: Int) = {
  if (x > y) x
  else y
}
max(3, 5)

def greet() = println("Hello, world!")


var i = 0
while (i < args.length) {
  println(args(i))
  i += 1
}

args.foreach(arg => println(arg))
args.foreach((arg: String) => println(arg))
args.foreach(println)

for (arg <- args)
  println(arg)



val big  = new BigInteger("12345")

val greetStrings: Array[Strng] = new Array[String](3)

for (i <- 0 to 2)
  print(greetStrings(i))

val numNames = Array("zero", "one", "two")
val numNames2 = Array.apply("zero", "one", "two")

val oneTwoThree = List(1, 2, 3)

val oneTwo = List(1, 2)
val threeFour = List(3, 4)
val oneTwoThreeFour = oneTwo ::: threeFour

val twoThree = List(2, 3)
val oneTwoThree2 = 1 :: twoThree

val oneTwoThree3 = 1 :: 2 :: 3 :: Nil


val pair = (99, "Luftballons")
println(pair._1)
println(pair._2)

var jetSet = Set("Boeing", "Airbus")
jetSet += "Lear"
println(jetSet.contains("Cessna"))

import scala.collection.mutable.Set
val movieSet = Set("Hitch", "Poltergeist")
movieSet += "Shrek"
println(movieSet)

import  scala.collection.immutable.HashSet
val hashSet = HashSet("Tomatoes", "Chilies")
println(hashSet + "Coriander")


import scala.collection.mutable.Map
val treasureMap = Map[Int, String]()
treasureMap += (1 -> "Go to island.")
treasureMap += (2 -> "Find big X on ground.")
treasureMap += (3 -> "Dig.")
println(treasureMap(2))

val romanNumeral = Map(
  1 -> "I", 2 -> "II", 3 -> "III", 4 -> "IV", 5 -> "V"
)
println(romanNumeral(4))


def printArgs(args: Array[String]): Unit = {
  for (arg <- args)
    println(arg)
}

def printArgs2(args: Array[String]): Unit = {
  args.foreach(println)
}

def formatArgs(args: Array[String]) = args.mkString("\n")
println(formatArgs(args))
