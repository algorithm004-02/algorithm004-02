import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        if (strs.length == 0 || strs == null) {
            return new ArrayList<List<String>>();
        }
        Map<String, List<String>> map = new HashMap<>();
        for (String s: strs) {
            char[] str = s.toCharArray();
            Arrays.sort(str);
            
            String tmp = String.valueOf(str);
            if (!map.containsKey(tmp)) {
                map.put(tmp, new ArrayList<String>());
            }
            map.get(tmp).add(s);
        }
        return new ArrayList<List<String>>(map.values());
    }
}