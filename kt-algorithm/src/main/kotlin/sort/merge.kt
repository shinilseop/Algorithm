package sort

// O(n log n)
fun main() {
//    val arr = arrayOf(1, 5, 2, 6, 3, 7, 4)
    val arr = arrayOf(1, 16, 9, 5, 11, 3, 2, 12, 6, 3, 14, 8, 7, 4, 10, 3, 17, 15, 13)

    divideAndMerge(arr, 0, arr.size - 1)

    println("arr.contentToString() = ${arr.contentToString()}")
}

fun divideAndMerge(arr: Array<Int>, start: Int, end: Int) {
    if (end == start) return

    val mid = (start + end) / 2

    divideAndMerge(arr, start, mid)
    divideAndMerge(arr, mid + 1, end)
    merge(arr, start, mid+1, end)
}

fun merge(arr: Array<Int>, _start: Int, _start2:Int, _end: Int) {
    var firstIdx = _start
    var secondIdx = _start2
    val mergeArr = IntArray(_end - _start + 1)
    var idx = 0

    while(firstIdx < _start2 && secondIdx <= _end) {
        if (idx == mergeArr.size) break
        if (arr[firstIdx] < arr[secondIdx]) mergeArr[idx++] = arr[firstIdx++]
        else mergeArr[idx++] = arr[secondIdx++]
    }

    if (firstIdx < _start2) {
        for (i in firstIdx until _start2)
            mergeArr[idx++] = arr[i]
    } else if (secondIdx <= _end) {
        for (i in secondIdx.._end)
            mergeArr[idx++] = arr[i]
    }

    for (idx in 0 until mergeArr.size) {
        arr[_start+idx] = mergeArr[idx]
    }
}
