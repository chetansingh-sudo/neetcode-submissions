
class Solution {
    public Node copyRandomList(Node head) {
        Node temp=head;
        while(temp!=null)
        {
            Node copyNode= new Node(temp.val);
            copyNode.next=temp.next;
            temp.next=copyNode;
            temp=temp.next.next;
        }
        temp=head;
        while(temp!=null)
        {
            Node copyNode=temp.next;
            if(temp.random!=null)
            copyNode.random=temp.random.next;
           // copyNode=copyNode.next;
            temp=temp.next.next;
        }
        Node dummy=new Node(-1);
        Node ans=dummy;
        temp=head;
        while(temp!=null)
        {
            ans.next=temp.next;
            temp.next=temp.next.next;
            ans=ans.next;
            temp=temp.next;
        }
        return dummy.next;
    }
}
