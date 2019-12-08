class Solution {
    public int[] countBits(int num) {
        int[] results = new int[num + 1];
        for (int i = 1; i <= num; i++) {
            results[i] = results[i & (i - 1)] + 1;
        }
        return results;
    }
}