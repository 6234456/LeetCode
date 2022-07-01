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

    fun combinationSum(candidates: IntArray, target: Int): List<List<Int>> {
        candidates.sort()
        return combinationSumSorted(candidates, target, 0)
    }

    fun combinationSumSorted(candidates: IntArray, target: Int, left0: Int): List<List<Int>> {
        if (left0 >= candidates.size || candidates[left0] > target)
            return emptyList()

        val ans = mutableListOf<List<Int>>()
        var l = left0

        while (l < candidates.size){
            val left = candidates[l]
            var cnt = 1
            var tmp = target - left

            while (tmp >= 0){
                if(tmp == 0){
                    ans.addAll(listOf(List(cnt){left}))
                    break
                }
                // only if a little towards your target, you will make it
                val res = combinationSumSorted(candidates, tmp, l+1)

                if (res.isNotEmpty()){
                    ans.addAll(res.map { List(cnt){left} + it })
                }

                tmp -= left
                cnt++
            }

            l++
        }

        return ans
    }

    fun fourSum(nums: IntArray, target: Int): List<List<Int>> {
        val len = nums.size
        if (len < 4)
            return listOf()

        var l = 0
        var r = nums.size - 1
        val arr = nums.sortedArray()
        val arr0 = arr.map { it.toLong() }
        val ans : MutableList<List<Int>> = mutableListOf()
        val target0 = target.toLong()

        while (0 < r){
            while (l < r){
                val tmp:Long = arr0[l] + arr0[r]
                var l0 = l + 1
                var r0 = r - 1

                while (l0 < r0){
                    val tmp0 = tmp + arr0[l0] + arr0[r0]
                    if (tmp0 == target0){
                        ans.add(listOf(arr[l], arr[l0], arr[r0], arr[r]))
                        l0 = nextIndex(arr, l0, true)
                        r0 = nextIndex(arr, r0, false)
                    }else if (tmp0 > target){
                        r0 = nextIndex(arr, r0, false)
                    }else{
                        l0 = nextIndex(arr, l0, true)
                    }
                }

                l = nextIndex(arr, l, true)
            }
            l = 0
            r = nextIndex(arr, r, false)
        }

        return ans
    }

    fun nextIndex(arr: IntArray, index: Int, toRight: Boolean): Int{
        var ans = index
        val target = arr[index]

        if (toRight)
       while (ans < arr.size) {
           if (target < arr[ans])
               return ans

           ans++
       }
        else
            while (ans > -1) {
                if (target > arr[ans])
                    return ans

                ans--
            }

        return ans
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

    // https://leetcode.com/problems/combination-sum-ii/

    fun combinationSum2(candidates: IntArray, target: Int): List<List<Int>> {
        candidates.sort()
        return combinationSumSorted0(candidates, target, 0)
    }

    fun combinationSumSorted0(candidates: IntArray, target: Int, left0: Int): List<List<Int>> {
        if (left0 >= candidates.size || candidates[left0] > target)
            return emptyList()

        val ans = mutableListOf<List<Int>>()
        var l = left0

        while (l < candidates.size){
            val left = candidates[l]
            val tmp = target - left

            val nextIndex = nextIndex(candidates, l, true)

            if(tmp == 0){
                ans.addAll(listOf(listOf(left)))
            }else{
                val res = combinationSumSorted0(candidates, tmp, l+1)

                if (res.isNotEmpty()){
                    ans.addAll(res.map { listOf(left) + it })
                }
            }
            // only if a little towards your target, you will make it
            l = nextIndex
        }

        return ans
    }
}