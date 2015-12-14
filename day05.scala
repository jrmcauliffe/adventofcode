#!/usr/bin/env scalas

import scala.io.Source

val in = Source.fromFile("./day05.input").getLines.toList

def hasThreeVowels(s: String): Boolean = {
  s.toList.filter(Seq('a','e','i','o','u').contains(_)).length >= 3 
}

def hasDoubleLetter(s: String): Boolean = {
  s.zip(s.tail).filter(p => p._1 == p._2).length > 0
}

def hasMagicPair(s: String): Boolean = {
  s.zip(s.tail).filter(_ match {
      case ('a','b') => true
      case ('c','d') => true
      case ('p','q') => true
      case ('x','y') => true
      case _ => false 
    }).length > 0
}

def nOrN(s: String): Boolean = {
  hasThreeVowels(s) && hasDoubleLetter(s) && !hasMagicPair(s)
}

def hasDoublePair(s: String): Boolean = {

  val pairsWithLocation = s.zip(s.tail).zipWithIndex
  val groups = pairsWithLocation.groupBy(_._1)
  val sortedByIndex = groups.map(_._2.sortWith((a,b) => a._2 > b._2))
  sortedByIndex.filter(x => x.head._2 - x.reverse.head._2 > 1).size > 0
}

def hasRepeatWithGap(s: String): Boolean = {
  val triplets = s.zip(s.tail).zip(s.tail.tail).map(x => (x._1._1, x._1._2, x._2))
  triplets.filter(p => p._1 == p._3).length > 0
}

def newNOrN(s: String): Boolean = {
  hasDoublePair(s) && hasRepeatWithGap(s)
}
println("Part 1: " + in.filter(nOrN(_)).length)

println("Part 2: " + in.filter(newNOrN(_)).length)
println("Part 2: " + hasDoublePair("aabaa"))
