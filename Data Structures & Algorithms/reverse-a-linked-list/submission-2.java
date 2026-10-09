
class Solution {
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
        return prev;
    }
    public ListNode reverseList(ListNode head) {
        return reverse(head);
    }
}
