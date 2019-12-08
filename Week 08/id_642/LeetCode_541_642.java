package Week8;

/**
 * @Author: xiang1.li
 * @Date: 2019/12/8 17:10
 *
 */
public class L541 {
  public String reverseStr(String s, int k) {
    char[] chars = s.toCharArray();
    int len = chars.length;
    for (int i = 0; i < len; i += 2 * k) {
      reverse(chars, i , i + 2 * k - 1, len - 1, k);
    }
    return String.valueOf(chars);
  }

  private void reverse(char[] chars, int begin, int end, int lastIndex, int k) {
    if (begin > lastIndex) {
      return;
    }
    if (end <= lastIndex) {
      // 满足2k个字符
      swap(chars, begin, begin + k - 1);
    } else {
      // 区间小于2k个字符
      if ((begin + k - 1) <= lastIndex) {
        swap(chars, begin, begin + k - 1);
      } else {
        swap(chars, begin, lastIndex);
      }
    }
  }

  private void swap(char[] chars, int begin, int end) {
    for (int i = begin, j = end; i < j; i++, j--) {
      char tmp = chars[i];
      chars[i] = chars[j];
      chars[j] = tmp;
    }
  }

  public static void main(String[] args) {
    String s = "abcdefg";
    L541 l541 = new L541();
    System.out.println(l541.reverseStr(s, 2));
  }

}
