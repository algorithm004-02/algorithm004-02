//HashMap<key, array> 循环使用 key 进行 isAnagram 入数组
//HashMap<hashcode, array> 生成基于数组的 hash code, 入数组;
import java.lang.StringBuilder;
import java.util.HashMap;

class Solution {
    private String toAnagramSequense(String s) {
        char[] sc = s.toCharArray();
        Arrays.sort(sc);
        return new String(sc);
    }
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for (String word : strs) {
            String key = toAnagramSequense(word);
            List<String> same = map.get(key);
            if (same == null) {
                same = new ArrayList();
                map.put(key, same);
            }
            same.add(word);
        }
        return new ArrayList(map.values());
    }
}