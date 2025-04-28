import java.util.LinkedList;
import java.util.Queue;

public class InvertTree {
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

     // invert treee -using bfs queue
     public TreeNode invertTree(TreeNode root) {
        if(root==null)
            return null;
        
        Queue<TreeNode> queue = new LinkedList<>();

        queue.add(root);

        while(!queue.isEmpty()){
            TreeNode current = queue.poll();
            if(current!=null){
            TreeNode temp = current.left;
            current.left = current.right;
            current.right = temp;
            queue.add(current.left);
            queue.add(current.right);}
        }
        return root;  
    }

    // // recurssion 
    // public TreeNode invertTree(TreeNode root){
    //     if(root==null){
    //         return root;
    //     }

    //     TreeNode leftTree = invertTree(root.left);
    //     TreeNode rightTree = invertTree(root.right);

    //     root.right = leftTree;
    //     root.left = rightTree;
       

    //     return root;
    // }
}
