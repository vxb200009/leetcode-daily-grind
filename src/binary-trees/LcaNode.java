class LcaNode {

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
    

    // Three static flags to keep track of post-order traversal.

    // Both left and right traversal pending for a node.
    // Indicates the nodes children are yet to be traversed.
    private static int BOTH_PENDING = 2;

    // Left traversal done.
    private static int LEFT_DONE = 1;

    // Both left and right traversal done for a node.
    // Indicates the node can be popped off the stack.
    private static int BOTH_DONE = 0;

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

        Stack<Pair<TreeNode, Integer>> stack = new Stack<Pair<TreeNode, Integer>>();

        // Initialize the stack with the root node.
        stack.push(new Pair<TreeNode, Integer>(root, Solution.BOTH_PENDING));

        // This flag is set when either one of p or q is found.
        boolean one_node_found = false;

        // This is used to keep track of the LCA.
        TreeNode LCA = null;

        // Child node
        TreeNode child_node = null;

        // We do a post order traversal of the binary tree using stack
        while (!stack.isEmpty()) {

            Pair<TreeNode, Integer> top = stack.peek();
            TreeNode parent_node = top.getKey();
            int parent_state = top.getValue();

            // If the parent_state is not equal to BOTH_DONE,
            // this means the parent_node can't be popped off yet.
            if (parent_state != Solution.BOTH_DONE) {

                // If both child traversals are pending
                if (parent_state == Solution.BOTH_PENDING) {

                    // Check if the current parent_node is either p or q.
                    if (parent_node == p || parent_node == q) {

                        // If one_node_found was set already, this means we have found
                        // both the nodes.
                        if (one_node_found) {
                            return LCA;
                        } else {
                            // Otherwise, set one_node_found to True,
                            // to mark one of p and q is found.
                            one_node_found = true;

                            // Save the current top element of stack as the LCA.
                            LCA = stack.peek().getKey();
                        }
                    }

                    // If both pending, traverse the left child first
                    child_node = parent_node.left;
                } else {
                    // traverse right child
                    child_node = parent_node.right;
                }

                // Update the node state at the top of the stack
                // Since we have visited one more child.
                stack.pop();
                stack.push(new Pair<TreeNode, Integer>(parent_node, parent_state - 1));

                // Add the child node to the stack for traversal.
                if (child_node != null) {
                    stack.push(new Pair<TreeNode, Integer>(child_node, Solution.BOTH_PENDING));
                }
            } else {

                // If the parent_state of the node is both done,
                // the top node could be popped off the stack.
                // Update the LCA node to be the next top node.
                if (LCA == stack.pop().getKey() && one_node_found) {
                    LCA = stack.peek().getKey();
                }

            }
        }

        return null;
    }


    // // with parent pointer
    // public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

    //     // Stack for tree traversal
    //     Deque<TreeNode> stack = new ArrayDeque<>();

    //     // HashMap for parent pointers
    //     Map<TreeNode, TreeNode> parent = new HashMap<>();

    //     parent.put(root, null);
    //     stack.push(root);

    //     // Iterate until we find both the nodes p and q
    //     while (!parent.containsKey(p) || !parent.containsKey(q)) {

    //         TreeNode node = stack.pop();

    //         // While traversing the tree, keep saving the parent pointers.
    //         if (node.left != null) {
    //             parent.put(node.left, node);
    //             stack.push(node.left);
    //         }
    //         if (node.right != null) {
    //             parent.put(node.right, node);
    //             stack.push(node.right);
    //         }
    //     }

    //     // Ancestors set() for node p.
    //     Set<TreeNode> ancestors = new HashSet<>();

    //     // Process all ancestors for node p using parent pointers.
    //     while (p != null) {
    //         ancestors.add(p);
    //         p = parent.get(p);
    //     }

    //     // The first ancestor of q which appears in
    //     // p's ancestor set() is their lowest common ancestor.
    //     while (!ancestors.contains(q))
    //         q = parent.get(q);
    //     return q;
    // }


    // // recurssion
    // private TreeNode ans = null;
    // private boolean isLCA(TreeNode node,TreeNode p, TreeNode q){
    //     if(node==null)
    //         return false;

    //     int leftTree = isLCA(node.left,p,q)?1:0;
    //     int rightTree = isLCA(node.right,p,q)?1:0;
    //     int mid = (node.val==p.val||node.val==q.val)? 1:0;

    //     if(mid+leftTree+rightTree>=2){
    //         this.ans = node;
    //     }

    //     return (mid+leftTree+rightTree>0);
    // }
    // public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
    //     if(root==null)
    //         return null;

    //     isLCA(root,p,q);
    //     return this.ans;

    // }
}