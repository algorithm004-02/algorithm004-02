class Solution {
    public int firstUniqChar(String s) {
        int index = -1;
        HashMap<Integer,Integer> maps = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            int in =s.charAt(i)-'a';
            if(maps.get(in) == null){
                maps.put(in,1);
            }else {
                maps.put(in,maps.get(in)+1);
            }
        }
        for (int i = 0; i < s.length(); i++) {
            int in =s.charAt(i)-'a';
            if(maps.get(in) == 1){
                index =i ;
                break;
            }
        }

        return index;
    }
}