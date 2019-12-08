/**
 * 56：合并区间
 */
class Solution {
    public int[][] merge(int[][] intervals) {
        if (intervals.length <= 1) {
            return intervals;
        }
        //按照区间的末位从小到大排序区间
        quickSort(intervals,0,intervals.length - 1);
        Stack<int[]> stack = new Stack<>();
        stack.push(intervals[0]);
        for(int i = 1; i < intervals.length; i++){
            int[] pre = stack.peek();
            if (pre[1] < intervals[i][0]) {
                stack.push(intervals[i]);
            }else {
                int[] temp = new int[2];
                temp[0] = Math.min(pre[0],intervals[i][0]);
                temp[1] = Math.max(pre[1],intervals[i][1]);
                while (pre != null && pre[1] >= temp[0]) {
                    temp[0] = Math.min(pre[0],temp[0]);
                    temp[1] = Math.max(pre[1],temp[1]);
                    stack.pop();
                    if (!stack.isEmpty()){
                        pre = stack.peek();
                    }else {
                        pre = null;
                    }
                }
                stack.push(temp);
            }
        }
        return stack.toArray(new int[][]{});
    }

    private void quickSort(int[][] intervals, int begin, int end) {
        if (begin >= end) {
            return;
        }
        int povit = partion(intervals,begin,end);
        quickSort(intervals,begin,povit - 1);
        quickSort(intervals,povit + 1,end);
    }

    private int partion(int[][] intervals, int begin, int end) {
        int povit = end,beginIndex = begin;
        for (int i = begin; i < end; i++) {
            if (intervals[i][1] <= intervals[povit][1]) {
                int[] temp = intervals[beginIndex];
                intervals[beginIndex++] = intervals[i];
                intervals[i] = temp;
            }
        }
        int[] temp = intervals[beginIndex];
        intervals[beginIndex] = intervals[povit];
        intervals[povit] = temp;
        return beginIndex;
    }
}