package eu.qiou.leetcode

class SlidingWindow {
    fun lengthOfLongestSubstring(s: String): Int {
        val l = s.length

        if (l <= 1)
            return l

        var ans = 1
        var start = 0

        val arr = s.toCharArray()
        val set = mutableSetOf<Char>()

        arr.forEachIndexed { index, c ->
            // until the next character of the dup
           while (set.contains(c)) {
               set.remove(arr[start++])
           }

            set.add(c)

            ans = kotlin.math.max(ans, index - start + 1)
        }


        return ans

    }
//https://leetcode.com/problems/minimum-window-substring/
    fun minWindow(s: String, t: String): String {
        val check = t.toCharArray().fold(mutableMapOf<Char, Int>()){
            acc, c ->
                acc.put(c, acc.getOrDefault(c, 0) + 1)
                acc
        }

        val tmp = mutableMapOf<Char, Int>()
        var l = 0
        var cnt = Integer.MAX_VALUE
        var ans = ""

        val arr = s.toCharArray()
        arr.forEachIndexed { index, c ->
            if (check.contains(c)) {
                tmp.put(c, tmp.getOrDefault(c, 0) + 1)
            }

            while (check.all { tmp.getOrDefault(it.key, 0) >= it.value }){
                while(!tmp.contains(arr[l])){
                   l++
                }

                if(cnt > index - l + 1){
                    cnt = index - l + 1
                    ans = if (l == index) arr[l].toString() else s.slice(l.. index)
                }

                tmp.put(arr[l], tmp[arr[l]]!!-1)
                l++

                while(l < arr.size && !tmp.contains(arr[l])){
                    l++
                }
            }
        }

        return ans
    }
}