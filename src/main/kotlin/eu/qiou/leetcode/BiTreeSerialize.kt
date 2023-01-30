package eu.qiou.leetcode

import java.util.LinkedList
import java.util.Queue

class BiTreeSerialize {
    fun preSerialize(node:BiTree.TreeNode?):Queue<Int?>{
       if (node == null) return LinkedList(null)

        val ans: Queue<Int?> = LinkedList()
        pre(node, ans)

        return ans
    }

    private fun pre(node:BiTree.TreeNode?, queue: Queue<Int?>){
        if (node == null) queue.add(null)
        else{
            queue.add(node.`val`)
            pre(node.left, queue)
            pre(node.right, queue)
        }
    }

    fun levelSerialize(node: BiTree.TreeNode?):Queue<Int?>{
        if (node == null) return LinkedList(null)

        val ans: Queue<Int?> = LinkedList()
        val queue:Queue<BiTree.TreeNode> = LinkedList()
        queue.add(node)
        ans.add(node.`val`)

        // add the branches to the queue
        while (queue.isNotEmpty()){
            val n = queue.poll()

            if (n.left == null){
                ans.add(null)
            }else{
                queue.add(n.left)
                ans.add(n.left!!.`val`)
            }

            if (n.right == null){
                ans.add(null)
            }else{
                queue.add(n.right)
                ans.add(n.right!!.`val`)
            }
        }
        return ans
    }

}