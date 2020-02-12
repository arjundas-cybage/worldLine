package com.org.cybage

import java.io.{PrintWriter, _}

import scala.util.{Failure, Success, Try, Using}
object MaxTotal {
  def main(args: Array[String]): Unit = {
    val file = args.length match {
      case 0 => "./triangle.txt" //Default name
      case _ => args(0)
    }
// checks for success in parse data
    parseData(file) match {
      case Success(data) => writeData(computeMaxTotal(data), "Output.txt")
      case Failure(error) => println("Got error: " + error + "\n" + "Usage:\n maxtotal <input>.txt" )
    }
  }
//// Parses the data if the file is present at the desired location.
  def parseData(file: String): Try[Array[Array[Int]]] = {
    Using(scala.io.Source.fromFile(file)) {
      source => source.getLines.map(s => s.trim.split("\\s+").map(_.toInt)).toArray
    }
  }

def writeData(data:Int , file :String){
  val writer = new PrintWriter(new File(file))
  writer.write("Max total:  " + data )
  writer.close()
  }

  //compute Max- Total
  def computeMaxTotal(data: Array[Array[Int]]): Int =
  //Start from last 2 rows & then move up the pyramid
    data.reduceRight((topRow, bottomRow) =>
      topRow zip (bottomRow zip bottomRow.tail)
        map {case (topRowCol, (bottomRowLeftCol, bottomRowRightCol)) => topRowCol + Math.max(bottomRowLeftCol, bottomRowRightCol)}
    ).head
}
