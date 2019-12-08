class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        //Initialize
        int length = 1;
        
        Set<String> wordsset = new HashSet<String>(wordList);
        
        Set<String> beginset = new HashSet();
        
        Set<String> endset = new HashSet();
        
        Set<String> visited = new HashSet();
            
        beginset.add(beginWord);
        endset.add(endWord);
        
         
        
        while( !beginset.isEmpty()  && !endset.isEmpty() ){
            
            if (beginset.size() > endset.size()) {
                //swap endset with begin set
                
                Set<String>  temp = beginset;
                
                beginset = endset;
                
                endset = temp;
            }
            
            Set<String>  temp = new HashSet();
            
            for  (String words :  beginset) {
                
                char[] word = words.toCharArray();
                
                for (int i = 0; i< word.length; i++) {
                    for (char c = 'a'; c<= 'z'; c++ ) {
                        
                        char old =  word[i];
                        
                        word[i]  = c;
                            
                        String newword = String.valueOf(word);
                        
                        if (endset.contains(newword)){
                            
                            return length+1;//don't write it to lenght++
                            
                        }
                        
                        if (!visited.contains(newword) && wordsset.contains(newword)){
                            visited.add(newword);
                            temp.add(newword);
                            
                        }
                        
                        word[i] = old;
                        
                        
                    }
                }
            }
            
           beginset=temp;
            
           length++;
        
            
        }
    return 0;
        
    }
    
    
}