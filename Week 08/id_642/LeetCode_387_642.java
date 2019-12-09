package Week8;

/**
 * @Author: xiang1.li
 * @Date: 2019/12/8 16:49
 */
public class L387 {
    public int firstUniqChar(String s) {
      int[] arr = new int[26];
      for (int i = 0; i < s.length(); i++) {
        arr[s.charAt(i) - 'a']++;
      }
      for (int i = 0; i < s.length(); i++) {
        if (arr[s.charAt(i) - 'a'] == 1) {
          return i;
        }
      }
      return -1;
    }
}
