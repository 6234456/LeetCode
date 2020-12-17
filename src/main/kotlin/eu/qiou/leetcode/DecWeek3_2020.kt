package eu.qiou.leetcode

object DecWeek3_2020 {
    fun sortedSquares(nums: IntArray): IntArray {
        return if (nums.first() <= 0 && nums.last() >= 0) {
            val t = position(nums)
            merge(nums.sliceArray(0..t - 1), nums.sliceArray(t..nums.lastIndex))
        } else if (nums.last() <= 0) {
            nums.map { it * it }.reversed().toIntArray()
        } else
            nums.map { it * it }.toIntArray()
    }


    /**
     *
     *
     * Input:
    A = [ 1, 2]
    B = [-2,-1]
    C = [-1, 2]
    D = [ 0, 2]

    Output:
    2

    Explanation:
    The two tuples are:
    1. (0, 0, 0, 1) -> A[0] + B[0] + C[0] + D[1] = 1 + (-2) + (-1) + 2 = 0
    2. (1, 1, 0, 0) -> A[1] + B[1] + C[0] + D[0] = 2 + (-1) + (-1) + 0 = 0
     *
     *
     */


    fun fourSumCount(A: IntArray, B: IntArray, C: IntArray, D: IntArray): Int {
        var res = 0
        val m = mutableMapOf<Int, Int>()

        for (a in A) {
            for (b in B) {
                val v = a + b
                m[v] = m.getOrDefault(v, 0) + 1
            }
        }

        for (c in C) {
            for (d in D) {
                val v = (c + d) * -1
                res += m.getOrDefault(v, 0)
            }
        }

        return res
    }


    fun position(nums: IntArray, hi: Int = nums.size - 1, lo: Int = 0, target: Int = 0): Int {
        if (hi == lo || hi - lo == 1) return hi

        val m = (hi + lo) / 2
        val v = nums[m]
        val v1 = nums[m - 1]


        if (v == target) return m

        if (v > target && v1 <= target) return m

        if (v > target && v1 > target)
            return position(nums, m, lo, target)
        else
            return position(nums, hi, m, target)
    }

    fun merge(nums1: IntArray, nums2: IntArray): IntArray {
        // nums1 <0 nums2 > 0
        var c1 = nums1.lastIndex
        var c2 = 0
        val res = IntArray(nums1.size + nums2.size)
        var c = 0
        while (c1 >= 0 && c2 < nums2.size) {
            var v1 = nums1[c1]
            v1 *= v1
            var v2 = nums2[c2]
            v2 *= v2

            res[c++] = if (v1 > v2) {
                c2++
                v2
            } else {
                c1--
                v1
            }
        }

        while (c1 >= 0) {
            var v1 = nums1[c1--]
            v1 *= v1
            res[c++] = v1
        }

        while (c2 < nums2.size) {
            var v2 = nums2[c2++]
            v2 *= v2
            res[c++] = v2
        }

        return res
    }
}