import java.util.HashMap;
import java.util.Map;

class ListNode{
    int key;
    int val;
    ListNode prev;
    ListNode next;

    public ListNode(int key, int val){
        this.key=key;
        this.val=val;
    }
}
public class LRUCache {
   
    
    
        int capacity;
        Map<Integer,ListNode> dic;
        ListNode head;
        ListNode tail;
    
        public LRUCache(int capacity) {
            this.capacity = capacity;
            dic = new HashMap<>();
            head = new ListNode(-1,-1);
            tail = new ListNode(-1,-1);
            head.next=tail;
            tail.prev = head;
        }
        
        public int get(int key) {
            if(!dic.containsKey(key))
                return -1;
    
            ListNode node = dic.get(key);
            remove(node);
            add(node);
            return node.val;    
        }
    
        private void remove(ListNode node){
            node.prev.next = node.next;
            node.next.prev = node.prev;
        }
    
         public void add(ListNode node) {
            ListNode previousEnd = tail.prev;
            previousEnd.next = node;
            node.prev = previousEnd;
            node.next = tail;
            tail.prev = node;
        }
        
        public void put(int key, int value) {
            if(dic.containsKey(key)){
                ListNode oldNode = dic.get(key);
                remove(oldNode);
            }
    
            ListNode newNode = new ListNode(key,value);
            dic.put(key,newNode);
            add(newNode);
    
            if(dic.size()>capacity){
                ListNode leastUsedNode = head.next;
                remove(leastUsedNode);
                dic.remove(leastUsedNode.key);
            }
            
        }
    }
    
    /**
     * Your LRUCache object will be instantiated and called as such:
     * LRUCache obj = new LRUCache(capacity);
     * int param_1 = obj.get(key);
     * obj.put(key,value);
     */

