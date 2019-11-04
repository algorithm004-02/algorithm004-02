import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 * 字母异位词分组
 * Created by yangwenwei on 2019/10/22.
 */
public class LeetCode_49_597 {
    class Solution {
        public List<List<String>> groupAnagrams(String[] strs) {
            Map<String, List<String>> map = new HashMap<>();
            for (String str : strs) {
                char[] strA = str.toCharArray();
                Arrays.sort(strA);
                String key = String.valueOf(strA);
                //看了官方题解后优化简短了下我原有代码, 基本思想一致
                if (!map.containsKey(key)) {
                    map.put(key, new ArrayList<>());
                }
                map.get(key).add(str);
            }
            return new ArrayList<>(map.values());
        }

    }

}
