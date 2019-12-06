class Solution {
    class IntervalComparator implements Comparator<int[]> {
        @Override
        public int compare(int[] a, int[] b) {
            return a[0] < b[0] ? -1 : a[0] == b[0] ? 0 : 1;
        }
    }
    public int[][] merge(int[][] intervals) {
        List<int[]> results = new ArrayList<>();
        Map<Integer, Boolean> deleted = new HashMap<>();
        Arrays.sort(intervals, new IntervalComparator());
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i - 1][0] <= intervals[i][0] && intervals[i][0] <= intervals[i - 1][1]) {
                intervals[i][0] = intervals[i - 1][0];
                intervals[i][1] = Math.max(intervals[i - 1][1], intervals[i][1]);
                deleted.put(i - 1, false);
            }
        }
        for (int i = 0; i < intervals.length; i++) {
            if (!deleted.containsKey(i))
                results.add(intervals[i]);
        }
        return results.toArray(new int[results.size()][2]);
    }
}