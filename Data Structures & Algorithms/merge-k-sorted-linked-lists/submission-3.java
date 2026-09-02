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
    ListNode first;
    int second;
    public Pair(ListNode first,int second)
    {
        this.first=first;
        this.second=second;
    }
}
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists.length==0)
        return null;
        PriorityQueue<Pair> pq=new PriorityQueue<>((x,y)->{
            return x.second-y.second;
        });
        for(int i=0;i<lists.length;i++)
        {
            ListNode temp=lists[i];
            if(temp!=null)
            pq.add(new Pair(temp,temp.val));
        }
        ListNode dummy=new ListNode(-1);
        ListNode temp=dummy;
        while(!pq.isEmpty())
        {
            Pair it=pq.remove();
            temp.next=it.first;
            temp=temp.next;
            if(it.first.next!=null)
            {
                pq.add(new Pair(it.first.next,it.first.next.val));
            }
        }
        return dummy.next;
    }
}
