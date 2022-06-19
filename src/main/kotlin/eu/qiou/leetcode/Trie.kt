package eu.qiou.leetcode

// https://leetcode.com/problems/implement-trie-prefix-tree/
// # 208
// like Destination-Search on the Ticket-Automate of Deutsche Bahn
class Trie() {
    val root = TrieNode()

    class TrieNode(){
        val children: Array<TrieNode?> = Array<TrieNode?>(26){null}
        var isWord: Boolean = false
    }

    fun insert(word: String) {
        var start = root
        word.toCharArray().forEach {
           val idx = it - 'a'
            if (start.children[idx] == null){
                start.children[idx] = TrieNode()
            }
            start = start.children[idx]!!
        }
        start.isWord = true
    }

    fun search(word: String): Boolean {
        return word.toCharArray().map { it - 'a' }.fold(root){
        acc: TrieNode, i: Int ->
             acc.children[i] ?: return false
        }.isWord
    }

    fun startsWith(prefix: String): Boolean {
        prefix.toCharArray().map { it - 'a' }.fold(root){
                acc: TrieNode, i: Int ->
            acc.children[i] ?: return false
        }

        return true
    }

    private fun loop(node: TrieNode, prefix: String = ""):List<String> {
        return node.children.foldIndexed(if (node.isWord) listOf(prefix) else listOf()){
           index, acc, trieNode ->
            if (trieNode == null)
                acc
            else
                acc + loop(trieNode, prefix + decode(index))
        }
    }

    private fun decode(code: Int):Char {
        return 'a' + code
    }

    fun filter(prefix: String): List<String> {
        prefix.toCharArray().map { it - 'a' }.fold(root) { acc: TrieNode, i: Int ->
            acc.children[i] ?: return listOf()
        }.let {
            return loop(it, prefix)
        }
    }

}