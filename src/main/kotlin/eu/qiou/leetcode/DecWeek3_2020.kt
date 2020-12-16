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

    fun position(nums: IntArray, hi: Int = nums.size - 1, lo: Int = 0): Int {
        if (hi == lo || hi - lo == 1) return hi

        val m = (hi + lo) / 2
        val v = nums[m]
        val v1 = nums[m - 1]


        if (v == 0) return m

        if (v > 0 && v1 <= 0) return m

        if (v > 0 && v1 > 0)
            return position(nums, m, lo)
        else
            return position(nums, hi, m)
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