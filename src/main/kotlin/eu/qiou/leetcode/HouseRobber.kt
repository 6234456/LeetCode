package eu.qiou.leetcode
// https://leetcode.com/problems/house-robber/
class HouseRobber {
    fun rob(nums: IntArray): Int {
        var r1 = 0
        var r2 = 0

        nums.forEach {  i ->
            val tmp = r1
            r1 = kotlin.math.max(
                r1, r2 + i
            )
            r2 = tmp
        }

        return r1
    }
}