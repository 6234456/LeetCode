package eu.qiou.leetcode

import kotlin.math.max

// 1048 https://leetcode.com/problems/longest-string-chain/
class LongestStringChain {
    fun longestStrChain(words: Array<String>): Int {
        if (words.size == 1)
            return 1
        val dp = mutableMapOf<String, Int>()
      //  val dp0 = mutableMapOf<String, MutableList<List<String>>>()

        val w =  words.groupBy { it.length }
        val k = w.keys.sorted()

        words.forEach {  s ->
          //  dp0[s] = mutableListOf(listOf(s))
            dp[s] = 1
        }

        k.drop(1).forEach {
           if (w.containsKey(it-1)) {
               w[it-1]!!.forEach {
                   i  ->
                   w[it]!!.forEach {
                       j ->
                       if (isPredecessor(i, j)){
                        //   dp0[j]!!.addAll(dp0[i]!!.map { it + listOf(j) })
                           dp[j] = kotlin.math.max(dp[j]!!, dp[i]!!+1)
                       }
                   }
               }
           }
        }

       // return dp0.values.map { it.maxBy { it.size }!!.size }.max()!!
        return dp.values.max()!!

    }

    fun isPredecessor(w1:String, w2:String):Boolean {
        if (w2.length - w1.length != 1 )
            return false

        val dp = Array(w1.length + 1){IntArray(w2.length + 1){0} }

        (1..w1.length).forEach {
            i ->
            (1 .. w2.length).forEach {
                j ->
                dp[i][j] = if (w1[i-1] == w2[j-1])
                     dp[i-1][j-1] + 1
                else
                    kotlin.math.max(dp[i-1][j], dp[i][j-1])
            }
        }

        return dp[w1.length][w2.length] == w1.length
    }
}