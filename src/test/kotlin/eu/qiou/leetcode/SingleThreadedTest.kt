package eu.qiou.leetcode

import junit.framework.TestCase

class SingleThreadedTest : TestCase() {

    fun testGetOrder() {
        SingleThreaded().getOrder(arrayOf(
            intArrayOf(1,2),
            intArrayOf(2,4),
            intArrayOf(3,2),
            intArrayOf(4,1)
        ))
    }
}