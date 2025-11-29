package sort

import java.util.Random


fun main() {
    val arr = makeSequentialRandomArr(99)

    println("start  = ${arr.contentToString()}")
    val arr2 = RadixSort.sortMax99(arr)
    println("finish = "+arr2.contentToString())
}

class RadixSort {
    companion object {
        val listBucket = Array(10) { mutableListOf<Int>() }

        fun sortMax99(arr: Array<Int>): Array<Int> {
            sortingToListByOperator(arr, '%')
            val arr2 = makeNewArrFromList(arr)
            clearList()
            sortingToListByOperator(arr2, '/')
            val arr3 = makeNewArrFromList(arr)
            return arr3
        }

        private fun sortingToListByOperator(arr2: Array<Int>, operator:Char) {
            for (i in 0 until arr2.size) {
                val num = arr2[i]
                val target = if (operator == '/') num / 10 else num % 10
                addToList(target, num)
            }
        }

        private fun makeNewArrFromList(arr: Array<Int>): Array<Int> {
            val arr2 = Array(arr.size, { 0 })
            var idx = 0
            for (list in listBucket) {
                idx = addAll(arr2, list, idx)
            }
            return arr2
        }

        private fun clearList() {
            listBucket.forEach { l -> l.clear() }
        }

        private fun addToList(postfix: Int, num: Int) {
            listBucket[postfix].add(num)
        }

        fun addAll(to:Array<Int>, from:List<Int>, startIdx:Int):Int {
            for (i in 0 until from.size) {
                to[startIdx + i] = from[i]
            }

            return startIdx + from.size
        }
    }
}

fun makeSequentialRandomArr(maxValue: Int): Array<Int> {
    val set = mutableSetOf<Int>()
    val random = Random()
    val arr = Array(maxValue, { 0 })
    for (i in 0 until maxValue) {
        var v: Int
        while (true) {
            v = random.nextInt(maxValue)+1
            if (!set.contains(v)) break
        }
        arr[i] = v
        set.add(v)
    }
    return arr
}
