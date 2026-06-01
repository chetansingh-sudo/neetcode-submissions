
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
    public ListNode reverseBetween(ListNode head, int left, int right) {
        if(head==null )
        return null;
        if(left==right)
        return head;
        ListNode temp=head;
        ListNode prev=null;
        ListNode first=null,second=null;
        int count=0;
        while(temp!=null)
        {
            count++;
            if(count==left)
            {
                first=temp;
            }
            else if(count==right)
            {
                second=temp;
            }
            if(first==null)
            {
                prev=temp;
            }
            temp=temp.next;
        }
        if(second==null && first==null)
        return head;
        ListNode nextNode=second.next;
        second.next=null;
        ListNode back=second;
        if(prev!=null)
        prev.next=null;
        ListNode rev=reverse(first);
       //System.out.print(prev.val+" "+second.val);
       if(prev!=null)
        prev.next=rev;
        else
        head=rev;
        
        first.next=nextNode;
        
        return head;
    }
}