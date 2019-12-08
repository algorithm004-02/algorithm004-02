class Solution {
    func search(_ nums: [Int], _ target: Int) -> Int {
        var left = 0
        var right = nums.count - 1
        while left <= right {
            let mid = (left + right) / 2

            if nums[mid] == target { return mid }

            if nums[left] <= nums[mid] {
                if target >= nums[left] && target < nums[mid] {
                    right = mid - 1
                } else {
                    left = mid + 1
                }
            } else {
                if target > nums[mid] && target <= nums[right] {
                    if target > nums[mid] && target < nums[right] {
                        left = mid + 1
                    } else {
                        right = mid - 1
                    }
                }
            }
        }
        return -1
    }
}

assert(Solution().search([4,5,6,7,0,1,2], 0) == 4)
assert(Solution().search([4,5,6,7,0,1,2], 3) == -1)
