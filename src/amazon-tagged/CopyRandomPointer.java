import java.util.HashMap;
import java.util.Map;

public class CopyRandomPointer {
    public class Node {
        int val;
        Node next;
        Node random;
    
        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }
    public Node copyRandomList(Node head) {
        if(head == null)
            return null;
        Map<Node,Node> res = new HashMap<>();

        Node curr =head;

        while (curr!=null){
            res.put(curr,new Node(curr.val));
            curr = curr.next;
        }

        curr=head;
       
        while(curr!=null){
            Node copyNode = res.get(curr);
            copyNode.next = res.get(curr.next);
            copyNode.random = res.get(curr.random);
            curr = curr.next;
        }

        return res.get(head);
    }
}
