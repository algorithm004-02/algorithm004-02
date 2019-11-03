import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> hash = new HashMap<>();
        for (int i = 0; i < strs.length; i++) {
            char[] arr = strs[i].toCharArray();
            Arrays.sort(arr);
            String key = String.valueOf(arr);
            if (hash.containsKey(key)) {
                hash.get(key).add(strs[i]);
            } else {
                // 字符串第一次出现时进入该分支,-->["eat",["eat"]]
                List<String> temp = new ArrayList<String>();
                temp.add(strs[i]);
                //System.out.println(strs[i]+"..."+temp);
                hash.put(key, temp);
            }
        }
        return new ArrayList<List<String>>(hash.values());
    }
}
