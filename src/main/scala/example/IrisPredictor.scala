package example

import com.twitter.scalding._
import org.apache.hadoop.util.ToolRunner
import org.apache.hadoop.conf.Configuration
import com.twitter.algebird.{SGDPos, SGDMonoid, SGD}

/*
class IrisPredictor(args : Args) extends Job(args) {
  implicit val m = new SGDMonoid[(Double, IndexedSeq[Double])](SGD.constantStep(0.2), SGD.linearGradient)

  TextLine(args("input"))
    .mapPlusMap[SGDPos]('line -> 'sgd) { line : String ⇒
      val Array(sepalLength, sepalWidth, petalLength, petalWidth, _) = line.split(",")
      SGDPos(List(sepalLength.toDouble, sepalWidth.toDouble, petalLength.toDouble, petalWidth))
    }
    .groupBy
    .write(Tsv(args("output")))
}

object IrisPredictorRunner {
  def main(args : Array[String]) {
    val tool = new Tool {
      override def getJob(args: Args) = new IrisPredictor(args)
    }
    ToolRunner.run(new Configuration, tool, args)
  }
}
*/

object Test extends App {
  implicit val m = new SGDMonoid[(Double, IndexedSeq[Double])](SGD.constantStep(0.2), SGD.linearGradient)

  List(1.0, 2.0, 3.0, 4.0, 5.0)

  SGDPos(1.00) + SGDPos(2.00)
}