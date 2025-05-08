public class PalindromeLL {
    private ListNode endOfFirstHalf(ListNode node){
        ListNode slow = node;
        ListNode fast = node;

        while(fast.next!=null && fast.next.next !=null){
            slow =slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
    private ListNode reverse(ListNode node){
        ListNode prev = null;
        ListNode cur = node;
        while(cur!=null){
            ListNode new_temp = cur.next;
            cur.next=prev;
            prev=cur;
            cur=new_temp;
        }
        return prev;
    }
    public boolean isPalindrome(ListNode head) {
        if(head==null)
            return true;

        ListNode firstHalfEnd = endOfFirstHalf(head);
        ListNode seconHalfStart = reverse(firstHalfEnd.next);

        ListNode p1=head;
        ListNode p2 = seconHalfStart;
        boolean res = true;
        while(res && p2!=null){
            if(p1.val!=p2.val) res = false;
            p1=p1.next;
            p2=p2.next;
        }
        //firstHalfEnd.next = reverse(seconHalfStart);
        return res;
    }
}
