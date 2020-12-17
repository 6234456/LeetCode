package eu.qiou.leetcode

import java.util.*

class CanFinish {
    // https://leetcode.com/problems/course-schedule/
    fun canFinish(numCourses: Int, prerequisites: Array<IntArray>): Boolean {
        prerequisites.fold(mutableMapOf<Int, MutableSet<Int>>()) { acc, ints ->
            acc.apply {
                this[ints[0]] = getOrDefault(ints[0], mutableSetOf()).apply {
                    add(ints[1])
                }
            }
        }.let {
            if (it.any { x -> x.value.contains(x.key) })
                return false

            val cache: MutableSet<Int> = mutableSetOf()
            fun validate(k: Int, chain: Set<Int> = setOf()): Boolean {
                if (chain.contains(k)) return false
                if (cache.contains(k)) return true
                if (!it.containsKey(k)) return true

                it[k]!!.filter { x -> it.contains(x) && !cache.contains(x) }.let { y ->
                    if (y.isEmpty()) {
                        cache.add(k)
                        return true
                    }

                    return y.fold(setOf<Int>()) { acc, i ->
                        acc + it.getOrDefault(i, mutableSetOf())
                    }.all { j -> validate(j, chain + setOf(k)) }.apply {
                        if (this)
                            cache.add(k)
                    }
                }
            }

            for (i in it.keys) {
                if (!validate(i)) return false
            }
            return true
        }
    }

    fun canFinish2(numCourses: Int, prerequisites: Array<IntArray>): Boolean {
        val prereq = MutableList(numCourses) { mutableSetOf<Int>() }
        val degree = IntArray(numCourses) { 0 }

        prerequisites.forEach { ints ->
            prereq[ints[0]].add(ints[1])
            degree[ints[1]]++
        }

        // queue of root nodes
        val queue = degree.foldIndexed(LinkedList<Int>()) { index, acc, i ->
            acc.apply { if (i == 0) push(index) }
        }

        for (i in 0 until numCourses) {
            if (queue.isEmpty())
                return false

            // tracing root node to the end of the chain
            val targ = queue.pop()

            for (j in prereq[targ]) {
                degree[j]--

                if (degree[j] == 0) {
                    queue.push(j)
                }
            }
        }

        return true
    }
}