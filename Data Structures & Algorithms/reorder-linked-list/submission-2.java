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
    public ListNode reverse(ListNode val)
    {
        ListNode prev=null;
        while(val!=null)
        {
            ListNode nextNode=val.next;
            val.next=prev;
            prev=val;
            val=nextNode;
        }
        return prev;
    }
    public void reorderList(ListNode head) {
        if(head==null || head.next==null)
        return;
        ListNode fast=head;
        ListNode slow=head;
        ListNode prev=null;
        while(fast!=null && fast.next!=null)
        {
            prev=slow;
            slow=slow.next;
            fast=fast.next.next;
        }
        
        ListNode val=prev.next;
        prev.next=null;
        ListNode temp=reverse(val);
        
        ListNode dummy=head;
        while(dummy!=null && temp!=null)
        {
           
                ListNode nextNode=dummy.next;
                ListNode nextNode2=temp.next;
                dummy.next=temp;
                if(nextNode==null && nextNode2!=null)
                temp.next=nextNode2;
                else
                temp.next=nextNode;
                dummy=nextNode;
                temp=nextNode2;
                
        }
        
        
    }
}
