package eu.qiou.leetcode

import junit.framework.TestCase

class LinkedListProblemsTest : TestCase() {

    fun testIsPalindrome() {
        LinkedListProblems().isPalindrome(LinkedListProblems().toNode(listOf(1,2,2,1)))
    }
}