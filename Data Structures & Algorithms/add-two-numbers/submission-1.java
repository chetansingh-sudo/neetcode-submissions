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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        
        ListNode dummy=new ListNode(-1);
        ListNode temp=dummy;
         boolean flag=false;
     
        ListNode l=l1;
        ListNode t=l2;
       
        int rem=0;
        while(l!=null && t!=null)
        {
            int ans=l.val+t.val+rem;
            l=l.next;
            t=t.next;
            if(ans<10)
            {
                rem=0;
                ListNode node=new ListNode(ans);
                temp.next=node;
            }
            else
            {
                ListNode node=new ListNode(ans%10);
                rem=1;
                temp.next=node;
            }
            temp=temp.next;
        }
        if(l!=null)
        {
            while(l!=null)
            {
                int ans=rem+l.val;
                 System.out.println(rem+" "+l.val);
                l=l.next;
               
                if(ans<10)
            {
                rem=0;
                ListNode node=new ListNode(ans);
                temp.next=node;
            }
            else
            {
                ListNode node=new ListNode(ans%10);
                rem=1;
                temp.next=node;
            }
            temp=temp.next;
            
            }
        }
        else
        {
             while(t!=null)
            {
                int ans=rem+t.val;
                
                if(ans<10)
            {
                rem=0;
                ListNode node=new ListNode(ans);
                temp.next=node;
            }
            else
            {
                ListNode node=new ListNode(ans%10);
                rem=1;
                temp.next=node;
            }
            temp=temp.next;
            t=t.next;
            }
        }
        if(rem==1)
        {
            ListNode node=new ListNode(rem);
                temp.next=node;
        }
        
           return dummy.next;
            //return main;
      
    }
}
