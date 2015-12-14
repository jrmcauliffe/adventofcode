#!/usr/bin/env scalas

import scala.io.Source
import java.security.MessageDigest
import javax.xml.bind.DatatypeConverter

val in = Source.fromFile("./day04.input").getLines.toList.head

def md5(text: String) = DatatypeConverter.printHexBinary(MessageDigest.getInstance("MD5").digest(text.getBytes()))

def l(key: String, start: Int): Stream[String] = md5(key + start.toString) #:: l(key, start +1)

println("Part 1: " + (l(in,1).takeWhile(_.take(5) != "00000").length + 1)) 

println("Part 2: " + (l(in,1).takeWhile(_.take(6) != "000000").length + 1))
