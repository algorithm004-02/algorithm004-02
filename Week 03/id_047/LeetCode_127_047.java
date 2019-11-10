import java.util.Deque;
import java.util.List;
import java.util.LinkedList;
import java.util.Set;
import java.util.HashSet;

public class LeetCode_127_047 {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Deque<String> queue = new LinkedList<>();
        Set<String> visited = new HashSet<>();
        Set<String> wordSet = new HashSet<>(wordList);
        queue.add(beginWord);
        visited.add(beginWord);
        int level = 0;
        while (!queue.isEmpty()) {
            level ++;
            int size = queue.size();
            while (size-- > 0) {
                String curr = queue.removeFirst();
                if (curr.equals(endWord)) {
                    return level;
                }
                char[] chars = curr.toCharArray();
                for (int i = 0; i < chars.length; i++) {
                    char old = chars[i];
                    for (byte j = 0; j < 26; j++) {
                        chars[i] = (char) ('a' + j);
                        String newStr = new String(chars);
                        if (!visited.contains(newStr) && wordSet.contains(newStr)) {
                            visited.add(newStr);
                            queue.add(newStr);
                        }
                    }
                    chars[i] = old;
                }
            }
        }
        return 0;
    }
}
