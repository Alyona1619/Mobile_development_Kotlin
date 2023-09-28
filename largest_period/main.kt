fun find(): Int {
    var longestPeriod = 0
    var resultD = 0

    for (d in 2..<1000) {
        val remainders = mutableMapOf<Int, Int>()
        var remainder = 1 % d
        var position = 0

        while (remainder != 0 && !remainders.containsKey(remainder)) {
            remainders[remainder] = position
            remainder = (remainder * 10) % d
            position++
        }

        if (remainder != 0) {
            val periodLength = position - remainders[remainder]!!
            if (periodLength > longestPeriod) {
                longestPeriod = periodLength
                resultD = d
            }
        }
    }

    return resultD
}

fun main() {
    val d = find()
    println("Наибольший период дроби получается при d = $d")
}
// Наибольший период дроби получается при d = 983
