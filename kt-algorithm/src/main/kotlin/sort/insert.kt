package sort

// O(n^2)
fun main() {
//    val arr = arrayOf(1, 5, 2, 6, 3, 7, 4)
    val arr = arrayOf(1, 16, 9, 5, 11, 3, 2, 12, 6, 3, 14, 8, 7, 4, 10, 3, 17, 15, 13)

    // ascending sort
    for (i in 1 until arr.size) {
        var moveIdx = i

        for (j in i - 1 downTo 0) {
            if (arr[j] < arr[moveIdx]) break

            swap(arr, j, moveIdx)
            moveIdx = j
        }
    }

    println(arr.contentToString())
}
