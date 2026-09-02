class Solution {
    public ListNode reverse(ListNode head)
    {
        ListNode prev=null;
        while(head!=null)
        {
            //System.out.print(head.val+" ");
            ListNode nextNode=head.next;
            head.next=prev;
            prev=head;
            head=nextNode;
        }
        return prev;
    }
    public ListNode reverseBetween(ListNode head, int left, int right) {
        if(left==right)
        return head;
        ListNode prev=null;
        ListNode second=null;
        ListNode first=null;
        ListNode temp=head;
        int count=0;
        while(temp!=null)
        {
            count++;
            if(count==left)
            {
                first=prev;
            }
            else if(count==right)
            {
                //System.out.println(temp.val);
                second=temp;
            }
            prev=temp;
            temp=temp.next;
        }
        ListNode nextNode = second.next;
        second.next=null;
        temp=head;
        if(first==null)
        {
            ListNode rev=reverse(temp);
            
            if(nextNode==null)
            {
                return rev;
            }
            temp.next=nextNode;
            return rev;
        }
        
       temp=first;
        ListNode nextNod=first.next;
        
        first.next=null;
        ListNode rev=reverse(nextNod);
        first.next=rev;
        
        nextNod.next=nextNode;
        return head;

    }
}