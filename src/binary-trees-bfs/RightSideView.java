import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

class RightSideView {
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

    public List<Integer> rightSideView(TreeNode root) {
        if (root == null) return new ArrayList<Integer>();

        ArrayDeque<TreeNode> queue = new ArrayDeque<>() {
            {
                offer(root);
            }
        };
        List<Integer> rightside = new ArrayList<>();

        while (!queue.isEmpty()) {
            int levelLength = queue.size();

            for (int i = 0; i < levelLength; ++i) {
                TreeNode node = queue.poll();

                // if it's the rightmost element
                if (i == levelLength - 1) {
                    rightside.add(node.val);
                }

                // add child nodes in the queue
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
        }
        return rightside;
    }

    // dfs way - faster
    // private void dfs(TreeNode node,int d,List<Integer>res){
    //     if(node==null)
    //         return;
        
    //     if(res.size()==d)
    //         res.add(node.val);

    //     dfs(node.right,d+1,res);
    //     dfs(node.left,d+1,res);

    // }
    // public List<Integer> rightSideView(TreeNode root) {
    //     if(root==null) return new ArrayList<Integer>();
    //     List<Integer> res = new ArrayList<>();
    //     int depth =0;
    //     dfs(root,depth,res);
    //     return res;
    // }
}