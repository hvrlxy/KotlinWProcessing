typealias DoubleConversion = (Double) -> Double

fun convert(x: Double, converter: DoubleConversion): Double {
	val result = converter(x)
	println("$x is converted into $result")
	return result
}

fun getConversionLambda(str: String): DoubleConversion {
	if (str == "CentigradeToFahrenheit"){
		return {it * 1.8 + 32}
	}

	else if (str == "KgsToPounds"){
		return {it * 2.204623}
	}

	else if (str == "PoundsToUSTons"){
		return {it/2000.0}
	}

	else{
		return {it}
	}
}

fun combine(lambda1: DoubleConversion,
	lambda2: DoubleConversion): DoubleConversion{
	return {x: Double -> lamdba2(lambda1(x))}
}

fun main(args:Array<String>){
	println("Convert 2.5kg to pounds: ${getConversionLambda("KgsToPounds") (2.5)}")
	val KgsToPoundsLambda = getConversionLambda("KgsToPounds")
	val PoundsToUSTonsLambda = getConversionLambda("PoundsToUSTons")

	val kgsToUSTonsLambda = combine(KgsToPoundsLambda, PoundsToUSTonsLambda)
	val value = 17.4
	println("$value kgs is ${convert(value, kgsToUSTonsLambda)} US tons")
}











