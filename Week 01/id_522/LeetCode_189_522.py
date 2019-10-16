class Solution:
    def rotate(self, nums: List[int], k: int) -> None:
        """
        Do not return anything, modify nums in-place instead.
        """
        chang=len(nums)
        if chang<2:return
        def swap(a,left,right):
            #size=right -left +1
            #half =size//2
            half=(right -left +1)//2
            for k in range(half):
                a[left+k],a[right-k]=a[right-k],a[left+k]
        k=k%chang
        swap(nums,0,chang-1)
        swap(nums,0,k-1)
        swap(nums,k,chang-1) 