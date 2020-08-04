import kotlin.random.*
import kotlin.math.*

var n = 0F
var trials = 0F
var x = 250F
var y = 250F
var i = Random.nextInt()
var distanceSum = 0F
var distanceMean = 0F
var distance = 0F

fun main (args: Array<String>){

  if (args.size != 2){
    println("Please provide two valid arguments")
  }

  else {
    n = args[0].toFloat()
    trials = args[1].toFloat()
      for (trial in 0 until trials.toInt()){
        for (step in 0 until n.toInt()){
          i = Random.nextInt(4)
          if (i == 0 ){
              x = x
              y--
          }
          else if (i == 1){
              x = x
              y++
          }
          else if (i == 2){
              x++
              y = y
          }
          else{
              x--
              y = y
          }
        }
      distance = (x-250F).pow(2F)+(y-250F).pow(2F)
      distanceSum = distanceSum + distance
      x = 250F
      y = 250F
      }
    distanceMean = distanceSum / trials
    println("mean squared distance = $distanceMean")
  }
}
