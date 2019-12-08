class Solution {
    public int[][] merge(int[][] intervals) {
        List<int[]> res = new ArrayList<>();
        if (intervals == null || intervals.length == 0)
            return res.toArray(new int[0][]);
        
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                // TODO Auto-generated method stub
                return o1[0] - o2[0];
            }
        });
        
        int i = 0;
        while (i < intervals.length) {
            int left = intervals[i][0];
            int right = intervals[i][1];
            while (i < intervals.length - 1 && right >= intervals[i + 1][0]) {
                i++;
                right = Math.max(right, intervals[i][1]);
            }
            res.add(new int[] { left, right });
            i++;
        }
        return res.toArray(new int[0][]);
    }
}