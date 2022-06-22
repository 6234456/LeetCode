package eu.qiou.leetcode


class ClimbStairs {
    fun climbStairs(n: Int): Int {
        val dp = IntArray(n+1){0}
        dp[0] = 1
        dp[1] = 1
        (2..n).forEach {
            dp[it] = dp[it-1] + dp[it-2]
        }
        return dp[n]
    }
}