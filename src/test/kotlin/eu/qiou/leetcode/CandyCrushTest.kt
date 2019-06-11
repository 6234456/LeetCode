package eu.qiou.leetcode

import org.junit.Assert.assertArrayEquals
import org.junit.Test

class CandyCrushTest {

    @Test
    fun run() {
        val candyCrush = CandyCrush()

        listOf(
            listOf(1, 1, 1) to listOf(),
            listOf(1, 2, 3) to listOf(1, 2, 3),
            listOf<Int>() to listOf(),
            listOf<Int>(1, 1, 1, 2, 2, 2) to listOf(),
            listOf(1, 2, 2, 2, 1, 1, 1) to listOf(),
            listOf(1, 3, 3, 3, 2, 2, 2, 3, 1) to listOf(1, 1),
            listOf(1, 3, 3, 3, 2, 2, 1, 1, 4, 4, 4, 1, 1, 2, 2, 2, 2, 3, 1) to listOf(1, 1)
        ).forEach {
            assertArrayEquals(it.second.toIntArray(), candyCrush.run(it.first).toIntArray())
        }
    }
}