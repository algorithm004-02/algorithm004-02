/**
    169. 求众数
    方法一：1.loop数组， Map计数  2.loop Map 找出 出现次数大于nums.length/2的元素
    方法二：分治 
*/
class Solution {
//     public int majorityElement(int[] nums) {
//         int numP = nums.length/2;
//         int numRes = 0;
//         Map<Integer, Integer> counts = countNums(nums);
//         for (Map.Entry<Integer, Integer> entry : counts.entrySet()) {
//             if (entry.getValue() > numP) {
//                 numRes = entry.getKey();
//             }
//         }
//         return numRes;
//     }
    
//     private Map<Integer, Integer> countNums(int[] nums) {
//         Map<Integer, Integer> counts = new HashMap<Integer, Integer>();
//         for (int num : nums) {
//             if (!counts.containsKey(num)) {
//                 counts.put(num, 1);
//             } else {
//                 counts.put(num, counts.get(num)+1);
//             }
//         }
//         return counts;
//     }
    
    public int majorityElement(int[] nums) {
        return majorityElementec(nums, 0, nums.length-1);
    }
    
    private int countInRange(int[] nums, int num, int lo, int hi) {
        int count = 0;
        for (int i = lo; i <= hi; i++) {
            if (nums[i] == num) {
                count++;
            }
        }
        return count;
    }
    
    private int majorityElementec(int[] nums, int lo, int hi) {
        
        if (lo == hi) {
            return nums[lo];
        }

        int mid = (hi-lo)/2 + lo;
        int left = majorityElementec(nums, lo, mid);
        int right = majorityElementec(nums, mid+1, hi);

        if (left == right) {
            return left;
        }

        // otherwise, count each element and return the "winner".
        int leftCount = countInRange(nums, left, lo, hi);
        int rightCount = countInRange(nums, right, lo, hi);

        return leftCount > rightCount ? left : right;
    }

}