package eu.qiou.leetcode


// https://leetcode.com/problems/jump-game-ii/
class Jump {
    fun jump(nums: IntArray): Int {
        if(nums.size == 1)
            return  0

        return depth(nums, nums.size-1)

       

    }

    // in the consecutive range, if it can reach the left most index, then it can also reach any index in between
    // backwards from the target, take the biggest step
    fun depth(nums:IntArray, index:Int): Int {
        if (nums[0] >= index)
                return 1

        (0 .. index).forEach{
            if(nums[it] + it >= index)
                return 1 + depth(nums, it)
        }

        return -1
    }


    fun canReach(s: String, minJump: Int, maxJump: Int): Boolean {
        val arr = s.toCharArray()

        //maintain an ascending array of index where reachable 0 located
        //dynamically remove heads to make sure that the lowest index can still reach the target with the max jump
        // cannot remove the higher pos which might be relevant for the 0 pos afterwards
        //if target lies within the scope of [low + min, low + max] -> reachable
        val queue: java.util.Deque<Int> = java.util.LinkedList<Int>()
        queue.push(0)

        (1 until arr.size).forEach {
            if (arr[it] == '0') {
                while (queue.size > 0 && queue.peekFirst() + maxJump < it) queue.removeFirst()

                if(queue.isNotEmpty() && queue.peekFirst() + minJump <= it){
                    if(it == arr.size - 1) return true

                    queue.addLast(it)
                }

            }

        }

        return false
    }


    fun maxResult(nums: IntArray, k: Int): Int {
        val dp = Array<Int>(nums.size){0}
        dp[0] = nums[0]

        // maintain the index of the biggest dp value   for  it-k to it-1
        val queue: java.util.Deque<Int> = java.util.LinkedList<Int>()
        queue.push(0)

        (1 until nums.size).forEach {

            // remove if slides out of the range
            if (it - queue.peekFirst() > k) queue.removeFirst()
            dp[it] = nums[it] + dp[queue.peekFirst()]

            // remove all the elements less than value at it - 1
            while (queue.size > 0 && dp[queue.peekLast()] < dp[it]) queue.removeLast()
            queue.addLast(it)

        }

        return dp.last()
    }



    fun canJump(nums: IntArray): Boolean {

        val s = nums.size

        if(s == 1)
            return true

        val a =  nums.mapIndexed{ i, e -> i + e}

        var cnt = 0
        var last = cnt

        while(cnt < s){
            val m = a.drop(last).take(cnt - last + 1).maxBy{it}!!

            if(cnt >= m) return false

            if(m >= s-1) return true

            last = cnt
            cnt = m

        }

        return true
    }
}