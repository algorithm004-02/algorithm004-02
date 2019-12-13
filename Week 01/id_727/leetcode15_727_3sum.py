# brute force with O(N^3)
def threeSum(self, nums: List[int]) -> List[List[int]]:
        result = []
        for i in range(len(nums)):
            for j in range(i+1,len(nums)) :
                for k in range(i+2,len(nums)):
                    if ((nums[i] + nums[k] + nums[j] == 0) and (i != k) and (k != j)):
                        temp = [nums[i], nums[j], nums[k]]
                        temp.sort()
                        if temp not in result:
                            result.append(temp)
        return result

# O(N*N) solution 
def threeSum(self, nums):
    result = []
    nums.sort()
    for i in range(len(nums)-2):
        if i > 0 and nums[i] == nums[i-1]:
            continue
        l, r = i+1, len(nums)-1
        while l < r:
            s = nums[i] + nums[l] + nums[r]
            if s < 0:
                l +=1 
            elif s > 0:
                r -= 1
            else:
                result.append((nums[i], nums[l], nums[r]))
                while l < r and nums[l] == nums[l+1]:
                    l += 1
                while l < r and nums[r] == nums[r-1]:
                    r -= 1
                l += 1; r -= 1
    return result
