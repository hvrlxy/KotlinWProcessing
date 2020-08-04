var n = 0.0
var planet = ""

fun main (args: Array<String>){
	n = args[0].toDouble()
	planet = args[1]

	var EarthAge = n / 31557600.0

	if (planet == "Earth"){
		println(EarthAge.toInt())
	}

	else if (planet == "Mercury"){
		var MercuryAge = EarthAge / 0.2408467
		println(MercuryAge.toInt())
	}

	else if (planet == "Venus"){
		var VenusAge = EarthAge / 0.61519726
		println (VenusAge.toInt())
	}

	else if (planet == "Mars"){
		var MarsAge = EarthAge / 1.8808158
		println(MarsAge.toInt())
	}

	else if (planet == "Jupiter"){
		var JupiterAge = EarthAge / 11.862615
		println(JupiterAge.toInt())
	}

	else if (planet == "Saturn"){
		var SaturnAge = EarthAge / 29.447498
		println(SaturnAge.toInt())
	}

	else if (planet == "Uranus"){
		var UranusAge = EarthAge / 84.016846 
		println(UranusAge.toInt())
	}

	else if (planet == "Neptune"){
		var NeptuneAge = EarthAge / 164.79132
		println(NeptuneAge.toInt())
	}

	else{
		println("Please provide a planet")
	}

}