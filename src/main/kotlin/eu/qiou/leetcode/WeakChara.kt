package eu.qiou.leetcode

import java.util.PriorityQueue
import kotlin.math.abs
import kotlin.math.sign

class WeakChara {
    fun numberOfWeakCharacters(properties: Array<IntArray>): Int {
        var ans = 0
        var m = 0

        properties.sortedWith(compareBy({it[0] * -1},{it[1]})).forEach {
            if (it[1] < m){
                ans += 1
            } else {
                m = it[1]
            }
        }

        return ans
    }

    fun maxProfit(k: Int, prices: IntArray): Int {

        if (prices.size <= 1 || k == 0)
            return 0

        var l = prices.drop(1).zip(prices.dropLast(1)).map { it.first - it.second }.filter { it != 0 }.let {
            var t = it.foldIndexed(mutableListOf<Int>()){
                index, acc, i ->
                    if (index != 0 && acc.last().sign == i.sign){
                        acc[acc.size - 1] = acc[acc.size - 1] + i
                    }else{
                        acc.add(i)
                    }

                acc
            }.toList()

            if (t.isNotEmpty() && t.last() <= 0) t = t.dropLast(1)
            if (t.isNotEmpty() && t.first() <= 0) t = t.drop(1)

           t

        }

        var ans = l.foldIndexed(0){index, acc, i ->  acc + i * if (index.rem(2) == 1) 0 else 1}
        var cnt = (l.size + 1) / 2

        while (cnt > k){
            cnt--
            // find the largest negative and smallest positive
            var p = Integer.MAX_VALUE
            var pi = 0
            var n = Integer.MIN_VALUE
            var ni = 1
            l.indices.forEach {
               if (it.rem(2) == 0){
                   if(p > l[it]){
                      pi = it
                      p = l[it]
                   }
               }else{
                   if(n < l[it]){
                      ni = it
                      n = l[it]
                   }
               }
            }

            if (Math.abs(p) > Math.abs(n)){
                ans += n
                l = l.take(ni - 1) + listOf( l[ni-1] + l[ni] + l[ni + 1]) + l.drop(ni + 2)
            }else{
                ans -= p
                l = when (pi) {
                    0 -> l.drop(2)
                    l.size - 1 -> l.dropLast(2)
                    else -> l.take(pi - 1) + listOf( l[pi-1] + l[pi] + l[pi + 1]) + l.drop(pi + 2)
                }
            }

        }

        return ans
    }

    fun maxPerformance(n: Int, speed: IntArray, efficiency: IntArray, k: Int): Int {
        val queue: PriorityQueue<Long> = java.util.PriorityQueue()
        var total = 0L
        var ans = 0L
        efficiency.zip(speed).sortedWith(compareBy { it.first * -1 }).forEach {
            total = (total + it.second)

            queue.add(it.second.toLong())

            if (queue.size > k){
                total -= queue.poll()
            }

            ans = kotlin.math.max(total * it.first, ans)
        }

        return ans.rem(1000_000_007L).toInt()
    }
}