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
    public ListNode findKthNode(ListNode head,int k)
    {
        ListNode prev=null;
        int count=0;
        while(head!=null)
        {
            if(++count==k)
            {
                return head;
            }
            head=head.next;
        }
        return null;
    }
    public ListNode reverse(ListNode head)
    {
        ListNode prev=null;
        while(head!=null)
        {
            ListNode nextNode=head.next;
            head.next=prev;
            prev=head;
            head=nextNode;
        }
        //System.out.print(prev.val+" ");
        return prev;
    }
    public ListNode reverseKGroup(ListNode head, int k) {
       ListNode temp=head;
       ListNode prev=null;
       while(temp!=null)
       {
            ListNode kthNode=findKthNode(temp,k);
            
            if(kthNode ==null)
            {
                if(prev!=null)
                prev.next=temp;
                break;
            }
            ListNode nextNode=kthNode.next;
            kthNode.next=null;
            reverse(temp);
            if(temp==head)
            {
                head=kthNode;
            }
            else
            {
               if(prev!=null)
                prev.next=kthNode;
            }
            prev=temp;
            temp=nextNode;
       } 
       return head;
    }
}
