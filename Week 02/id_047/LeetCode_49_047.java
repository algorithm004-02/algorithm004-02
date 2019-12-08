import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
import java.util.Arrays;

public class LeetCode_49_047 {
    public List<List<String>> groupAnagrams(String[] strs) {
        if (strs == null) {
            return new ArrayList<>();
        }

        Map<String,List<String>> result = new HashMap<>();
        for (String str:
                strs) {
            String sorted = str;
            if (str != null) {
                char[] chars = str.toCharArray();
                Arrays.sort(chars);
                sorted = String.valueOf(chars);
            }
            if (result.containsKey(sorted)) {
                result.get(sorted).add(str);
            } else {
                List<String> agroup = new ArrayList<>();
                agroup.add(str);
                result.put(sorted,agroup);
            }
        }
        return new ArrayList<>(result.values());
    }
}