
class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode ans = head;
        ListNode temp = head;
        if(size(head)-n==0){
            return head.next;
        }
        for(int i = 0 ; i<size(head)-n-1 ; i++){
            temp =temp.next;
        }
        temp.next=temp.next.next;
        return ans;
    }

    public static int size(ListNode head){
        int size=0;
        while(head!=null){
            size++;
            head=head.next;
        }
        return size;
    }
}
