//Beast 80%
class Solution {
    public void reorderList(ListNode head) {
        int arr[]=new int[size(head)];
        int i = 0 ;
        ListNode temp = head;
        while(head!=null){
            arr[i]=head.val;
            i++;
            head=head.next;
        }
        int newArr[]=new int[arr.length];
        int si=0;
        int ei=arr.length-1;
        for(int j = 0 ; j<arr.length ; j++){
            if(j%2==0){
                newArr[j]=arr[si];
                si++;
            }
            else{
                newArr[j]=arr[ei];
                ei--;
            }
        }
        int j = 0 ;
        while(temp!=null){
            temp.val=newArr[j];
            temp=temp.next;
            j++;
        }
        
    }

    public int size(ListNode head){
        int size =  0;
        while(head!=null){
            size++;
            head=head.next;
        }
        return size;
    }
}

//Beats 100%


class Solution {
     public static void reorderList(ListNode head) {
		if (head.next == null) {
			return;
		}
		reorderList2(head, head.next);
	}

	public static ListNode reorderList2(ListNode head, ListNode curr) {
		ListNode temp;
		if (curr.next != null) {
			temp = reorderList2(head, curr.next);
		} else {
			temp = head;
		}
		if(temp == null) {
			return null;
		}
		if (temp == curr  || temp.next == curr) {
			curr.next=null;
			return null;
		}

		curr.next = temp.next;
		temp.next = curr;
		return curr.next;
	}
        
}
