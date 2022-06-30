package eu.qiou.leetcode

class MinimumMovesToEqualArray {
    // draw it!!
    // sum of the distance any point in between to the boundary equals the distance of the boundary
    // choose the median of the most interior range to avoid the distance to that point

    fun minMoves2(nums: IntArray): Int {
        val l = nums.size
        nums.sort()
        val t = if (l.rem(2) == 1){
             nums[(l-1)/2]
        }else
            nums[l/2]

        return nums.fold(0){
                acc, i ->
            acc + kotlin.math.abs(i-t)
        }
    }
}