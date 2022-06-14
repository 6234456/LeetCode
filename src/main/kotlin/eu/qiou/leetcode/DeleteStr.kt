package eu.qiou.leetcode


// https://leetcode.com/problems/delete-operation-for-two-strings/
class DeleteStr {
    fun minDistance(word1: String, word2: String): Int {
        val c1 = word1.toCharArray()
        val c2 = word2.toCharArray()

        val dp = Array(c1.size + 1) {IntArray(c2.size + 1){0} }

        (1..c1.size).forEach {
            i ->
            (1.. c2.size).forEach {
                j ->
                if (c1[i - 1] == c2[j - 1])
                    dp[i][j] = dp[i-1][j-1] + 1
                else
                    dp[i][j] = kotlin.math.max(dp[i-1][j],dp[i][j-1])

            }
        }

        return c1.size + c2.size - 2 * dp[c1.size][c2.size]
    }

    // abbd abcb
}