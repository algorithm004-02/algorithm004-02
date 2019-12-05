public class LRUCache extends LinkedHashMap<Integer,Integer>{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int capacity;
	public LRUCache(int capacity) {
        super(capacity, 0.75F, true); 
        this.capacity = capacity;
    }
    
    public int get(int key) {
		return (Integer) super.getOrDefault(key, -1);
        
    }
    
    public void put(int key, int value) {
    	super.put(key, value);
    }
    @Override
    protected boolean removeEldestEntry(Map.Entry<Integer, Integer> eldest) {
        return size() > capacity; 
    }

}