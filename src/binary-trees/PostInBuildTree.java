import java.util.HashMap;

public class PostInBuildTree {

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
    
  // construct tree given postorder and inorder
  private int postorderIndex;
  private HashMap<Integer,Integer> inorderIndexMap = new HashMap<>();

  private TreeNode arrayToTree(int[] postorder, int left, int right){
      if(left>right)
          return null;
      
      int rootValue = postorder[--postorderIndex];
      TreeNode root = new TreeNode(rootValue);
              root.right = arrayToTree(postorder,inorderIndexMap.get(rootValue)+1,right);

      root.left = arrayToTree(postorder,left,inorderIndexMap.get(rootValue)-1);
      return root;
  }
  public TreeNode buildTree(int[] inorder, int[] postorder) {
      postorderIndex = postorder.length;
      for(int i=0;i<inorder.length;i++){
          inorderIndexMap.put(inorder[i],i);
      }
      return arrayToTree(postorder,0 ,inorder.length-1);
      
  }
}
