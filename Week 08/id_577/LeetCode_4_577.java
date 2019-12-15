class Solution {
    public int firstUniqChar(String s) {
        
        //check boundary 
        
        int n = s.length();
        
        if (n == 0 ){
            return -1;
        }
        
       int[] letters = new int[26];
        
       for (char c : s.toCharArray()) {
           letters[c - 'a']++;
       }
        
       for (int index = 0; index < n; index ++) {
           if ( letters[(s.charAt(index) - 'a')] == 1 ) {
               return index;
           }
           
       }
        
        return -1;


        
    }
}