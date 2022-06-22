// https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/
// #34

// binary search in loop-form  important

package eu.qiou.leetcode

class FindFirstAndLastPosition {
    fun search(nums: IntArray, target: Int, searchLeft: Boolean = true): Int {
        var start =  0
        var end = nums.size - 1
        var ans = -1

        while (start <= end) {
            val mid = start + (end - start) / 2 // overflow
            val m = nums[mid]

            if (searchLeft){
                if (m >= target){
                    end = mid - 1
                    if (m == target)
                        ans = mid
                }else{
                    start = mid + 1
                }
            }else {
                if (m <= target){
                    start = mid + 1
                    if (m == target)
                        ans = mid
                }else{
                    end = mid - 1
                }
            }
        }

        return ans
    }

    fun searchRange(nums: IntArray, target: Int): IntArray {
        return intArrayOf(search(nums, target, true),search(nums, target, false) )
    }
}