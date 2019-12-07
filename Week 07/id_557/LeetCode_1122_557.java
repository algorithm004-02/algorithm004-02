//给你两个数组，arr1 和 arr2， 
//
// 
// arr2 中的元素各不相同 
// arr2 中的每个元素都出现在 arr1 中 
// 
//
// 对 arr1 中的元素进行排序，使 arr1 中项的相对顺序和 arr2 中的相对顺序相同。未在 arr2 中出现过的元素需要按照升序放在 arr1 的末尾。 
//
// 
//
// 示例： 
//
// 输入：arr1 = [2,3,1,3,2,4,6,7,9,2,19], arr2 = [2,1,4,3,9,6]
//输出：[2,2,2,1,4,3,3,9,6,7,19]
// 
//
// 
//
// 提示： 
//
// 
// arr1.length, arr2.length <= 1000 
// 0 <= arr1[i], arr2[i] <= 1000 
// arr2 中的元素 arr2[i] 各不相同 
// arr2 中的每个元素 arr2[i] 都出现在 arr1 中 
// 
// Related Topics 排序 数组


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] relativeSortArray(int[] arr1, int[] arr2) {

        //使用计数排序
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < arr1.length; i++) {
            if (max < arr1[i]) {
                max = arr1[i];
            }
        }

        int[] bucket = new int[max + 1];

        for (int i = 0; i < arr1.length; i++) {
            if (bucket[arr1[i]] != 0) {
                bucket[arr1[i]]++;
            } else {
                bucket[arr1[i]] = 1;
            }
        }
        int[] ans = new int[arr1.length];
        int pos = 0;
        for (int i = 0; i < arr2.length; i++) {
            while (bucket[arr2[i]] > 0) {
                ans[pos++] = arr2[i];
                bucket[arr2[i]]--;
            }
        }

        for (int i = 0; i < bucket.length; i++) {
            while (bucket[i] > 0) {
                ans[pos++] = i;
                bucket[i]--;
            }
        }
        return ans;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
