class Solution {
    public int minMutation(String start, String end, String[] bank) {
        
        //Check the boundary
        if (start.equals(end)) {
            return 0;
        }
        
        //Initialization
        //Change bank array to set
        Set<String> bankSet = new HashSet();
        for (String s : bank) {
            bankSet.add(s);
        }
        //chaset sets
        char[] charSet = new char[]{'A', 'C', 'G', 'T'};
        
        //Visited set
        Set<String> visited = new HashSet<>();
        visited.add(start);
        
        //Create a queue
        Queue<String> queue = new LinkedList<>();
        queue.offer(start);
        
        int level = 0;
        
        while(!queue.isEmpty()) {
            int size = queue.size();
            
            while(size-- > 0) {
                //Pop the first one
                String current = queue.poll();
                
                if (current.equals(end)) {
                    return level;
                }
                
                char[] charArray = current.toCharArray();
                
                for (int i =0; i < charArray.length; i++) {
                    
                    char tmp = charArray[i];
                    
                    for (char c : charSet) {
                        
                        charArray[i] = c;
                        String gene = new String(charArray);
                            
                        if (!visited.contains(gene) && bankSet.contains(gene)) {
                           visited.add(gene);
                            queue.offer(gene);
                           
                        }
                        
                    }
                    
                    charArray[i] = tmp;
                    
                    
                    
                }
                
                
            }
            
            return level+1;
        }
        
        
    return -1;      
        
        
        
    }
}