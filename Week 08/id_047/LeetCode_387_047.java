import java.util.HashMap;
import java.util.Map;

public class LeetCode_387_047 {

    public int firstUniqChar(String s) {

        Map<Character,Integer> char2Num = new HashMap<>();
        for (char c : s.toCharArray()) {
            char2Num.put(c,char2Num.getOrDefault(c,0) + 1);
        }

        for (int i = 0; i < s.length(); i ++) {
            if (char2Num.get(s.charAt(i)) == 1) {
                return i;
            }
        }
        return -1;
    }
}
