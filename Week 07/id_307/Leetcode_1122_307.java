class Solution {
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        int[] bucket = new int[1001];
        for (int i = 0; i < arr1.length; i++) {
            bucket[arr1[i]]++;
        }
        int pos = 0;
        for (int i = 0; i < arr2.length; i++) {
            int times = bucket[arr2[i]];
            for (int j = 0; j < times; j++) {
                arr1[pos++] = arr2[i];
            }
            bucket[arr2[i]] = 0;
        }
        for (int i = 0; i < bucket.length; i++) {
            for (int j = 0; j < bucket[i]; j++) {
                arr1[pos++] = i;
            }
            bucket[i] = 0;
        }
        return arr1;
    }
}