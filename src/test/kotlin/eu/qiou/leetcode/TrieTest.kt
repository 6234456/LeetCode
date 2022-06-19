package eu.qiou.leetcode

import junit.framework.TestCase

class TrieTest : TestCase() {

    fun testSearch() {

        println( SearchSuggestionsSystem().suggestedProducts(
            arrayOf("mobile","mouse","moneypot","monitor","mousepad"),
            "mouse"
        ))


    }
}