
class Solution {
    public ListNode removeZeroSumSublists(ListNode head) {
        if(head == null)return head;
        ListNode prev = null;
        ListNode cur = head;
        int  running_sum=0;
        while(cur!=null)
        {
            running_sum += cur.val;
            if(running_sum==0)
            {
                if(prev == null)
                head = cur.next;
                else
                prev.next = cur.next;
                return removeZeroSumSublists(head);
            }
            cur = cur.next;
        }
        head.next = removeZeroSumSublists(head.next);
        return head;
    }
}
