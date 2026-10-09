

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
        if(head==null || head.next==null)
        return;
       ListNode temp=head;
       ListNode fast=temp;
       ListNode slow=temp;
       ListNode slowPrev=null;
       while(fast!=null && fast.next!=null)
       {
        slowPrev=slow;
        slow=slow.next;
        fast=fast.next.next;
       }
       System.out.println(slowPrev.val);
        ListNode second=slow;
        slowPrev.next=null;
        second= reverse(second);
        while(temp!=null && second!=null)
        {
           ListNode tempNext=temp.next;
           ListNode secondNext =second.next;
           temp.next=second;
           if(tempNext==null && secondNext!=null)
            second.next=secondNext;
            else
           second.next=tempNext;
           
           temp=tempNext;
           second=secondNext;
        }
        

    }
}
