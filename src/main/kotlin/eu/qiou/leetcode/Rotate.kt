package eu.qiou.leetcode

class Rotate {
    fun run(strs: Array<String>): List<List<String>> {
        return strs.fold(mutableMapOf<String, MutableList<String>>()) { acc, s ->
            var flag = false
            acc.keys.forEach {
                if (isAnagram(it, s)) {
                    acc[it]!!.add(s)
                    flag = true
                }
            }

            if (!flag) acc[s] = mutableListOf(s)

            acc
        }.values.toList()
    }

    fun isAnagram(v1: String, v2: String): Boolean {
        return v1.length == v2.length && v1.all { v2.contains(it) }
    }
}