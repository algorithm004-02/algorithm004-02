package week3.work;

/**
 * @Author: xiang1.li
 * @Date: 2019/10/30 07:33
 *
 * https://leetcode-cn.com/problems/lemonade-change/submissions/
 */
public class L860 {

  /**
   * first commit
   * */
  public boolean lemonadeChange(int[] bills) {
    int[] baseArray = {0, 0};
    for (int i = 0; i < bills.length; i++) {
      if (bills[i] == 5) {
        baseArray[0]++;
      }
      if (bills[i] == 10) {
        if (baseArray[0] <= 0 ){
          return false;
        }
        baseArray[0]--;
        baseArray[1]++;
      }
      if  (bills[i] == 20) {
        if (baseArray[1] > 0 && baseArray[0] > 0) {
          baseArray[0]--;
          baseArray[1]--;
        } else if (baseArray[0] >= 3) {
          baseArray[0] -= 3;
        } else {
          return false;
        }
      }

    }
    return true;
  }
}
