class BtMaxPathSum {
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
    
    int maxSum=Integer.MIN_VALUE;
    private int gainFromSubTree(TreeNode node){
        if(node==null)
            return 0;

        int leftGain = Math.max(gainFromSubTree(node.left),0);
        int rightGain = Math.max(gainFromSubTree(node.right),0);

        maxSum = Math.max(maxSum,leftGain+rightGain+node.val);
        
        return Math.max(node.val+leftGain,node.val+rightGain);
    }
    public int maxPathSum(TreeNode root) {
        
        gainFromSubTree(root);
        return maxSum;
    }
}