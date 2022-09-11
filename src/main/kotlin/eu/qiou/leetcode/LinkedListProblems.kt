package eu.qiou.leetcode

class LinkedListProblems {
     class ListNode(var `val`: Int) {
             var next: ListNode? = null
     }

    fun toNode(l: List<Int>):ListNode?{
        if (l.isEmpty())
            return null

        val res = ListNode(l.first())
        var prevNode = res
       l.drop(1).forEach {
           val n = ListNode(it)
           prevNode.next = n
           prevNode = n
       }

        return res
    }

    // https://leetcode.com/problems/palindrome-linked-list/
    fun isPalindrome(head: ListNode?): Boolean {
        var l = 0
        var n = head

        while(n != null){
            l++
            n = n.next
        }

        if(l == 0)
            return true

        val start = if(l.rem(2) == 0) l/2 else (l + 1) / 2

        l = 0
        n = head
        while(l < start){
            l++
            n = n!!.next
        }


        var pre:ListNode? = null
        while(n != null){
            val tmp = n.next
            n.next = pre
            pre = n
            n = tmp
        }

        n = pre
        var n0 = head
        while(n != null){
            if(n!!.`val` != n0!!.`val`)
                return false

            n = n!!.next
            n0 = n0!!.next
        }

        return true

    }
}