class Solution:
    """
    整体思路：先用二分法找出最小值，也是那个分割点,例如 [4,5,6,7,0,1,2]，我们找出数字 0；
    接下来判断 target 是在分割点的左边还是右边;
    最后再使用一次二分法找出 target 的位置. 所以时间复杂度为：O(logn)O(logn)
    只有一个难点，那就是如何通过二分法找出那个分割点
    """
    def search(self, nums: List[int], target: int) -> int:
        if not nums:return -1
        n = len(nums)
        left = 0
        right = len(nums) - 1
        while left < right:
            mid = left + (right - left) //2
            if nums[mid] > nums[right]:
                left = mid + 1
            else:
                right = mid
        t = left
        left = 0
        right = len(nums) - 1
        while left <= right:
            mid = (left + right) //2
            realmid = (mid + t) % n
            if nums[realmid] == target:
                return realmid
            elif nums[realmid] > target:
                right = mid - 1
            else:
                left = mid + 1
        return -1