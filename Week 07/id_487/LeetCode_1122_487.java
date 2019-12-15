class LeetCode_1122_487 {


    /**
     * 题目：1122 数组的相对排序
     * <p>
     * 计数排序
     *
     * @param arr1
     * @param arr2
     * @return
     */
    public int[] relativeSortArray(int[] arr1, int[] arr2) {

        int[] arr = new int[1001];      //所有桶的基数
        int[] res = new int[arr1.length];

        //把所有arr1的数据存到桶里
        for (int i = 0; i < arr1.length; i++) {
            arr[arr1[i]]++;
        }

        //遍历arr2，从桶里开始取arr2有的数据，并记录已经达到的下标index
        int index = 0;
        for (int i = 0; i < arr2.length; i++) {
            while (arr[arr2[i]] > 0) {
                res[index++] = arr2[i];
                arr[arr2[i]]--;
            }
        }

        //遍历所有桶，把剩下的数据数据，按照桶的数据取出来，接到下标index后
        for (int i = 0; i < arr.length; i++) {
            while (arr[i] > 0) {
                res[index++] = i;
                arr[i]--;
            }
        }

        return res;
    }

}