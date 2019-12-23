给出一个区间的集合，请合并所有重叠的区间。
示例 1:
输入: [[1,3],[2,6],[8,10],[15,18]]
输出: [[1,6],[8,10],[15,18]]
解释: 区间 [1,3] 和 [2,6] 重叠, 将它们合并为 [1,6].
示例 2:
输入: [[1,4],[4,5]]
输出: [[1,5]]
解释: 区间 [1,4] 和 [4,5] 可被视为重叠区间。

暴力解法：：对两两区间进行比较，知道他们是否重合
最坏情况下每个区间都是相互重合的，所以两两区间都会有一条边，所以内存占用量是输入大小的平方级别

排序法：：
先区间大小排序，然后将第一个区间插入数组里面，按顺序考虑之后的每个区间：
    如果当前区间的左端点在前一个区间的右端点之后，不重合，直接将区间插入 merged 中；
    否则重合，当前区间的右端点更新前一个区间的右端点 end 如果前者数值比后者大的话。
    class Solution {
        private static class Interval {
            int start;
            int end;
            Interval(int[] interval) {
                this.start = interval[0];
                this.end = interval[1];
            }
    
            int[] toArray() {
                return new int[]{this.start, this.end};
            }
        }
        private static class IntervalComparator implements Comparator<Interval> {
    
            @Override
            public int compare(Interval a, Interval b) {
                return Integer.compare(a.start, b.start);
            }
        }
    
        public int[][] merge(int[][] intervals) {
            List<Interval> intervalsList = new LinkedList<>();
            for (int[] interval : intervals) {
                intervalsList.add(new Interval(interval));
            }
            intervalsList.sort(new IntervalComparator());
    
            LinkedList<Interval> merged = new LinkedList<>();
            for (Interval interval : intervalsList) {
                // 无重合或为空
                if (merged.isEmpty() || merged.getLast().end < interval.start) {
                    merged.add(interval);
                }
                // 有重合的情况
                else {
                    merged.getLast().end = Math.max(merged.getLast().end, interval.end);
                }
            }
    
            int i = 0;
            int[][] result = new int[merged.size()][2];
            for (Interval mergedInterval : merged) {
                result[i] = mergedInterval.toArray();
                i++;
            }
            return result;
        }
    }