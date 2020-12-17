package eu.qiou.leetcode

import org.junit.Test

class DuplicateIITest {

    @Test
    fun containsNearbyDuplicate() {
        println(DuplicateII().containsNearbyDuplicate(intArrayOf(1, 2, 3, 1), 3))
        println(DuplicateII().containsNearbyDuplicate(intArrayOf(1, 0, 1, 1), 1))
        println(DuplicateII().containsNearbyDuplicate(intArrayOf(1, 2, 3, 1, 2, 3), 2))
        println(DuplicateII().containsNearbyDuplicate(intArrayOf(99, 99), 2))
        println(DuplicateII().containsNearbyDuplicate(intArrayOf(1, 2), 2))
    }
}