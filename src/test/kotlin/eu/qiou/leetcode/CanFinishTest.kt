package eu.qiou.leetcode

import org.junit.Test

class CanFinishTest {

    @Test
    fun canFinish() {
        println(CanFinish().canFinish2(2, arrayOf<IntArray>(intArrayOf(1, 0), intArrayOf(0, 1))))
        println(CanFinish().canFinish2(2, arrayOf<IntArray>(intArrayOf(1, 0))))
    }
}