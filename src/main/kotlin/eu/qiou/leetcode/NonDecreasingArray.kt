package eu.qiou.leetcode

class NonDecreasingArray {
    fun checkPossibility(nums: IntArray): Boolean {
        if(nums.size <= 2) return true

        var cnt = 0

        nums.drop(1).forEachIndexed { index, i ->
            // 4 2 3   index = 1
            // nums[index] <= i <= nums[index+2]
            if(nums[index]  > i){
                if (++cnt > 1)  return false
                // can replace either of the 2 imbalanced items
                if (!(index == 0 || index >= nums.size - 2 || nums[index] <= nums[index+2] || nums[index-1] <= i )){
                    return false
                }
            }
        }

        return true
    }
}