
public class LinkedListCycleII {
    public ListNode detectCycle(ListNode head) {

        if(head==null)
            return null;

        ListNode slowRunner = head;
        ListNode fastRunner = head;

        while(fastRunner!=null && fastRunner.next!=null){
            slowRunner = slowRunner.next;
            fastRunner = fastRunner.next.next;

            if(slowRunner==fastRunner){
                ListNode current =head;
                while(current!=slowRunner){
                    current = current.next;
                    slowRunner = slowRunner.next;
                }
                return slowRunner;
            }
        }

        return null;
        
    }
}
