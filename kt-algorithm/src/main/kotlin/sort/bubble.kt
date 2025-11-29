package sort

// O(n^2)
fun main() {
//    val arr = arrayOf(1, 5, 2, 6, 3, 7, 4)
    var arr = arrayOf(1, 16, 9, 5, 11, 3, 2, 12, 6, 3, 14, 8, 7, 4, 10, 3, 17, 15, 13)

    for (i in arr.size - 1 downTo 1) {
        for (j in 0 until i) {
            if (arr[j] > arr[j + 1]) {
                val temp = arr[j]
                arr[j] = arr[j + 1]
                arr[j + 1] = temp
            }
        }
    }

    println(arr.contentToString())
}
