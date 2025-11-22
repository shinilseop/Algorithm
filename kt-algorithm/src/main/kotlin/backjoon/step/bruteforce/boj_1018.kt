package backjoon.step.bruteforce

var N: Int = 0
var M: Int = 0
var board: Array<CharArray> = arrayOf()

fun main() {
    val br = System.`in`.bufferedReader()
    val input1 = br.readLine().split(" ")
    N = input1[0].toInt()
    M = input1[1].toInt()
    board = Array(N) { CharArray(M) }

    for (i in 0..<N) {
        board[i] = br.readLine().toCharArray()
    }

    var cnt = Int.MAX_VALUE
    for (y in 0..<N - 7) {
        for (x in 0..<M - 7) {
            val newCnt1 = countRedrawing('W', y, x)
            val newCnt2 = countRedrawing('B', y, x)
            cnt = minOf(cnt, minOf(newCnt1, newCnt2))
        }
    }

    println(cnt)
}

fun countRedrawing(stratColor: Char, startY: Int, startX: Int): Int {
    var cnt = 0
    var verticalColor = stratColor

    for (y in startY..<startY + 8) {

        var horizontalColor = verticalColor
        verticalColor = changeColor(verticalColor)

        for (x in startX..<startX + 8) {
            if (board[y][x] != horizontalColor) {
                cnt++
            }

            horizontalColor = changeColor(horizontalColor)
        }
    }

    return cnt
}

private fun changeColor(color: Char): Char = if (color == 'W') 'B' else 'W'
