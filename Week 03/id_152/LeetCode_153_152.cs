public class Solution {
    public int FindMin(int[] nums) {
        
     /*test cases: [3, 1]
                   [],
                   [1],
                   [3, 4, 1, 2]
     */
        if (nums == null) return -1;
        
        int left = 0, right = nums.Length - 1;
        while (left <= right)
        {
            int mid = left + (right - left) / 2;
            // test case: [1]
            if((mid - 1) < 0 && (mid + 1) >= nums.Length)
            {
                return nums[mid];
            }
            //test case: [1, 3]
            else if ((mid - 1) < 0 && nums[mid] < nums[mid + 1])
            {
                return nums[mid];
            }
            //test case: [3,4,0]
            else if ((mid + 1) >= nums.Length && nums[mid] < nums[mid - 1])
            {
                return nums[mid];
            }
            else if ((mid - 1) >= 0 && 
                     (mid + 1) < nums.Length &&
                      nums[mid] < nums[mid - 1] &&  
                      nums[mid] < nums[mid + 1])
            {
                return nums[mid];
            }
            else if(nums[mid] >= nums[0])
            {
                // go right
                left = mid + 1;
            }
            else
            {
                right = mid - 1;
            } 
        }
        
        return nums[0];
    }
}