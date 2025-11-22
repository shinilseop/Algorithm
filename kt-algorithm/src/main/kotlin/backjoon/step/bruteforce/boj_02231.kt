package backjoon.step.bruteforce

fun main() {
    val N = System.`in`.bufferedReader().readLine().toInt()

    var isAnswered = false
    for (i in 1..N) {
        val str = i.toString()
        var sum = i

        for (ch in str.toCharArray()) {
            val num = ch.digitToInt()
            sum += num
        }

        if (sum == N) {
            println(i)
            isAnswered = true
            break
        }
    }

    if (!isAnswered) {
        println(0)
    }
}
