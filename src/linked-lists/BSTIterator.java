import java.util.ArrayList;


 
class BSTIterator {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
        }
    ArrayList<Integer> nodesSorted;
    int index;

    public BSTIterator(TreeNode root) {
        // Array containing all the nodes in the sorted order
        this.nodesSorted = new ArrayList<Integer>();

        // Pointer to the next smallest element in the BST
        this.index = -1;

        // Call to flatten the input binary search tree
        this._inorder(root);
    }

    private void _inorder(TreeNode root) {
        if (root == null) {
            return;
        }

        this._inorder(root.left);
        this.nodesSorted.add(root.val);
        this._inorder(root.right);
    }

    /**
     * @return the next smallest number
     */
    public int next() {
        return this.nodesSorted.get(++this.index);
    }

    /**
     * @return whether we have a next smallest number
     */
    public boolean hasNext() {
        return this.index + 1 < this.nodesSorted.size();
    }
}

// without inorder recursion
// class BSTIterator {
//     Stack<TreeNode>stack;

//     public BSTIterator(TreeNode root) {
//         this.stack = new Stack<TreeNode>();

//         this._leftMostNodes(root);
//     }

//     private void _leftMostNodes(TreeNode root) {
//         while(root!=null){
//             this.stack.push(root);
//             root=root.left;
//         }
//     }
    
//     public int next() {
//         TreeNode topNode = this.stack.pop();

//         if(topNode.right!=null){
//             this._leftMostNodes(topNode.right);
//         }

//         return topNode.val;  
//     }
    
//     public boolean hasNext() {
//         return !stack.isEmpty();
//     }
// }