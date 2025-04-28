public class MaxDepth {
    private int maxDepth;
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

    public int maxDepth(TreeNode root){
        if(root==null){
            return 0;
        }

        int leftDepth = maxDepth(root.left);
        int rightDepth = maxDepth(root.right);

        return Math.max(leftDepth,rightDepth)+1;
    }
    
    //// Using BFS and queue  - max depth
    // private Queue<SimpleEntry<TreeNode,Integer>> next_nodes = new LinkedList<>();
    // private int max_depth = 0;
    // private int nextMaxDepth(){
    //     if(next_nodes.isEmpty()){
    //         return max_depth;
    //     }
    //     SimpleEntry<TreeNode,Integer> next_item = next_nodes.poll();
    //     TreeNode next_node = next_item.getKey();
    //     max_depth = Math.max(max_depth,next_item.getValue()+1);
    //     if(next_node.left!=null){
    //         next_nodes.add(new SimpleEntry<>(next_node.left,next_item.getValue()+1));
    //     }
    //     if(next_node.right!=null){
    //         next_nodes.add(new SimpleEntry<>(next_node.right,next_item.getValue()+1));
    //     }
    //     return nextMaxDepth();
    // }
    // public int maxDepth(TreeNode root) {
    //     if(root == null){
    //         return 0;
    //     }
    //     next_nodes.clear();
    //     max_depth = 0;
    //     next_nodes.add(new SimpleEntry<>(root,0));
    //     return nextMaxDepth();
    // }
    // //using dfs with iteration - max depth
    // public int maxDepth(TreeNode root) {
    //     LinkedList<TreeNode> stack = new LinkedList<>();
    //     LinkedList<Integer> depths = new LinkedList<>();
    //     if (root == null) return 0;

    //     stack.add(root);
    //     depths.add(1);

    //     int depth = 0, current_depth = 0;
    //     while (!stack.isEmpty()) {
    //         root = stack.pollLast();
    //         current_depth = depths.pollLast();
    //         if (root != null) {
    //             depth = Math.max(depth, current_depth);
    //             stack.add(root.left);
    //             stack.add(root.right);
    //             depths.add(current_depth + 1);
    //             depths.add(current_depth + 1);
    //         }
    //     }
    //     return depth;
    // }

}
