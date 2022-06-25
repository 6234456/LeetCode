package eu.qiou.leetcode

class ConstructTargetArrayWithMultipleSums {
    fun isPossible(target: IntArray): Boolean {
        val queue = java.util.PriorityQueue<Long> {o1, o2 -> o2.compareTo(o1) }
        var total = 0L

        target.forEach {
            total += it
            queue.add(it.toLong())
        }

        while (queue.peek() > 1){
           val biggest = queue.poll()
            val diff = total - biggest

            // incremental by 1 always true
            if (diff == 1L)
                return true

            if (diff == 0L || biggest < diff)
                return false

            // the biggest replaced by the sum of last step each time
            // important8
            val item = biggest.rem(diff)

            if (item == 0L)
                return false

            queue.add(item)
            total -= (biggest - item)
        }

        return queue.all { it == 1L }
    }
}