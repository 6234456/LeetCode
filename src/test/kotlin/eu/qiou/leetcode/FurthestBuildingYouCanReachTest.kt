package eu.qiou.leetcode

import junit.framework.TestCase
import java.util.PriorityQueue

class FurthestBuildingYouCanReachTest : TestCase() {

    fun testFurthestBuilding() {
        val queue = PriorityQueue<Int>(5)
        println(queue.apply {
            (1..10).forEach {
                this.add(it)
            }

            poll()
            this.add(5)
        })


    }
}