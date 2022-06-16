package eu.qiou.leetcode

// #11  https://leetcode.com/problems/container-with-most-water/
class ContainerWithMostWater {
    fun maxArea(height: IntArray): Int {
        return maxArea(height,0, height.size - 1)
    }

    fun maxArea(height: IntArray, lo: Int = 0, hi: Int = height.size - 1): Int {
        fun area(n1: Int, n2: Int) : Int {
            return kotlin.math.min(height[n1], height[n2]) * (n2 - n1)
        }

        var left = lo
        var right = hi
        var maxArea = area(lo, hi)

        // change the shorter one until it exceeds the longer one
        while (right > left){
            if (height[left] < height[right]){
                left++
                if (height[left] > height[left-1]){
                    maxArea = kotlin.math.max(maxArea, area(left, right))
                }
            }

            else{
                right--
                if (height[right + 1] < height[right])
                    maxArea = kotlin.math.max(maxArea, area(left, right))
            }



        }

        return maxArea
    }
}