import java.util.Arrays;

public class LeetCode_1122_677 {

    public static void main(String[] args) {
        int[] arr1 = {2,3,1,3,2,4,6,7,9,2,19}, arr2 = {2,1,4,3,9,6};
        ISolution s1 = new Solution1();
        int[] ans = s1.relativeSortArray(arr1, arr2);
        System.out.println(Arrays.toString(ans));
    }
}

interface ISolution {
    int[] relativeSortArray(int[] arr1, int[] arr2);
}

/**
 * Bucket Sort
 */
class Solution1 implements ISolution {
    @Override
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        if (arr1 == null || arr1.length == 0) return arr1;

        // allocate space
        int[] bucket = new int[1_001];
        // process arr1
        for (int i = 0; i < arr1.length; i++) {
            bucket[arr1[i]] += 1;
        }
        // follow arr2's order
        int cnt = 0;
        if (arr2 != null) {
            for (int i = 0; i < arr2.length; i++) {
                int target = arr2[i];
                while (bucket[target] > 0) {
                    arr1[cnt++] = target;
                    bucket[target]--;
                }
            }
        }

        // the left order
        for (int i = 0; i < bucket.length; i++) {
            while (bucket[i] > 0) {
                arr1[cnt++] = i;
                bucket[i]--;
            }
        }

        return arr1;
    }
}
