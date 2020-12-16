package eu.qiou.leetcode


/**
 * https://leetcode.com/explore/challenge/card/december-leetcoding-challenge/569/week-1-december-1st-december-7th/3551/
 */

object MaxNodeDepth {
    class TreeNode(var `val`: Int) {
        var left: TreeNode? = null
        var right: TreeNode? = null

        override fun toString(): String {
            return "${`val`} left: ${left?.`val`} right: ${right?.`val`}"
        }
    }

    fun isValidBST(root: TreeNode?): Boolean {
        if (root == null)
            return true
        else {
            root.left?.`val`?.let {
                if (it > root.`val`)
                    return false
            }

            root.right?.`val`?.let {
                if (it < root.`val`)
                    return false
            }

            val left_max = (max(root.left) ?: root).`val`
            val right_min = (min(root.right) ?: root).`val`

            if (root.left != null && left_max == root.`val`)
                return false

            if (root.right != null && right_min == root.`val`)
                return false



            if (left_max > root.`val` || right_min < root.`val`)
                return false


            return isValidBST(root.left) && isValidBST(root.right)
        }
    }

    fun add(treeNode: TreeNode, i: Int): TreeNode {
        if (treeNode.`val` > i) {
            if (treeNode.left == null)
                treeNode.left = TreeNode(i)
            else
                add(treeNode.left!!, i)
        } else if (treeNode.`val` < i) {
            if (treeNode.right == null)
                treeNode.right = TreeNode(i)
            else
                add(treeNode.right!!, i)
        }

        return treeNode
    }

    fun new(list: List<Int?>): TreeNode? {
        val l = list.filter { it != null } as List<Int>

        if (l.isEmpty())
            return null


        return l.drop(1).fold(TreeNode(l.first())) { acc, i -> add(acc, i) }
    }

    fun maxDepth(root: TreeNode?): Int {

        if (root != null) {

            return 1 + Integer.max(maxDepth(root.left), maxDepth(root.right))

        }

        return 0
    }

    fun increasingBST(root: TreeNode?): TreeNode? {
        if (root != null) {
            if (root.left == null && root.right == null)
                return root
            else if (root.left != null && root.right == null && root.left!!.left == null &&
                root.left!!.right == null
            )
                return root.left!!.apply {
                    right = root
                    root.left = null
                }
            else if (root.left == null && root.right != null
                && root.right!!.left == null
                && root.right!!.right == null
            ) {
                return root
            } else {
                val r = root.right
                val l = root.left
                val res = min(l) ?: root
                root.right = null
                root.left = null

                root.right = min(increasingBST(r))
                max(increasingBST(l))?.right = root

                return res
            }
        }

        return null
    }

    fun max(root: TreeNode?): TreeNode? {
        if (root?.right == null)
            return root

        return max(root.right)
    }

    fun min(root: TreeNode?): TreeNode? {
        if (root?.left == null)
            return root

        return min(root.left)
    }
}