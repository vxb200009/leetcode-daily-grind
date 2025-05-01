import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class KDistNodes {
    public class TreeNode {
          int val;
         TreeNode left;
             TreeNode right;
             TreeNode(int x) { val = x; }
         }
    Map<TreeNode,TreeNode> parent;
    private void addParent(TreeNode node, TreeNode parent){
        if(node==null)
            return;

        this.parent.put(node,parent);
        addParent(node.left,node);
        addParent(node.right,node);
    }
    private void dfs(TreeNode curr, int distance, List<Integer> answer, Set<TreeNode> visited){
        if(curr==null||visited.contains(curr))
            return;
        
        visited.add(curr);
        if(distance==0){
            answer.add(curr.val);
            return;
        }
        dfs(parent.get(curr),distance-1,answer,visited);
        dfs(curr.left,distance-1,answer,visited);
        dfs(curr.right,distance-1,answer,visited);
    }

    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        parent = new HashMap<>();
        addParent(root,null);
        List<Integer> answer =new ArrayList<>();
        Set<TreeNode> visited = new HashSet<>();
        dfs(target,k,answer,visited);
        return answer;
    }


    // // using bfs
    // public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
    //     Map<Integer,List<Integer>> graph = new HashMap<>();
    //     dfsBuild(root,null,graph);
 
    //     List<Integer> answer = new ArrayList<>();
    //     Set<Integer> visited = new HashSet<>();
    //     Queue<int[]> queue = new LinkedList<>();
 
    //      queue.add(new int[]{target.val,0});
    //      visited.add(target.val);
 
    //      while(!queue.isEmpty()){
    //          int[] cur = queue.poll();
    //          int node = cur[0], distance = cur[1];
 
    //          if(distance==k){
    //              answer.add(node);
    //              continue;
    //          }
 
    //          for(int neighbor : graph.getOrDefault(node, new ArrayList<>())){
    //              if(!visited.contains(neighbor)){
    //                  visited.add(neighbor);
    //                  queue.add(new int[] {neighbor, distance+1});
    //              }
    //          }
    //      }
    //      return answer;
    //  }
 
    //  private void dfsBuild(
    //      TreeNode cur, 
    //      TreeNode parent, 
    //      Map<Integer,List<Integer>> graph ){
    //          if(cur!=null && parent!=null){
    //              int curVal = cur.val, parentVal = parent.val;
    //              graph.putIfAbsent(curVal,new ArrayList<>());
    //              graph.putIfAbsent(parentVal,new ArrayList<>());
    //              graph.get(curVal).add(parentVal);
    //              graph.get(parentVal).add(curVal);
    //          }
 
    //          if(cur!=null && cur.left!=null){
    //              dfsBuild(cur.left,cur,graph);
    //          }
 
    //          if(cur!=null && cur.right!=null){
    //              dfsBuild(cur.right,cur,graph);
    //          }
    //      }
}
