class Solution {
    public boolean isMatch(String s, String p) {
        int sn = s.length();
        int pn = p.length();
        int i = 0;
        int j = 0;
        int start = -1;
        int match = 0;
        
        while (i < sn) 
        {
            if (j < pn && (s.charAt(i) == p.charAt(j) || p.charAt(j) == '?')) 
            {
                i++;
                j++;
            } 
            else if (j < pn && p.charAt(j) == '*') 
            {
                start = j;
                match = i;
                j++;
            } 
            else if (start != -1) 
            {
                j = start + 1;
                i = ++match;
            } 
            else 
            {
                return false;
            }
        }
        
        while (j < pn) 
        {
            if (p.charAt(j) != '*') 
            	return false;
            j++;
        }
        return true;
    }
}