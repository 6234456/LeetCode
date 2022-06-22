package eu.qiou.leetcode
// https://leetcode.com/problems/kth-largest-element-in-an-array/
// #215
class KthLargestElement {
    fun findKthLargest(nums: IntArray, k: Int): Int {
        val queue = java.util.PriorityQueue<Int>()
        var cnt = 0
        nums.forEach {
            if (cnt < k){
                queue.add(it)
                cnt++
            }else{
                if (it > queue.peek()){
                    queue.poll()
                    queue.add(it)
                }
            }
        }

        return queue.poll()
    }
}