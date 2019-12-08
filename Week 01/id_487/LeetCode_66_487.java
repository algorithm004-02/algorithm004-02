class LeetCode_66_487{

    /***
     * 66题
     *
     * 给定一个由整数组成的非空数组所表示的非负整数，在该数的基础上加一。
     * 最高位数字存放在数组的首位， 数组中每个元素只存储单个数字。
     * 你可以假设除了整数 0 之外，这个整数不会以零开头。
     *
     * @param a
     * @return
     */
    public static int[] plusOne(int[] a) {
        int length = a.length;
        for (int i = length - 1; i >= 0; i--) {
            if (a[i] < 9) {
                a[i]++;
                return a;
            }
            a[i] = 0;
        }
        //增加一位(新增加的那位默认0)
        a = new int[length + 1];
        //高位设置为1
        a[0] = 1;
        return a;
    }

}