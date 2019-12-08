class Solution(object):
    def merge(self, nums1, m, nums2, n): 
        """
        :type nums1: List[int]
        :type m: int
        :type nums2: List[int]
        :type n: int
        :rtype: void Do not return anything, modify nums1 in-place instead.
        """
        # two get indexs for nums1 and nums2
        p1 = m - 1
        p2 = n - 1
        # set index for nums1
        p = m + n - 1  
        
        # while there are still elements to compare
        while p1 >= 0 and p2 >= 0:
            if nums1[p1] < nums2[p2]:
                nums1[p] = nums2[p2]
                p2 -= 1
                p -= 1
            else:
                nums1[p] =  nums1[p1]
                p1 -= 1
                p -= 1
        # add missing elements from nums2
        nums1[:p2 + 1] = nums2[:p2 + 1]