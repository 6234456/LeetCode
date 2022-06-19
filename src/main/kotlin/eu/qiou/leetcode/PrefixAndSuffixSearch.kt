package eu.qiou.leetcode

// https://leetcode.com/problems/prefix-and-suffix-search/
// #745

class WordFilter(val words: Array<String>) {

    fun f(prefix: String, suffix: String): Int {
        val p = prefix.length
        val s = suffix.length

        words.indices.reversed().forEach {
           val w = words[it]
            val l = w.length
            if (l >= p && l >= s && w.slice(0.. p-1) == prefix && w.slice(l-s .. l-1) == suffix )
                return it
        }

        return -1
    }

}