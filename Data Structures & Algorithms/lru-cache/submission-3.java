class Node{
    int key,value;
    Node next,prev;
    public Node(int key,int value)
    {
        this.key=key;
        this.value=value;
    }
}
class LRUCache {
    HashMap<Integer,Node> hm=new HashMap<>();
    Node head=new Node(-1,-1);
    Node tail=new Node(-1,-1);
    int cap;
    public LRUCache(int capacity) {
        this.cap=capacity;
        head.next=tail;
        tail.prev=head;
    }
    public void remove(Node node)
    {
        hm.remove(node.key);
        if(node.next!=null){
        node.prev.next=node.next;
        node.next.prev=node.prev;
        }
    }
    public void insert(Node node)
    {
        hm.put(node.key,node);
        node.next=head.next;
         node.prev=head;
        head.next.prev=node;
        head.next=node;
       
        
    }
    public int get(int key) {
        if(hm.containsKey(key))
        {
            Node node=hm.get(key);
            remove(node);
            insert(node);
            return node.value;
            
        }
        
        return -1;

    }
    
    public void put(int key, int value) {
        if(hm.containsKey(key))
        {
            remove(hm.get(key));
           
        }
         if(hm.size()==cap)
        {
            remove(tail.prev);
        }
        
            insert(new Node(key,value));
        
    }
}
