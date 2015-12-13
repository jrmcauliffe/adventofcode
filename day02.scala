#!/usr/bin/env scalas

import scala.io.Source

val in = Source.fromFile("./day02.input").getLines.toList.map(_.split('x').map(_.toInt))

def paperCalc(l: Int, w: Int, h: Int) = {
  val sides = List(l*w, w*h, h*l).sorted
  sides.map(_ * 2).sum + sides.head
}

def ribbonCalc(l: Int, w: Int, h: Int) = {
  val s = List(l, w, h).sorted
  2* (s(0) + s(1)) + l*w*h
}

println("Part 1: " + in.map(l => paperCalc(l(0),l(1),l(2))).sum)

println("Part 2: " + in.map(l => ribbonCalc(l(0), l(1), l(2))).sum)
