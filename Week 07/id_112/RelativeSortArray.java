package datastruct.sort;

/**
 * 1122. 数组的相对排序
 *
 *
 * 给你两个数组，arr1 和 arr2，
 arr2 中的元素各不相同
 arr2 中的每个元素都出现在 arr1 中
 对 arr1 中的元素进行排序，
 使 arr1 中项的相对顺序和 arr2 中的相对顺序相同。
 未在 arr2 中出现过的元素需要按照升序放在 arr1 的末尾。

 示例：
 输入：arr1 = [2,3,1,3,2,4,6,7,9,2,19], arr2 = [2,1,4,3,9,6]
 输出：[2,2,2,1,4,3,3,9,6,7,19]
  

 提示：
 arr1.length, arr2.length <= 1000
 0 <= arr1[i], arr2[i] <= 1000
 arr2 中的元素 arr2[i] 各不相同
 arr2 中的每个元素 arr2[i] 都出现在 arr1 中
 https://leetcode-cn.com/problems/relative-sort-array/submissions/
 *
 */
public class RelativeSortArray {

    /**
     * 计算排序
     *
     */
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        int[] cnt = new int[1001];
        for (int n : arr1) cnt[n]++;
        int i = 0;

        for (int n : arr2) {
            while (cnt[n]-- > 0) {
                arr1[i++] = n;
            }
        }

        for (int n = 0; n < cnt.length;n++) {
            while(cnt[n]-- > 0) {
                arr1[i++] = n;
            }
        }
        return arr1;
    }

}
