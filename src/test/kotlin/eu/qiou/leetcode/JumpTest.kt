package eu.qiou.leetcode

import junit.framework.TestCase

class JumpTest : TestCase() {

    fun testJump() {
        Jump().jump(intArrayOf(
            2,3,1,1,4))
    }

    fun testRes(){
        // [0,-1,-2,-3,1]
        //2
        //Jump().maxResult(intArrayOf(0,-1,-2,-3,1), 2)
        Jump().canJump(intArrayOf(2,0,0))
    }
}