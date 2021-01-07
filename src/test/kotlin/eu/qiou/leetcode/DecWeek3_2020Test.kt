package eu.qiou.leetcode

import org.junit.Test

class DecWeek3_2020Test {

    @Test
    fun sortedSquares() {
        val list = listOf<Int>(-2, -1, 2, 3).toIntArray()
        val list1 = listOf<Int>(0, 3, 10).toIntArray()

        println(DecWeek3_2020.sortedSquares(list).toList())
        //println(DecWeek3_2020.position(list,lo = 0))


        println(
            DecWeek3_2020.fourSumCount(
                intArrayOf(-1, 0, 1),
                intArrayOf(-1, 0, 1),
                intArrayOf(0, 0, 1),
                intArrayOf(-1, 1, 1)
            )
        )
    }

    @Test
    fun increaseTripple() {
        assert(DecWeek3_2020.increasingTriplet0(intArrayOf(2, 1, 0, 2, 0, 2, 0, 2, 0, 2, 0, 1)))
        // assert(!DecWeek3_2020.increasingTriplet(intArrayOf(2,1,0,-1)))
    }
}