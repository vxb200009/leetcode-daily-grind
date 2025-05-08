public class MiddleNode {

    public ListNode middleNode(ListNode head) {
        if(head==null){
            return null;
        }
        
        ListNode slowRunner = head;
        ListNode fastRunner = head;

        while(fastRunner!=null && fastRunner.next!=null){
            slowRunner=slowRunner.next;
            fastRunner= fastRunner.next.next;
        }
        
        return slowRunner;
    }
    
}
