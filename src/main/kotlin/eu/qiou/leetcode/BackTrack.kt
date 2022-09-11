package eu.qiou.leetcode

class BackTrack {

    // https://leetcode.com/problems/split-array-into-consecutive-subsequences/
    fun isPossible(nums: IntArray): Boolean {
        val ends = mutableMapOf<Int, Int>()
        val cnts = nums.fold(mutableMapOf<Int, Int>()){
            acc, i ->
                acc[i] = acc.getOrDefault(i, 0) + 1
                acc
        }

        nums.forEach {
            if (cnts.getOrDefault(it, 0) > 0){
                cnts[it] = cnts[it]!! - 1

                if (ends.getOrDefault(it - 1, 0) > 0){
                    ends[it - 1] = ends[it - 1]!! - 1
                    ends[it] = ends.getOrDefault(it, 0) + 1
                }else if (cnts.getOrDefault(it+1, 0) > 0 && cnts.getOrDefault(it+2, 0) > 0){
                    cnts[it + 1] = cnts[it + 1]!! - 1
                    cnts[it + 2] = cnts[it + 2]!! - 1
                    ends[it + 2] = ends.getOrDefault(it + 2, 0) + 1
                }else{
                    return false
                }

            }
        }

        return true

    }


    fun minRefuelStops(target: Int, startFuel: Int, stations: Array<IntArray>): Int {
        val dp = LongArray(stations.size + 1)
        dp[0] = startFuel.toLong() // the max distance reached with 0 tank

        (0 until stations.size).forEach {
            i ->
            (i downTo 0).forEach {
                j ->
                    if (stations[i][0] > dp[j]) //
                        return@forEach

                    dp[j+1] = Math.max(dp[j+1], dp[j] + stations[i][1])
            }
        }

        return dp.indexOfFirst { it >= target }
    }

    // 最上层印章覆盖下层印章
    fun movesToStamp(stamp: String, target: String): IntArray {
        var cnt = 0
        val t = target.toCharArray()
        val s = stamp.toCharArray().toList()
        var i = 0
        val res:MutableList<Int> = mutableListOf()
        var tmp = 0
        val maxTurns = target.length * 10


        while (true){
            if (cnt > maxTurns)
                break

            while(i <= t.size - stamp.length && cnt < maxTurns + 1){
                val t0 = t.slice(i until i + stamp.length)

                if (!t0.all { it == '0' } && t0.zip(s).all { it.first == '0' || it.first == it.second }){
                    (i until i + stamp.length).forEach { j -> t[j] = '0' }
                    res.add(i)

                    if(t.all { it == '0' })
                        return res.reversed().toIntArray()

                    cnt++
                }
                i++
            }

            if (res.size == tmp)
                return intArrayOf()

            tmp = res.size

            i = 0
        }

        return intArrayOf()
    }
}