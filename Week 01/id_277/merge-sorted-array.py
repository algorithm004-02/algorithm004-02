"""
最开始只想到从头到尾的遍历,结果需要重新构造一个新的数组保存比较结果才可以;
如果修改成从尾到头遍历,则无需使用新的数组;
当如果题目没有明确nums1的空间是m+n,则构造新的数组较为安全.
"""
class Solution:
    def merge(self, nums1: List[int], m: int, nums2: List[int], n: int) -> None:
        """
        Do not return anything, modify nums1 in-place instead.
        """
        p1 = m - 1
        p2 = n -1
        p = m + n-1
        while p1>= 0 and p2>=0:
            if nums1[p1] < nums2[p2]:
                nums1[p] = nums2[p2]
                p2 -=1
            else:
                nums1[p] = nums1[p1]
                p1 -=1
            p -=1
        nums1[:p2+1] = nums2[:p2+1]