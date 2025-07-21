fun main(){
    //student names
    val names = arrayOf("Rawan","Jana","Ash","Doaa")
    //students scores
    val scores = mutableMapOf(
        "Rawan" to 100,
        "Jana" to 100,
        "Ash" to 50,
        "Doaa" to 100,
        )
    //graduated students
    val graduated = setOf("Rawan","Doaa")
    println("Names: ${names.contentToString()}") //will output as array
    println("Scores: $scores") //will output as mutable map
    println("Graduates: $graduated") //will output as a set


    println("----------")
    for (name in names) {
        println(name)
    }
    println("------------")

    names.forEach { name ->
        if (name in graduated) {
            return@forEach // to skip grads
        }
        val score = scores[name]
        println("Students that did not graduate: $name: $score") //to print students that did not grad
    }

    println("------------")
    //Upercase by map
    val uppercaseNames = names.map { it.uppercase() }
    println("Uppercased Names: $uppercaseNames")

    //80 above filter
    val best = scores.filter { it.value > 80 }.map { it.key }
    println("80 and above: $best")

    //Chain operations: filter → map → print final results.
    println("Students with high scores (uppercase):")
    scores
        .filter { it.value > 80 } //  students scores above 80
        .map { it.key.uppercase() } // names to uppercase
        .forEach { println(it) } //prints each name
    //the chain operations and dots for better readability


    println("------------")

    val totalscore = scores.values.reduce { acc, score -> acc + score }
    println("Total Score of All Students: $totalscore")  //total scores by reduce

    //fold formatting

    val formattedScores = scores.entries.fold("") { acc, entry ->
        if (acc.isEmpty()) "${entry.key}: ${entry.value}"
        else "$acc | ${entry.key}: ${entry.value}"
    }
    println("Formatted Scores: $formattedScores")


    println("------------")
    genReport(scores)


}
fun genReport(scores: Map<String, Int>) {
    if (scores.isEmpty()) {
        println("No student data available.")
        return
    }
    println("Students Grades Report")
    scores
        .filter { it.value >= 60 }                      // filters students that succeed
        .map { "${it.key}: ${it.value}" }               // formating
        .forEach { println(it) }                        // Print all
}


