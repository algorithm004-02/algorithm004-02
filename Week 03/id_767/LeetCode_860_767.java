package algorithm.LeetCode;

import java.util.Scanner;

/**
 * describe:
 * 在柠檬水摊上，每一杯柠檬水的售价为 5 美元。
 * 顾客排队购买你的产品，（按账单 bills 支付的顺序）一次购买一杯。
 * 每位顾客只买一杯柠檬水，然后向你付 5 美元、10 美元或 20 美元。你必须给每个顾客正确找零，也就是说净交易是每位顾客向你支付 5 美元。
 *
 * 注意，一开始你手头没有任何零钱。
 * 如果你能给每位顾客正确找零，返回 true ，否则返回 false 。
 *
 * 示例 1：
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/lemonade-change
 *
 * @author lixilong
 * @date 2019/01/25
 */
public class _860_lemonadeChange {

  //方法1： 直接分析，逻辑上覆盖更严谨： 优先花费最大面值的钱
  public boolean lemonadeChange(int[] bills) {
    int five = 0, ten = 0;
    for (int i = 0; i < bills.length; i++) {
      if (bills[i] == 5) {
        five++;
      } else if (bills[i] == 10) {
        if (five < 1) {
          return false; //先判断return条件
        }
        five--;
        ten++;
      } else {
        if (ten > 0 && five > 0) {
          ten--;
          five--;
        } else if (five > 2) {  //保护判断
          five -= 3;
        } else {
          return false;
        }
      }
    }
    return true;
  }

}
