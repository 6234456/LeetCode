package eu.qiou.leetcode

class PaintHouse {

    // https://leetcode.com/problems/paint-house-iii/
    fun minCost(houses: IntArray, cost: Array<IntArray>, m: Int, n: Int, target: Int): Int {
        val t0 = (1e9+7).toInt()
        // with group X till house m with color n
        val dp = Array<Array<IntArray>>(target+1){Array<IntArray>(m+1){ IntArray(n+1){ t0 } }}

        (0..n).forEach {
            dp[0][0][it] = 0
        }


        (1..target).forEach {
            k ->
            (k .. m).forEach { i ->
                // if already painted  the color can not be altered
                // the boundary of the loop should be confined to a small range
                // i -> the current house index
                // j -> the previous house index  if is dummy unpainted
                val hi = houses[i - 1]
                val hj = if (i >= 2) houses[i - 2] else 0

                val (starti, endi) = if (hi == 0) (1 to n) else (hi to hi)
                val (startj, endj) = if (hj == 0) (1 to n) else (hj to hj)

                (starti..endi).forEach {
                    // cost 0 with the right color
                    val v = if (it != hi) cost[i - 1][it - 1] else 0
                    (startj..endj).forEach { colorLast ->
                        //loop through the possible color to get the minimum
                        dp[k][i][it] = kotlin.math.min(
                            dp[k][i][it],
                            dp[k - if (it != colorLast) 1 else 0][i - 1][colorLast] + v
                        )
                    }
                }
            }
        }

        val ans =  dp[target][m].min()!!
        return if (ans >= t0) -1 else ans
    }
}