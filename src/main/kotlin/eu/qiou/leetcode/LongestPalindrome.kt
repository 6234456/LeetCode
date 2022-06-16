package eu.qiou.leetcode

// #5  https://leetcode.com/problems/longest-palindromic-substring/

class LongestPalindrome {
    // loop through to find the string centered on the element char
    fun longestPalindrome(s: String): String {
        val s0 = s.toCharArray()
        var res: Pair<Int, Int>  = 0 to 0

        s0.indices.forEach {
            val v = search(it, s0)
            if (v.second - v.first > res.second - res.first)
                res = v
        }

        return s.slice(res.first .. res.second)
    }

    fun search(center: Int, array: CharArray): Pair<Int, Int>{
       var left = center
       var right = center
        val l = array.size - 1

       while (left > 0 && right < l) {
           if (array[left-1] != array[right+1])
              break

           left--
           right++

       }

        // center lies between target and the next element
        var left0 = center
        var right0 = center + 1

       if (right0 <= l && array[left0] == array[right0] ){
           while (left0 > 0 && right0 < l ) {
               if (array[left0-1] != array[right0+1])
                   break

               left0--
               right0++
           }

           if (right0 - left0 > right - left)
               return left0 to right0
       }

       return left to right

    }
}