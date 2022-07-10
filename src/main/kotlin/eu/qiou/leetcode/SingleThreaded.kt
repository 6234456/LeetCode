package eu.qiou.leetcode
// https://leetcode.com/problems/single-threaded-cpu/
class SingleThreaded {
    fun getOrder(tasks: Array<IntArray>): IntArray {
        val queue = java.util.PriorityQueue<Pair<IntArray, Int>>{o1, o2 ->
            o1.first[1].compareTo(o2.first[1]).let {
                if (it == 0)
                    o1.second.compareTo(o2.second)
                else
                    it
            }
        }
        var t = tasks.mapIndexed { index, ints -> ints to index  }.groupBy { it.first[0] }.toSortedMap()
        var fromKey = 1
        val ans = mutableListOf<Int>()

        while (t.isNotEmpty()){
            if (queue.isEmpty())
                fromKey = kotlin.math.max(t.firstKey(), fromKey)

            t.headMap(fromKey + 1).forEach { _, u ->
                queue.addAll(u)
            }
            t = t.tailMap(fromKey + 1)

            fromKey += queue.poll().let {
                ans.add(it.second)
                it.first[1]
            }

            if (t.isEmpty() && queue.isNotEmpty())
                while (queue.isNotEmpty())
                    ans.add(queue.poll().second)
        }

        return ans.toIntArray()
    }
}