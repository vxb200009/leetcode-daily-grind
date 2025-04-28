import java.util.LinkedList;

public class SameTree {
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

    // // using stack dfs
    // public boolean isSameTree(TreeNode p, TreeNode q) {
    //     LinkedList<Pair<TreeNode,TreeNode>> stack = new LinkedList<>();
    //     if(p==null && q==null)
    //         return true;
    //     stack.add(new Pair<TreeNode,TreeNode>(p,q));

    //     while(!stack.isEmpty()){
    //         Pair<TreeNode,TreeNode> pair = stack.pollLast();
    //         TreeNode pNode = pair.getKey();
    //         TreeNode qNode = pair.getValue();
    //         if(pNode!=null || qNode!=null){
    //             if(qNode==null)
    //                 return false;
    //             if(pNode==null)
    //                 return false;
    //             if(pNode.val!=qNode.val){
    //             return false;
    //             }
    //             stack.add(new Pair<TreeNode,TreeNode>(pNode.left,qNode.left) );
    //             stack.add(new Pair<TreeNode,TreeNode>(pNode.right,qNode.right));    
    //         }
    //     }

    //     return true;
        
    // }

    // recurssion
    public boolean isSameTree(TreeNode p, TreeNode q){
        if(p==null && q==null)
            return true;
        
        if(p==null||q==null) return false;

        if(p.val!=q.val) return false;

        return isSameTree(p.left,q.left) && isSameTree(p.right,q.right);
    }
    
}
