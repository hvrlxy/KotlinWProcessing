import kotlin.random.*

fun main (args: Array<String>){
	var count = 0
	var occured = BooleanArray(7)
	while ((occured[1]==false) || (occured[2]==false) ||(occured[2]==false) ||(occured[4]==false) ||(occured[5]==false) ||(occured[6]==false)){
		var i = Random.nextInt(1,7)
		occured[i] = true
		count ++
	}
	println(count)

}