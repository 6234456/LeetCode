package eu.qiou.leetcode

class FindMedianSortedArrays {
    fun findMedianSortedArrays(nums1: IntArray, nums2: IntArray): Double {
        var cnt1 = 0
        var cnt2 = 0
        val l1 = nums1.size
        val l2 = nums2.size
        val res = mutableListOf<Int>()

        while (cnt1 < l1 && cnt2 < l2) {
            if (nums1[cnt1] < nums2[cnt2]) {
                res.add(nums1[cnt1])
                cnt1++
            } else {
                res.add(nums2[cnt2])
                cnt2++
            }
        }

        if (cnt1 < l1) {
            res.addAll(nums1.takeLast(l1 - cnt1))
        }

        if (cnt2 < l2) {
            res.addAll(nums2.takeLast(l2 - cnt2))
        }

        if (res.size == 0)
            return 0.0

        return if (res.size.rem(2) == 1) res[(res.size - 1) / 2].toDouble()
        else (res[res.size / 2] + res[res.size / 2 - 1]) / 2.0
    }
}