package eu.qiou.leetcode

class OutOfBPath {
    fun findPaths(m: Int, n: Int, maxMove: Int, startRow: Int, startColumn: Int): Long {
        if(maxMove == 0)
            return 0

        val cons = 1_000_000_007L

        val dp = Array<Array<LongArray>>(m+2){Array<LongArray>(n+2){LongArray(maxMove){0L}}}

        (1 .. n).forEach{
                i->
            dp[1][i][0] += 1L
            dp[m][i][0] += 1L
        }

        (1 .. m).forEach{
                i->
            dp[i][1][0] += 1L
            dp[i][n][0] += 1L
        }

        (1 until maxMove).forEach{
                move ->
            (1 .. n).forEach{
                    n0 ->
                (1 .. m).forEach{
                        m0 ->
                    dp[m0][n0][move] = dp[m0-1][n0][move-1] + dp[m0][n0-1][move-1]+ dp[m0+1][n0][move-1] + dp[m0][n0+1][move-1]
                }
            }
        }


        return dp[startRow+1][startColumn+1].fold(0L){
                acc, e ->
            acc + e
        }//.rem(cons).toInt()
    }
}