
object BucketWise{
  private def changeNum(d: Double):Double={

    val temp=d*1000
//    println(s"temp value ="+temp)
    val remByHun=temp%100
//    println(remByHun)
    var desiredOutput=0.000
    if(remByHun < 50)
      desiredOutput=(temp-remByHun)/1000.000
    else
      desiredOutput=(temp-remByHun)/1000.00 +0.050

    desiredOutput
  }

  def main(args:Array[String])={
    val numbers = List(12.05, 12.03, 10.45, 11.299, 13.350,12.677,12.55)
    val ranges = numbers.map { numb =>
//      println(numb)
      val num=((numb%1).abs)+0.0001
      val lowerBound = math.floor(numb) + changeNum(num)
      val upperBound = lowerBound + 0.049
      f"$lowerBound%.3f-$upperBound%.3f"
    }
    println(ranges)
  }
}