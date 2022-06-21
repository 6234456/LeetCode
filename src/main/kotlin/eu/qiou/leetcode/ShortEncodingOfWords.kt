package eu.qiou.leetcode
//https://leetcode.com/problems/short-encoding-of-words/submissions/
// #820
class ShortEncodingOfWords {
    fun minimumLengthEncoding(words: Array<String>): Int {
        val t = Trie()
        val w = words.map { it.reversed() }.sortedByDescending { it.length }

        return w.fold(0){
                acc, s ->
            if (!t.startsWith(s)){
                t.insert(s)
                acc+s.length + 1
            }else
                acc
        }

    }
}