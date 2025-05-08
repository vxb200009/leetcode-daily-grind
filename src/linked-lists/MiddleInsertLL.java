public class MiddleInsertLL {
    private ListNode reverse(ListNode node){
        ListNode prev = null;
        ListNode cur = node;
        while(cur!=null){
            ListNode temp = cur.next;
            cur.next = prev;
            prev=cur;
            cur= temp;
        }
        return prev;
    }

    public void reorderList(ListNode head) {
        if(head==null || head.next == null)
            return;
        
        ListNode slow = head;
        ListNode fast = head;

        while(fast.next!=null && fast.next.next!=null){ //fast.next!=null && fast.next.next!=null for one node before middle
            slow = slow.next;                           // fast!=null && fast.next!=null  for exact middle
            fast= fast.next.next;
        }
        System.out.println(slow.val);
        ListNode secondHalf = reverse(slow.next);
        slow.next=null;
        ListNode firstHalf = head;
    
        while(secondHalf!=null){
            ListNode temp = secondHalf;
            secondHalf = secondHalf.next;
            temp.next=firstHalf.next;
            firstHalf.next=temp;
            firstHalf=temp.next;
        }

        return;
    }
}
