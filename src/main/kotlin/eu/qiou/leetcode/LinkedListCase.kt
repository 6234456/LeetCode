package eu.qiou.leetcode

class LinkedListCase {
    fun mergeKLists(lists: Array<ListNode?>): ListNode? {
        if(lists.size == 0 || lists.all{it == null}) return null


        fun nextNode():Int{
            return lists.foldIndexed(-1){
                    i, acc, e ->
                if(e == null){
                    acc
                }else{
                    if(acc == -1 || lists[acc]!!.`val` > e.`val`) i else acc
                }
            }
        }

        val i = nextNode()
        val ans = lists[i]!!
        var head = ans
        lists[i] = ans.next


        while(lists.any{it != null}){
            val i = nextNode()
            val n = lists[i]
            head.next = n
            head = n!!
            lists[i] = n.next
        }

        return ans

    }
}