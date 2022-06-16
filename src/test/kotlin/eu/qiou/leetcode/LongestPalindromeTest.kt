package eu.qiou.leetcode

import junit.framework.TestCase

class LongestPalindromeTest : TestCase() {

    fun testLongestPalindrome() {
        println(LongestPalindrome().longestPalindrome("babad"))
        println(LongestPalindrome().longestPalindrome("cbbd"))
        println(LongestPalindrome().longestPalindrome("aaaa"))
    }
}