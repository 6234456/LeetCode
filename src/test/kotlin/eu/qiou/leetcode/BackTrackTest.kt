package eu.qiou.leetcode

import junit.framework.TestCase

class BackTrackTest : TestCase() {

    fun testIsPossible() {
        println( BackTrack().isPossible(intArrayOf(1,2,3,3,4,5,5,5,5,6,6,7,8,9,9,9,9,10)))
    }

    fun testD() {

        println( BackTrack().minRefuelStops(1000, 299,
        arrayOf(
            intArrayOf(13,21),
            intArrayOf(26,115),
            intArrayOf(100,47),
            intArrayOf(225,99),
            intArrayOf(299,141),
            intArrayOf(444,198),
            intArrayOf(608,190),
            intArrayOf(636,157),
            intArrayOf(647,255),
            intArrayOf(841,123)
        )
            ))
    }

    fun testC(){
        println( BackTrack().movesToStamp("k",
            "kkkkkkkkkkkkkkk").toList())
    }
}