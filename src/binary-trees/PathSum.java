import java.util.LinkedList;

class PathSum{
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

  public boolean hasPathSum(TreeNode root, int sum) { //using DFS with stack
    if (root == null) return false;

    LinkedList<TreeNode> node_stack = new LinkedList<>();
    LinkedList<Integer> sum_stack = new LinkedList<>();
    node_stack.add(root);
    sum_stack.add(sum - root.val);

    TreeNode node;
    int curr_sum;
    while (!node_stack.isEmpty()) {
        node = node_stack.pollLast();
        curr_sum = sum_stack.pollLast();
        if (
            (node.right == null) && (node.left == null) && (curr_sum == 0)
        ) return true;

        if (node.right != null) {
            node_stack.add(node.right);
            sum_stack.add(curr_sum - node.right.val);
        }
        if (node.left != null) {
            node_stack.add(node.left);
            sum_stack.add(curr_sum - node.left.val);
        }
    }
    return false;
}
    // using recurssion appraoch
    // public boolean hasPathSum(TreeNode root, int targetSum) { // using recurssion
    //     if(root==null)
    //         return false;

    //     targetSum-=root.val;

    //     if((root.left==null)&&(root.right==null)) return targetSum==0;

    //     return hasPathSum(root.left,targetSum) || hasPathSum(root.right,targetSum);
    // }
}