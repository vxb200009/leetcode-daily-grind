import java.util.LinkedList;

/**
 * Definition for a binary tree node.*/
 
 
class sumRootToLeafNumber {
    public class TreeNode {
        int val;
        TreeNode left;
       TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
    // using Mooris preorder traversal uses O(1) space
    public int sumNumbers(TreeNode root) {
        int rootToLeaf = 0, currNumber = 0;
        int steps;
        TreeNode predecessor;

        while (root != null) {
            // If there is a left child,
            // then compute the predecessor.
            // If there is no link predecessor.right = root --> set it.
            // If there is a link predecessor.right = root --> break it.
            if (root.left != null) {
                // Predecessor node is one step to the left
                // and then to the right till you can.
                predecessor = root.left;
                steps = 1;
                while (predecessor.right != null && predecessor.right != root) {
                    predecessor = predecessor.right;
                    ++steps;
                }

                // Set link predecessor.right = root
                // and go to explore the left subtree
                if (predecessor.right == null) {
                    currNumber = currNumber * 10 + root.val;
                    predecessor.right = root;
                    root = root.left;
                }
                // Break the link predecessor.right = root
                // Once the link is broken,
                // it's time to change subtree and go to the right
                else {
                    // If you're on the leaf, update the sum
                    if (predecessor.left == null) {
                        rootToLeaf += currNumber;
                    }
                    // This part of tree is explored, backtrack
                    for (int i = 0; i < steps; ++i) {
                        currNumber /= 10;
                    }
                    predecessor.right = null;
                    root = root.right;
                }
            }
            // If there is no left child
            // then just go right.
            else {
                currNumber = currNumber * 10 + root.val;
                // if you're on the leaf, update the sum
                if (root.right == null) {
                    rootToLeaf += currNumber;
                }
                root = root.right;
            }
        }
        return rootToLeaf;
    }
    //Using DFS stack
    // public int sumNumbers(TreeNode root) {
    //     if(root==null)
    //     {
    //         return 0;
    //     }

    //     LinkedList<TreeNode> stack = new LinkedList<>();
    //     LinkedList<Integer> valueStack = new LinkedList<>();
    //     int totalSum = 0;
    //     stack.add(root);
    //     valueStack.add(0);

    //     while(!stack.isEmpty()){
    //         TreeNode currNode = stack.pollLast();
    //         int val = valueStack.pollLast();
    //         int curVal = val*10+currNode.val;

    //         if(currNode.left==null && currNode.right==null){
    //             totalSum+=curVal;
    //         }

    //         if(currNode.left!=null){
    //             stack.add(currNode.left);
    //             valueStack.add(curVal);
    //         }

    //          if(currNode.right!=null){
    //             stack.add(currNode.right);
    //             valueStack.add(curVal);
    //         }

    //     }

    //     return totalSum;
        
    // }

    // using recursion
    // int rootToLeaf = 0;
    // public void preorder(TreeNode r, int currNumber) {
    //     if (r != null) {
    //         currNumber = currNumber * 10 + r.val;
    //         // if it's a leaf, update root-to-leaf sum
    //         if (r.left == null && r.right == null) {
    //             rootToLeaf += currNumber;
    //         }
    //         preorder(r.left, currNumber);
    //         preorder(r.right, currNumber);
    //     }
    // }

    // public int sumNumbers(TreeNode root) {
    //     preorder(root, 0);
    //     return rootToLeaf;
    // }
}

