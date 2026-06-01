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
class Pair{
    int data;
    ListNode node;
    public Pair(int data,ListNode node)
    {
        this.data=data;
        this.node=node;
    }
}
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<Pair> pq=new PriorityQueue<>((x,y)->x.data-y.data);
        for(int i=0;i<lists.length;i++)
        {
            ListNode temp=lists[i];
            pq.add(new Pair(temp.val,temp));
        }
        ListNode dummy=new ListNode(-1);
        ListNode temp=dummy;
        while(!pq.isEmpty())
        {
            Pair it=pq.remove();
            temp.next=it.node;
            temp=temp.next;
            if(it.node.next!=null)
            pq.add(new Pair(it.node.next.val,it.node.next));
        }
        return dummy.next;
    }
}
