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

    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode temp = reverse(head);

        ListNode prev = null;
        ListNode temp2 = temp;
        int count = 0;

        while(temp2 != null)
        {
            count++;

            // delete first node of reversed list
            if(count == n && prev == null){
                temp = temp.next;      // move head
                break;
            }

            if(count == n){
                prev.next = temp2.next;
                break;
            }

            prev = temp2;
            temp2 = temp2.next;
        }

        return reverse(temp);
    }
}
