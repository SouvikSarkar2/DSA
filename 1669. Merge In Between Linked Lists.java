/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode mergeInBetween(ListNode list1, int a, int b, ListNode list2) {
        ListNode first = list1;
        ListNode second = list1;
        ListNode prev = list1;

        int idx = 0 ;
        while(idx<a){
            prev=first;
            first=first.next;
            second=second.next;
            idx++;
        }

        while(idx<b){

        second=second.next;
        idx++;
        }
        prev.next=list2;
        ListNode list2Tail = list2;
        while(list2Tail.next!=null){
            list2Tail=list2Tail.next;
        }
        list2Tail.next=second.next;
        return list1;
    }
}
