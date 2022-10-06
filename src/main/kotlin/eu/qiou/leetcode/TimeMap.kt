package eu.qiou.leetcode

/**
 *  读取目标时间点的最新配置
 */

class TimeMap {
    val map = mutableMapOf<String, java.util.TreeSet<Pair<Int,String>>>()

    fun set(key: String, value: String, timestamp: Int) {
        map[key] = map.getOrDefault(key, java.util.TreeSet { a, b -> a.first.compareTo(b.first) }).apply{
            add(timestamp to value)
        }
    }

    fun get(key: String, timestamp: Int): String {
        return map[key]?.floor(timestamp to "")?.second ?: ""
    }

}