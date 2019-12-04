package Week07.Chapter18.HomeWork;

public class LeetCode_7_1122 {
    // 计数统计
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        int[] cnt = new int[1001];
        for (int n : arr1) cnt[n]++;
        int i = 0;
        for (int n : arr2) {
            while (cnt[n]-- > 0) {
                arr1[i++] = n;
            }
        }
        for (int n = 0; n < cnt.length; n++) {
            while (cnt[n]-- > 0) {
                arr1[i++] = n;
            }
        }
        return arr1;
    }

    public static void main(String[] args) {
        final LeetCode_7_1122 test = new LeetCode_7_1122();
        int[] arr1 = new int[]{2, 3, 1, 3, 2, 4, 6, 7, 9, 2, 19};
        int[] arr2 = new int[]{2, 1, 4, 3, 9, 6};
        final int[] ints = test.relativeSortArray(arr1, arr2);
        System.out.printf("[");
        for (int i : ints) {
            System.out.printf("%d,", i);
        }
        System.out.printf("]");
    }
}
