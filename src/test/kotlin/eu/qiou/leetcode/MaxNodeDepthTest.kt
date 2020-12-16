package eu.qiou.leetcode

import org.junit.Assert.assertEquals
import org.junit.Test

class MaxNodeDepthTest {

    @Test
    fun add() {
        val l = MaxNodeDepth.new(listOf(5, 3, 6, 2, 4, null, 8, 1, null, null, null, 7, 9))

        assertEquals(MaxNodeDepth.min(l)!!.`val`, 1)
        assertEquals(MaxNodeDepth.max(l)!!.`val`, 9)
        assertEquals(l!!.left!!.right!!.`val`, 4)
        MaxNodeDepth.increasingBST(l)?.let {
            println(it)
            println(it.right!!)
            println(it.right!!.right!!)
            println(it.right!!.right!!.right!!)
            println(it.right!!.right!!.right!!.right!!)
            println(it.right!!.right!!.right!!.right!!.right!!)
        }
    }

    @Test
    fun add1() {
        val l = MaxNodeDepth.increasingBST(MaxNodeDepth.new(listOf(3, 4, 5, 6)))
        l?.let {
            println(it)
            println(it.right!!)
            println(it.right!!.right!!)
            println(it.right!!.right!!.right!!)
            println(it.right!!.right!!.right!!.right!!)
        }
    }

}