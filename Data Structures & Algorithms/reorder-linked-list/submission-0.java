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
    public ListNode reverse(ListNode temp)
    {
        ListNode prev=null;
        while(temp!=null)
        {
            ListNode nextNode=temp.next;
            temp.next=prev;
            prev=temp;
            temp=nextNode;
        }
        return prev;
    }
    public void reorderList(ListNode head) {
        ListNode slow=head;
        ListNode fast=head;
        int count=0;
        ListNode prevSlow=null;
        while(fast!=null && fast.next!=null)
        {
            
            prevSlow=slow;
            slow=slow.next;
            fast=fast.next.next;
        }
        ListNode nextNode=null;
        if(fast==null)
        {
            nextNode =prevSlow.next;    
            prevSlow.next=null;
        }
        else{
         nextNode=slow.next;
        slow.next=null;
        }
        ListNode temp1=reverse(nextNode);
        
        ListNode dummy=new ListNode(-1);
        ListNode temp2=head;
        //ListNode temp2 = head;

        while (temp1 != null) {
            ListNode t1 = temp2.next;
            ListNode t2 = temp1.next;

            temp2.next = temp1;
            temp1.next = t1;

            temp2 = t1;
            temp1 = t2;
        }
        
    }
}
