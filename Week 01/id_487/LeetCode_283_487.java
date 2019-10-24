class LeetCode_283_487{


     /***
     * 283题
     *
     * 给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
     *
     * @param a
     */
    public static void moveZeroes(int[] a) {
        int i = 0;
        for (int j = 0; j < a.length; j++) {
            if (a[j] != 0) {
                a[i] = a[j];
                i++;
            }
        }
        //补0
        for (int j = i; j < a.length; j++) {
            a[j] = 0;
        }
    }

}