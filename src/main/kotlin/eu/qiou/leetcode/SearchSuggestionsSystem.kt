package eu.qiou.leetcode

// https://leetcode.com/problems/search-suggestions-system/
// #1268

class SearchSuggestionsSystem {
    fun suggestedProducts(products: Array<String>, searchWord: String): List<List<String>> {
        val p = products.sortedArray()
        val trie = Trie()
        p.forEach {
            trie.insert(it)
        }

        return searchWord.indices.map {
            trie.filter(searchWord.slice(0..it)).take(3)
        }
    }
}