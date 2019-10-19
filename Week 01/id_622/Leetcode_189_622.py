"""
给定一个数组，将数组中的元素向右移动 k 个位置，其中 k 是非负数。

示例 1:

输入: [1,2,3,4,5,6,7] 和 k = 3
输出: [5,6,7,1,2,3,4]
解释:
向右旋转 1 步: [7,1,2,3,4,5,6]
向右旋转 2 步: [6,7,1,2,3,4,5]
向右旋转 3 步: [5,6,7,1,2,3,4]
示例 2:

输入: [-1,-100,3,99] 和 k = 2
输出: [3,99,-1,-100]
解释: 
向右旋转 1 步: [99,-1,-100,3]
向右旋转 2 步: [3,99,-1,-100]
说明:

尽可能想出更多的解决方案，至少有三种不同的方法可以解决这个问题。
要求使用空间复杂度为 O(1) 的 原地 算法。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/rotate-array
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
"""

class Solution:
    """
    方法一、 暴力法，从尾部提出数据，再插入头部，只考虑执行K次
        利用了Python的函数，但是Python的内置函数性能开销需要考虑，复杂度O(k*n)
        实际执行过程164ms
    方法二、 考虑执行多少次的问题，因为 k % 数组长度表示执行的次数，
        需要考虑边界条件k为0的情况
    方法三、 反转数组，python中支持list的reverse()，但是此功能不接收参数
        考虑自己实现指定长度数组翻转功能
    方法四、使用环状
    
    Note : 实际过程中，发现问题更复杂，审题没清楚，数组有可能反复翻转，未考虑
        k大于数组长度的情况
    扩展知识：思考python中list操作的复杂度，pop, remove, insert, append
    思考关键：判断循环的问题，即如果K > len(nums), 则k=k%len(nums)，得出需要执行
        的次数，再进行操作
    """
    def rotate_method1(self, nums: List[int], k: int) -> None:
        """
        Do not return anything, modify nums in-place instead.
        """
        while k > 0:
            nums.insert(0, nums.pop()) # insert(index, value)复杂度O(n),pop()复杂度O(1)
            k -= 1
        return nums

    def rotate_method2(self, nums: List[int], k: int) -> None:
        """
        Do not return anything, modify nums in-place instead.
        """
        i = 0
        k = k % len(nums)
        while len(nums) - k > i:
            nums.append(nums.pop(0)) # pop(0)复杂度O(n)
            i += 1
        return nums

    # 自顶向下的开发复杂度O(n)
    def rotate_method3(self, nums: List[int], k: int) -> None:
        """
        Do not return anything, modify nums in-place instead.
        """
        k %= len(nums)
        nums.reverse()
        self.reverse_list(nums, 0, k-1)
        self.reverse_list(nums, k, len(nums)-1)
        return nums

    def reverse_list(self, nums, start, end):
        while start < end:
            nums[start], nums[end] = nums[end], nums[start]
            start += 1
            end -= 1
        return nums

    def rotate(self, nums, k):
        """
        :type nums: List[int]
        :type k: int
        :rtype: void Do not return anything, modify nums in-place instead.
        """
        """
        国际站解法，先抄下来。。。。
        """
        n, k, j = len(nums), k % len(nums), 0
        while n > 0 and k % n != 0:
            for i in xrange(0, k):
                nums[j + i], nums[len(nums) - k + i] = nums[len(nums) - k + i], nums[j + i] # swap
            n, j = n - k, j + k
            k = k % n

    def rotate(self, nums: List[int], k: int) -> None:
        """
        Do not return anything, modify nums in-place instead.
        """
        # 一开始len(nums)没有赋值给n，变为128ms，赋值以后78ms
        n = len(nums)
        k = k % n
        if k == 0: return
        count = 0
        start = 0
        prev = nums[0]
        
        while count < n:
            next = (start + k) % n
            
            while start != next:
                nums[next], prev = prev, nums[next]
                next = (next + k) % n
                count += 1

            nums[next] = prev
            start += 1
            prev = nums[start]
            count += 1
        return nums
                
