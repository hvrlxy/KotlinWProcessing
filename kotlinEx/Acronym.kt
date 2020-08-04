fun main(args: Array<String>){
	var acronym = ""
	for (i in 0 until args.size){
		acronym +=  args[i][0].toUpperCase()
	}
	println(acronym)
	return
}
