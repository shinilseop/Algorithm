package sort

// O(n^2)
fun main() {
    val arr = arrayOf(1, 5, 2, 6, 3, 7, 4)

    // ascending sort
    for (i in 0..<arr.size) {
        var minIdx = i

        for (j in i+1..<arr.size) {
            if (arr[minIdx] > arr[j]) {
                minIdx = j
            }
        }

        swap(arr, i, minIdx)
    }

    println(arr.contentToString())
}

fun swap (arr: Array<Int>, i: Int, j: Int) {
    val temp = arr[i]
    arr[i] = arr[j]
    arr[j] = temp
}
