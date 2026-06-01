
class Solution {
    public ListNode findKthNode(ListNode temp,int k)
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
            ListNode nxtNode=temp.next;
            temp.next=prev;
            prev=temp;
            temp=nxtNode;
        }
        return prev;
    }
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode temp=head;
        ListNode prev=null;
        while(temp!=null)
        {

            ListNode findKNode=findKthNode(temp,k);
            ListNode nextNode=null;
             
            if(findKNode==null)
            {
               System.out.print(prev.val+" "+temp.val);
                prev.next=temp;
                break;
            }
            else
            {
                nextNode=findKNode.next;
                findKNode.next=null;
            }
           reverse(temp);
            if(head==temp)
            {
                head=findKNode;
            }
            else
            {
                prev.next=findKNode;
            }
            prev=temp;
            temp=nextNode;
        }
        return head;
    }
}
