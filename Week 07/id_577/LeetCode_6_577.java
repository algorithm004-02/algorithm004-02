import java.util.Hashtable;
public class LRUCache {
    
    class LRUNode {
    int key;
    int value;
    
    LRUNode pre;
    
    LRUNode next;
    
    
    
    }

    
    LRUNode head;
    LRUNode tail;
    
    Hashtable<Integer, LRUNode> cache = new Hashtable<Integer, LRUNode>();
    
    int size ;
    
    int capacity;

    public LRUCache(int capacity) {
        
        this.size = 0;
        
        this.capacity = capacity;
        
        this.head = new LRUNode();
        
        this.tail  = new LRUNode();
        
        this.head.next = this.tail;
        
        this.tail.pre = this.head;
        
        
    }
    
    public int get(int key) {
        
        LRUNode node = cache.get(key);
        
        if (node == null) {
            return -1;
        } else {
            //move to head
            
            moveToHead(node);//dont' forget
            return node.value;
        }
        
    }
    
    public void put(int key, int value) {
        
        LRUNode node = cache.get(key);
        
        if (node == null) {
            
         node  = new LRUNode();
         node.key  = key;
         node.value = value;
         
         //add a node and put it in the cache
         cache.put(key, node );
         addNode(node);//dont' forget  
            
          size++;
          if (size > capacity) {
              
              //pop tail
              LRUNode tail = popTail();
              cache.remove(tail.key);//don't forget
              size--;
              
          }
            
        } else {
            node.value = value;
            moveToHead(node);
        }
        
        
        
    }
    
    //add node to the head right
    
    public void addNode(LRUNode node) {
        
        LRUNode temp = head.next;
        
        node.pre = head;
            
        node.next = temp;
        
        head.next.pre = node;//don't forget
        
        head.next  = node ;
            
     
        
    }
    
    //remove the node
    
    public void removeNode(LRUNode node) {
        
        LRUNode pre = node.pre;
            
        LRUNode next = node.next;
            
        pre.next = next;
            
        next.pre = pre;
    
        
    }
    
    public void moveToHead(LRUNode node){
        
        removeNode(node);
        addNode(node);
    }
    
    public LRUNode popTail() {
        
        LRUNode last = tail.pre;
        
        removeNode(last);
            
        return last;
        
    }
    
   
    
}


/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */