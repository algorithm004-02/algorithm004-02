package Week7;

/**
 * @Author: xiang1.li
 * @Date: 2019/12/3 23:27
 */
public class L1122 {
  /**
   * 计数排序
   * */
  public int[] relativeSortArray(int[] arr1, int[] arr2) {
    int[] resArr = new int[arr1.length];
    int[] counterArr = new int[1001];
    for (int i = 0; i < arr1.length; i++) {
      counterArr[arr1[i]] += 1;
    }
    int k = 0;
    for (int i = 0; i < arr2.length; i++) {
      while (counterArr[arr2[i]] > 0) {
        resArr[k++] = arr2[i];
        counterArr[arr2[i]] -= 1;
      }
    }
    for (int i = 0; i < counterArr.length; i++) {
      while (counterArr[i] > 0) {
        resArr[k++] = i;
        counterArr[i] -= 1;
      }
    }
    return resArr;
  }
}
