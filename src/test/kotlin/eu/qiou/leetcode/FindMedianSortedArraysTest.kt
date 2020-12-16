package eu.qiou.leetcode

import org.junit.Test

class FindMedianSortedArraysTest {

    @Test
    fun binarySearch0() {
        val l = FindMedianSortedArrays()


        //   println( l.findMedianSortedArrays(listOf<Int>(1,2,3,4).toIntArray(), listOf<Int>(3,4).toIntArray()))
        println(l.findMedianSortedArrays(listOf<Int>(1, 3).toIntArray(), listOf<Int>(2).toIntArray()))
        println(l.findMedianSortedArrays(listOf<Int>(1).toIntArray(), listOf<Int>(1).toIntArray()))
    }
}