package week3.second;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @Author: xiang1.li
 * @Date: 2019/11/2 12:12
 *
 */
public class L22 {

  /**
   * 括号生成问题，生成满足要求的n对括号的组合.
   *
   * 解法1，暴力法
   * 解法2，深度优先遍历，回溯
   * 解法3，广度优先遍历
   * */

  /**
   * 解法1、暴力法
   * 1、每个位置可以时左括号，也可以是右括号，两种选择，排列组合一共有 2 ^ 2n 种.
   * 2、每一层选一种括号，下一层再选一个，选到2n层停止。
   * 3、判断停止的组合是否满足要求.
   * */
  public List<String> generateParenthesis(int n) {
    List<String> resultList = new ArrayList<>();
    generate("", 0, n * 2, resultList);
    return resultList;
  }


  private void generate(String s, int height, int num, List<String> resultList) {
    if (height >= num) {
      if (isBalance(s)) {
        resultList.add(s);
      }
      return;
    }
    generate(s + "(", height + 1, num, resultList);
    generate(s + ")", height + 1, num, resultList);
  }

  /**
   * 是满足要求的括号组合.
   * */
  private boolean isBalance(String str) {
    int balance = 0;
    for (int i = 0; i < str.length(); i++) {
      char ch = str.charAt(i);
      if (ch == '(') {
        balance++;
      } else {
        balance--;
      }
      if (balance < 0) {
        return false;
      }
    }
    return balance == 0 ? true : false;
  }

  /**
   * 解法2，深度优先遍历，回溯.
   * 1、如果左括号的个数小于n，可以添加左括号.
   * 2、如果右括号的数量小于左括号数量，可以添加右括号.
   * 3、字符串长度到达 2 * n，就是满足的字符串.
   * */

  public List<String> generateParenthesis2(int n) {
    List<String> resultList = new ArrayList<>();
    dfs("", n, 0, 0, resultList);
    return resultList;
  }

  private void dfs(String str, int n, int leftCount, int rightCount, List<String> resultList) {
    if (str.length() >= n * 2) {
      resultList.add(str);
      return;
    }

    if (leftCount < n) {
      dfs(str + "(", n, leftCount + 1, rightCount, resultList);
    }
    if (rightCount < leftCount) {
      dfs(str + ")", n, leftCount, rightCount + 1, resultList);
    }
  }

  /**
   * 解法3，广度优先遍历.
   * 1、每一层把还有可能满足最终结果的添加到queue, 到第2n层结束.
   * */
  public List<String> generateParenthesis3(int n) {
    List<String> resultList = new ArrayList<>();
    String[] selectArray = {"(", ")"};
    String str = "";
    Queue<String> queue = new LinkedList<>();
    queue.offer(str);
    while (!queue.isEmpty()) {
      str = queue.poll();
      if (str.length() >= n * 2) {
        resultList.add(str);
      } else {
        for (int i = 0; i < selectArray.length; i++) {
          String newStr = str + selectArray[i];
          if (isPossible(newStr, n)) {
            queue.offer(newStr);
          }
        }
      }
    }
    return resultList;
  }

  /**
   * 加完括号是否是平衡，或者有平衡的可能.
   * */
  private boolean isPossible(String str, int n) {
    int balance = 0;
    for (int i = 0; i < str.length(); i++) {
      char ch = str.charAt(i);
      if (ch == '(') {
        balance++;
      } else {
        balance--;
      }
      if (balance < 0) {
        return false;
      }
    }
    if (balance > n) {
      return false;
    }
    /** 已经是 n * 2 长度了，不平衡就没平衡的可能了 */
    if (balance > 0 && str.length() >= n * 2) {
      return false;
    }
    return true;
  }

  public static void main(String[] args) {
    L22 l22 = new L22();
    System.out.println(l22.generateParenthesis3(3));
  }

}
