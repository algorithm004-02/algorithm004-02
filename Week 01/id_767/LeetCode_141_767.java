package algorithm.LeetCode;

import algorithm.util.ListNode;
import java.util.HashSet;
import java.util.Set;

/**
 * describe:
 * 212. 单词搜索 II : https://leetcode-cn.com/problems/word-search-ii/
 *
 *
 * 给定一个二维网格 board 和一个字典中的单词列表 words，找出所有同时在二维网格和字典中出现的单词。
 *
 * 单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。
 * 同一个单元格内的字母在一个单词中不允许被重复使用。
 *
 * @author lixilong
 * @date 2019/10/19
 */
public class _141_HasCycle {

  //方法1：硬做，遍历找null指针  [超时]
  public boolean hasCycle(ListNode head) {
    while (head != null && head.next != null) {
      if (head == null) return true;
      head = head.next;
    }
    return false;
  }

  //方法2：使用set直接判重
  public boolean hasCycle1(ListNode head) {
    Set nodeSet = new HashSet();
    while (head != null && head.next != null) {
      nodeSet.add(head);
      if (nodeSet.contains(head)) {
        return true;
      }
      head = head.next;
    }
    return false;
  }

  //方法3：龟兔赛跑式【快慢指针】
  public boolean hasCycle2(ListNode head) {
    ListNode fast = head, slow = head;
    while (slow != null && fast.next != null) {
      fast = fast.next.next;
      slow = slow.next;
      if (slow == fast) {
        return true;
      }
    }
    return false;
  }


}
