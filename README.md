### Assignment Question

##### 1. Bucketise the given array[Double] into buckets having range interval (x, x+0.049).

######0.000 - 0.049
######0.050 - 0.099
######0.100 - 0.149
######0.150 - 0.199
######0.200 - 0.249
######0.250 - 0.299
######0.300 - 0.349
######0.350 - 0.399 
######...
######...
######100.000 - 100.049


######Sample -
######12.05, 12.03, 10.33, 11.45, 13.50
######Output- [12.050-12.099, 12.050-12.099, 10.300-10.349, 11.450-11.499, 13.500-13.549]

```

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
    }```
 #####2. For given players statistics..
   #####Found the below -
 #####1. Player with the best highest run scored.
 #####2. Top 5 players by run scored.
 #####3. Top 5 players by wicket taken.
 #####4. Rank players with overall performance give weight 5x to wicket taken and (5/100)x to run scored.
 #####Sample - 
 #####Year, PlayerName, Country, Matches, Runs, Wickets
 #####2021, Sam, India, 23, 2300, 3
 #####2021, Ram, India, 23, 300, 30
 #####2021, Mano, India, 23, 300, 13

```
object PlayerStatistics {

  case class PlayerStats(PlayYear: Int, playerName: String, Country: String, Matches: Int, Runs: Int, Wickets: Int)

  def main(args: Array[String]): Unit = {


    val players = List(
      PlayerStats(2021, "Sam", "India", 23, 2300, 3),
      PlayerStats(2021, "Ram", "India", 23, 300, 30),
      PlayerStats(2021, "kohli", "India", 23, 300, 13),
      PlayerStats(2021, "Rohit", "India", 23, 264, 13),
      PlayerStats(2021, "Dhoni", "India", 23, 2390, 13)
    )
    println("--------------------------------------------------------------------------------------------------------")
    println()
    //Finding the maximum score and the playerS
    val maximumScoringPlayer = players.maxBy(_.Runs)
    println(s"1) Player with the  maximum run is ${maximumScoringPlayer.playerName} with runs ${maximumScoringPlayer.Runs}")
    println("--------------------------------------------------------------------------------------------------------")

    //Finding the top five players
    //Using the while loop only
    val listofTopPlayers = players.sortBy(-_.Runs)
    var i = 0
    println("2) Top Five players with the following top score are this ->")
    while (i < 5) {
      print(s"${listofTopPlayers(i).playerName} with score ${listofTopPlayers(i).Runs}, ")
      i += 1
    }
    println()
    println("----------------------------------------------------------------------------------------------------------")

    //Finding the top five players in terms of the wickets
    //Using the while loop only
    val listofTopPlayersWithWickets = players.sortBy(-_.Wickets)
    var x = 0
    println("3) Top Five players with the following top Wickets are this ->")
    while (x < 5) {
      print(s"${listofTopPlayersWithWickets(x).playerName} with number of wickets are ${listofTopPlayersWithWickets(x).Wickets}, ")
      x += 1
    }
    println()
    println("----------------------------------------------------------------------------------------------------------")

    println(s"4) The Following players are sorted on the basis of the score")
    println()
    //Sort by the following criteria as given
    val collectionNew = players.map(x => (x.playerName, (x.Wickets) * 5 + x.Runs * (0.05)))
    val sortedByPlayers = collectionNew.sortBy(_._2).reverse
    for (i <- 0 until sortedByPlayers.length) {
      print(s"${sortedByPlayers(i)._1} with score ${sortedByPlayers(i)._2}")
      println()
    }

  }
}
```
