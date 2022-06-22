package eu.qiou.leetcode

// https://leetcode.com/problems/two-sum-ii-input-array-is-sorted/
// #167

class TwoSum {
    fun twoSum0(numbers: IntArray, target: Int): IntArray {
        numbers.dropLast(1).forEachIndexed { index, i ->
            val ind = binarySearch(numbers, target - i, index + 1)
            if (ind > 0){
                return intArrayOf(index+1, ind+1)
            }
        }

        throw java.lang.Exception("error")
    }

    // threeSum equals 0
    fun threeSum(nums: IntArray): List<List<Int>> {
        val l = nums.size
        if (l < 3) return emptyList()

        var last = 0
        val numbers = nums.sortedArray()
        return numbers.foldIndexed(listOf<List<Int>>()){
            index, acc, i ->
            if (index > l - 3)
                return acc
            else if (index == 0 || i != last){
                var hi = l - 1
                var lo = index + 1
                val target = i * -1
                val res: MutableList<List<Int>> = mutableListOf()

                while (hi > lo){
                    val v = numbers[hi] + numbers[lo]
                    if (v == target){
                        res.add(listOf(i, numbers[lo], numbers[hi]))

                        hi--
                        lo++

                        while (hi > lo && numbers[hi] == numbers[hi+1]){
                            hi--
                        }

                        while (lo < hi && numbers[lo-1] == numbers[lo]){
                            lo++
                        }

                    } else if (v > target)
                        hi--
                    else
                        lo++
                }
                last = i
                acc + res
            }
            else
                acc
        }

    }

    fun twoSum(numbers: IntArray, target: Int): IntArray {
        var hi = numbers.size - 1
        var lo = 0

        while (hi > lo){
            val v = numbers[hi] + numbers[lo]
            if (v == target)
                return intArrayOf(lo+1, hi+1)

            if (v > target)
                hi--
            else
                lo++
        }
        throw java.lang.Exception("error")
    }


    private fun binarySearch(numbers: IntArray, target: Int, low: Int = 0, high: Int = numbers.size-1):Int {
        var start = low
        var end = high

        while (start <= end){
            val mid = start + (end - start)/2
            val m = numbers[mid]

            if (target == m)
                return mid

            if (target > m){
                start = mid + 1
            }else{
                end = mid - 1
            }
        }

        return -1
    }
}