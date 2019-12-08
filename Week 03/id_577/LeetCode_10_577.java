class Solution {
    
    /*public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        //change word list to set
        Set<String> dict = new HashSet(wordList);
        
        //Mark visited as set
        Set<String> visited = new HashSet<String>();//This will save time
        
        
        Queue<String> queue = new LinkedList<String>();
        queue.add(beginWord);
        queue.add(null);
        
        int level = 1;
        
        while(!queue.isEmpty()) {
            String s = queue.poll();
            
            if (s != null) {
                
                for (int i = 0; i < s.length(); i++) {
                    
                    char[] charArray  = s.toCharArray();
                    
                    for (char c = 'a'; c <= 'z'; c++) {
                        charArray[i] = c;
                        
                        //Current word
                        
                        String current = new String(charArray);
                            
                        if (dict.contains(current) && current.equals(endWord)) {
                            return level+1;
                        }
                        
                        if (dict.contains(current) && !visited.contains(current)) {
                            queue.add(current);
                            
                            visited.add(current);
                        }
                    }
                    
                    
                }
               
            } else {
                level++;
                
                if (!queue.isEmpty()) { 
                    queue.add(null);
                 }
            }
            
            
            
            
            
        }
        
        
        
        return 0;
        
    }*/
    
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> dict = new HashSet<>(wordList);
        Queue<String> queue = new LinkedList<>();
        queue.add(beginWord);
        int level = 1;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int q=0; q < size; q++) {
                String current =  queue.poll();
                
                if (current.equals(endWord)) {
                    return level;//save time
                }
                
                
                char[] cur =current.toCharArray();
                for (int i=0; i < cur.length; i++) {
                    char tmp = cur[i];
                    for (char chr='a'; chr <= 'z'; chr++) {
                        cur[i] = chr;
                        String dest = new String(cur);
                        if (dict.contains(dest)) {
                            if (dest.equals(endWord)) return level+1;
                            queue.add(dest);
                            dict.remove(dest);
                        }
                    }
                    cur[i] = tmp;//recover it 
                }
            }
            level++;
        }
        return 0;
    }
}