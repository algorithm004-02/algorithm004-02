package leetcode.editor.cn;

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
public class LeetCode_1122_537 {

    public static void main(String[] args) {
        Solution solution = new LeetCode_1122_537().new Solution();
    }

    private

//leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        public int[] relativeSortArray(int[] arr1, int[] arr2) {

            //题解后，运用题中1000的限制
            int[] temp = new int[1001];
            for (int i = 0; i < arr1.length; i++)
                temp[arr1[i]]++;
            int k = 0;
            for (int i = 0; i < arr2.length; i++) {
                while (temp[arr2[i]]-- > 0)
                    arr1[k++] = arr2[i];
            }
            for (int i = 0; i < 1001; i++) {
                while (temp[i]-- > 0)
                    arr1[k++] = i;
            }
            return arr1;


            //个人解法
//        if (arr2 == null || arr2.length == 0) {
//            Arrays.sort(arr1);
//            return arr1;
//        }
//        HashMap<Integer, Integer> map = new HashMap<>();
//        for (int i = 0; i < arr2.length; i++) {
//            map.put(arr2[i], 0);
//        }
//        int[] temp = new int[arr1.length - arr2.length];
//        int k = 0;
//        for (int i = 0; i < arr1.length; i++) {
//            if (map.containsKey(arr1[i])) {
//                map.put(arr1[i], map.get(arr1[i]) + 1);
//            }else{
//                temp[k++] = arr1[i];
//            }
//        }
//        if (k>0)
//        Arrays.sort(temp,0,k);
//        int m = 0;
//        for (int i = 0; i < arr2.length; i++) {
//            while (map.get(arr2[i]) > 0) {
//                arr1[m++] = arr2[i];
//                map.put(arr2[i], map.get(arr2[i]) - 1);
//            }
//        }
//        for (int i = m; i < arr1.length; i++) {
//            arr1[i] = temp[i-m];
//        }
//        return arr1;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}