package eu.qiou.leetcode

import junit.framework.TestCase

class ValidSudokuTest : TestCase() {

    fun testIsValidSudoku() {
        val src = arrayOf(
            charArrayOf('1','2','3','4','5','6','7','8','9'),
            charArrayOf('1','2','3','4','5','6','7','8','9'),
            charArrayOf('1','2','3','4','5','6','7','8','9'),
            charArrayOf('1','2','3','4','5','6','7','8','9'),
            charArrayOf('1','2','3','4','5','6','7','8','9'),
            charArrayOf('1','2','3','4','5','6','7','8','9'),
            charArrayOf('1','2','3','4','5','6','7','8','9'),
            charArrayOf('1','2','3','4','5','6','7','8','9'),
            charArrayOf('1','2','3','4','5','6','7','8','9')
        )

        ValidSudoku().slice(src).forEach {
            println(it)
        }
    }
}