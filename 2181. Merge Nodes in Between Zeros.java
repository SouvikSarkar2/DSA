//BEATS 100 %

class Solution {
    public ListNode mergeNodes(ListNode head)
    {
        ListNode temp=head.next;
        ListNode ans=head;
        int sum=0;
        while(temp!=null)
        {
            if(temp.val==0)
            {
                temp.val=sum;
                ans.next=temp;
                ans=ans.next;
                sum=0;              
            }
            else
                sum+=temp.val;
            temp=temp.next;
        }
        return head.next;
    }
}



// BEATS 10%

class Solution {
    public ListNode mergeNodes(ListNode head) {
        //Find Sum And ADd the Sum in BEtween The Nodes

        ListNode temp = head.next; 
    ListNode prev = head;      
    int sum = 0;

    while (temp != null) {
        if (temp.val == 0) { 
            ListNode sumNode = new ListNode(sum); 
            prev.next = sumNode;                  
            sumNode.next = temp;
            sum = 0;
            prev = temp;
        } else {
            sum += temp.val; 
        }
        temp = temp.next; 
    }

        // Remove The Zeroes And return the nodes
        ListNode reducer = head.next;
        while(reducer!=null){
            if(reducer.next.val==0){
                reducer.next=reducer.next.next;
            }
            reducer=reducer.next;
        }

        return head.next;





        
    }
}


