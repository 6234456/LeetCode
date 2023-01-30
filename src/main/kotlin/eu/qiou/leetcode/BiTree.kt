package eu.qiou.leetcode

import java.util.*

class BiTree {

    class TreeNode(var `val`: Int) {
        var left: TreeNode? = null
        var right: TreeNode? = null
    }

    // https://leetcode.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/
    // 105
    fun buildTree(preorder: IntArray, inorder: IntArray): TreeNode? {
        // pos of root is the sep
        if (preorder.isEmpty())
            return null

        if(preorder.size == 1)
            return TreeNode(preorder[0])

        val sep = inorder.indexOf(preorder[0])

        return TreeNode(preorder[0]).apply {
            left = buildTree(preorder.drop(1).take(sep).toIntArray()  ,inorder.take(sep).toIntArray())
            right = buildTree(preorder.drop(sep+1).toIntArray()  ,inorder.drop(sep+1).toIntArray())
        }

    }

    fun verticalTraversal(root: TreeNode?): List<List<Int>> {

        val res = mutableMapOf<Int, MutableMap<Int, List<Int>>>()

        fun traversal(n: TreeNode?, x:Int = 0, y:Int = 0){
            if(n != null){
                res[x] = res.getOrDefault(x, mutableMapOf()).apply {
                    this[y] = this.getOrDefault(y, listOf()) + listOf(n.`val`)
                }
                traversal(n.left, x - 1, y + 1)
                traversal(n.right, x + 1, y + 1)
            }
        }
        traversal(root)

        return res.entries.toList().sortedBy{it.key}.map{
            it.value.entries.toList().sortedBy { x -> x.key }.map { x -> x.value.sorted()}.fold(listOf<Int>()){
                acc, ints ->
                    acc + ints
            }
        }
    }


    fun maxWidth(root: TreeNode?):Int{
        // loop through with Queue
        // mark currentEndNode and
        // nextEndNode  loop through current level and find the right most child node
        if (root == null) return 0
        val queue: Queue<TreeNode> = LinkedList()
        queue.add(root)

        var currentLevelEnd = root
        var nextLevelEnd:TreeNode? = null
        var ans = 0
        var tmp = 0
        while (queue.isNotEmpty()){
            val head = queue.poll()
            tmp++

            if (head.right != null){
                nextLevelEnd = head.right
            }else if (head.left != null){
                nextLevelEnd = head.left
            }

            head.left?.let {
                queue.add(it)
            }
            head.right?.let {
                queue.add(it)
            }

            if (currentLevelEnd == head){
                ans = kotlin.math.max(ans, tmp)
                currentLevelEnd = nextLevelEnd
                tmp = 0
            }
        }

        return ans

    }
}