#!/usr/bin/env scalas

import scala.io.Source

val in = Source.fromFile("./day01.input").getLines.toList.head

val split = in.partition(_ == '(')

println("Part 1: " + (split._1.length - split._2.length).toString)

val nums = in.map(x => if(x == '(') 1 else -1)

println("Part 2: " + ((nums.scanLeft(0)(_+_)).tail.takeWhile(_ != -1).length + 1).toString)
