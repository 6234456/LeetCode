package eu.qiou.leetcode

import org.junit.Test

class DecWeek3_2020Test {

    @Test
    fun sortedSquares() {
        val list = listOf<Int>(-2, -1, 2, 3).toIntArray()
        val list1 = listOf<Int>(0, 3, 10).toIntArray()

        println(DecWeek3_2020.sortedSquares(list).toList())
        //println(DecWeek3_2020.position(list,lo = 0))
    }
}