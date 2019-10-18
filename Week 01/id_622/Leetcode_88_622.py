"""
给定两个有序整数数组 nums1 和 nums2，将 nums2 合并到 nums1 中，使得 num1 成为一个有序数组。

说明:

初始化 nums1 和 nums2 的元素数量分别为 m 和 n。
你可以假设 nums1 有足够的空间（空间大小大于或等于 m + n）来保存 nums2 中的元素。
示例:

输入:
nums1 = [1,2,3,0,0,0], m = 3
nums2 = [2,5,6],       n = 3

输出: [1,2,2,3,5,6]

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/merge-sorted-array
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
"""
class Solution:
    """
    方法一、 引入新的数组（衍生思考Python的数据引用的思想）
        同时把nums1的数组置为空，两个数组从零开始比较，小的数值插入新nums1,再看nums1下一个
    """
    def merge(self, nums1: List[int], m: int, nums2: List[int], n: int) -> None:
        """
        Do not return anything, modify nums1 in-place instead.
        """
        temp_list = nums1[:m]
        # nums1 置为空数组
        nums1[:] = []
        
        i = 0
        j = 0
        
        while i < m and j < n:
            #比较头部大小
            if temp_list[i] < nums2[j]:
                nums1.append(temp_list[i])
                i += 1
            else:
                nums1.append(nums2[j])
                j += 1

        # 边界情况其中有一个数组已经插入完成，另外一个数组还未完成
        # 从while退出，需要补充未插入的数组        
        if i < m:
            nums1[i+j : ] = temp_list[i:]
        if j < n:
            nums1[i+j : ] = nums2[j:]
                
        return nums1

    """
    方法二、 尾部插入法，由于数组有序，判断尾部的值，大的则插入num1的尾部
        offset向左移动一位，直到移动完毕
        由于数组有序，如果num1的数组没有移动完毕，则不需要操作
        如果num2的数组没有移动完毕，则遍历num2剩余的数组，并替代nums1
    """
    def merge(self, nums1: List[int], m: int, nums2: List[int], n: int) -> None:
        """
        Do not return anything, modify nums1 in-place instead.
        """
        offset = -1
        i = m - 1
        j = n - 1
        
        while i >= 0 and j >= 0:
            if nums1[i] < nums2[j]:
                nums1[offset] = nums2[j]
                j -= 1
                offset -= 1
            else:
                nums1[offset] = nums1[i]
                i -= 1
                offset -= 1
        
        while j >= 0:
            nums1[j] = nums2[j]
            j -= 1
                
        return nums1
