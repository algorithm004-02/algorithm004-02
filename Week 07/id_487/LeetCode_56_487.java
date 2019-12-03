class LeetCode_56_487 {


    /**
     * 56. 合并区间
     *
     * @param intervals
     * @return
     */
    public int[][] merge(int[][] intervals) {
        List<int[]> res = new ArrayList<>();
        if (intervals == null || intervals.length == 0) return res.toArray(new int[0][]);

        //排序     a[0] - b[0]大于0就交换顺序
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);

        //基数下标
        int index = 0;
        while (index < intervals.length) {
            //记录当前index的左右区间值大小
            int left = intervals[index][0];
            int right = intervals[index][1];
            //判断当前index的区间right和下一个index区间的left大小
            while (index < intervals.length - 1 && right >= intervals[index + 1][0]) {
                right = Math.max(right, intervals[index + 1][1]); //比较当前区间right和下一个区间的right大小
                index++;
            }
            res.add(new int[]{left, right});
            index++;
        }
        return res.toArray(new int[0][]);
    }

}