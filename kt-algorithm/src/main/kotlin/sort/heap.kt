package sort

// O(n log n)
fun main() {
//    val arr = arrayOf(1, 5, 2, 6, 3, 7, 4)
    val arr = arrayOf(1, 16, 9, 5, 11, 3, 2, 12, 6, 3, 14, 8, 7, 4, 10, 3, 17, 15, 13)

    val heap = Heap(IntArray(arr.size, { Int.MAX_VALUE }))

    for (i in 0 until arr.size) {
        heap.add(arr[i], i)
    }

    for (i in 0 until arr.size) {
        arr[i] = heap.pop()
    }

    println(arr.contentToString())
}

class Heap(var arr: IntArray) {

    fun add(value: Int, idx: Int) {
        arr[idx] = value
        if (idx == 0) {
            return
        }

        val parentIdx = (idx - 1) / 2
        if (arr[parentIdx] > arr[idx]) {
            val temp = arr[idx]
            arr[idx] = arr[parentIdx]
            add(temp, parentIdx)
        }
    }

    fun pop(): Int {
        val temp = arr[0]

        arr[0] = arr[arr.size - 1]
        arr = arr.copyOf(arr.size - 1)
        if(arr.isNotEmpty()) heapifyDown(0)

        return temp
    }

    private fun heapifyDown(idx: Int) {
        var smallIdx = idx
        val left = 2 * idx + 1
        val right = 2 * idx + 2

        if(left < arr.size && arr[left] < arr[smallIdx])  smallIdx = left
        if(right < arr.size && arr[right] < arr[smallIdx])  smallIdx = right

        if (arr[idx] > arr[smallIdx]) {
            val temp = arr[idx]
            arr[idx] = arr[smallIdx]
            arr[smallIdx] = temp
            heapifyDown(smallIdx)
        }
    }
}
