class Solution {
    public String toLowerCase(String str) {
        char [] cc = str.toCharArray();
        String s = "";
        for(int i = 0; i < cc.length ; i++){
            if(cc[i] <= 'Z' && cc[i] >= 'A'){
                cc[i] = (char) (cc[i] -'A' +'a');
                
            }
            s += cc[i];
            //cc[i] += 1;
            //System.out.print(cc[i]);}
        
    }
    return s;
}
}