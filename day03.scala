#!/usr/bin/env scalas

import scala.io.Source

val in = Source.fromFile("./day03.input").getLines.toList.head.toList

val moves = in.map(_ match {
                      case '^' => (0, 1)
                      case 'v' => (0, -1)
                      case '>' => (1, 0)
                      case '<' => (-1, 0)
})
def move(res: Tuple2[Int, Int], x: Tuple2[Int, Int]) = {
  (res._1 + x._1, res._2 + x._2)

}
println("Part 1: " + (moves.scanLeft((0,0))(move)).distinct.length)

val santa = moves.sliding(1,2).toList.map(_.head).scanLeft((0,0))(move)
val robo = moves.tail.sliding(1,2).toList.map(_.head).scanLeft((0,0))(move)

println("Part 2: " + (santa ::: robo).distinct.length)
