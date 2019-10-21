/*
  # 26 删除排序数组中的重复项

  给定一个排序数组，在`原地`删除数组中的重复项
 */

/// 使用快慢指针
/// 快指针j在数组中找与i不同的元素，发现了不同的元素之后，
/// i向后移动一位，并将其值设为j指向的值。以此类推
class Solution {
    /// - Complexity: O(n) 
    func removeDuplicates(_ nums: inout [Int]) -> Int {
        if nums.isEmpty { return 0 }
        var i = 0
        for j in 1..<nums.count {
            if nums[i] != nums[j] {
                i += 1
                nums[i] = nums[j]
            }
        }
        return i + 1
    }
}
