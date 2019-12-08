class solution:
    def max_area(self,height):
        left=0
        right=len(height)-1
        maxarea=(right-left)*min(height[left],height[right])
        while left<right:
            if height[left]<height[right]:
                left=left+1
            else:
                right=right-1
            maxarea=max(maxarea,(right-left)*min(height[left],height[right]))
        return maxarea

if __name__=="__main__":
    s1=solution()
    print(s1.max_area([1,8,6,2,5,4,8,3,7]))