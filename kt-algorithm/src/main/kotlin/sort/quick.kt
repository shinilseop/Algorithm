package sort

fun main() {
    var arr = arrayOf(1, 16, 9, 5, 11, 3, 2, 12, 6, 3, 14, 8, 7, 4, 10, 3, 17, 15, 13)
//    var arr = arrayOf(1, 3, 3, 5, 4, 3, 2, 3)

    QuickSort.quickSort(arr, 0, arr.size - 1)

    println("arr.contentToString() = ${arr.contentToString()}")
}

class QuickSort {
    companion object {
        fun quickSort(arr: Array<Int>, startIdx: Int, endIdx: Int) {
            if (startIdx >= endIdx) return

            val pivot = endIdx

            var left = startIdx
            var right = endIdx-1
            while (left <= right) {
                if (arr[left] >= arr[pivot] && arr[right] <= arr[pivot]) {
                    swap(arr, left, right)
                    left++
                    right--
                } else if (arr[left] < arr[pivot]) {
                    left++
                } else {
                    right--
                }
            }

            swap(arr, pivot, left)
            quickSort(arr, startIdx, left - 1)
            quickSort(arr, left + 1, endIdx)
        }

        fun swap(arr: Array<Int>, i: Int, j: Int) = arr.apply {
            val temp = arr[i]
            arr[i] = arr[j]
            arr[j] = temp
        }
    }
}
