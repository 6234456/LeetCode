package eu.qiou.leetcode

import junit.framework.TestCase

class FindFirstAndLastPositionTest : TestCase() {

    fun testSearchRange() {
        val arr = FindFirstAndLastPosition().searchRange(intArrayOf(1,2,3,3,3,3,4,5,9), 3)
        println("${arr.first()} ${arr.last()}")
    }
}