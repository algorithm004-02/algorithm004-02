//给定一个字符串数组，将字母异位词组合在一起。字母异位词指字母相同，但排列不同的字符串。

class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for(String str : strs){
            char[] temp = str.toCharArray();
            Arrays.sort(temp);
            String keystr = String.valueOf(temp);
            if(! map.containsKey(keystr))
                map.put(keystr,new ArrayList<String>());
            map.get(keystr).add(str);
        }
        return new ArrayList<>(map.values());
    }
}