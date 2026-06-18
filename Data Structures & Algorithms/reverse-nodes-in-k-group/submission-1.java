
class Solution {
    public ListNode findKNode(ListNode temp,int k)
    {
       int count=0;
        while(temp!=null)
        {
            count++;
            if(count==k)
            {
                return temp;
            }
            temp=temp.next;
        }
        return null;
    }
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
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode temp=head;
        ListNode prev=null;
        while(temp!=null)
        {
            ListNode kthNode=findKNode(temp,k);
           
            if(kthNode==null)
            {
                if(prev!=null)
                prev.next=temp;
                break;
            }
            ListNode nextNode=kthNode.next;
            kthNode.next=null;
            reverse(temp);
            if(head==temp)
            {
               head=kthNode; 
               
            }
            else{
               
            prev.next=kthNode;
            }
            prev=temp;
            temp=nextNode;

        }
        return head;
    }
}
