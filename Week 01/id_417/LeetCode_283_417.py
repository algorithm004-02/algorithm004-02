class Solution:
    def moveZeroes(self, nums: List[int]) -> None:
        """
        Do not return anything, modify nums in-place instead.
        """
        
        # 把列表想像成一个泳道，设置两个游标i,j，它们一开始从左向右一格一格地移动
        # 把泳道中的0元素想像成材料A，非零元素想像成另一种材料B
        # 材料A会将i阻隔在它的左边，却把j瞬间移动到它的最右边
        # 材料B会将i推到它的最右边（随后被A隔住），在j遇到材料A后，就会将j挡在最左边
        # 如此i，j分别指示第一段0元素所构成的子泳道的两端（如果有的话）
        # 将i+1和j的所在的材料交换，让i，j按照以上规则移动即可将所有0移到最后
        
        i = j = 0  # i, j一开始所在的位置
        
        while(j < len(nums)):  # 当j移动到最后就结束
            if not nums[j] == 0: 
                if i == j:  # 一开始都是非零元素，i，j保持一致，这时候它们一格一格运动
                    i += 1
                    j += 1
                else:  # 当i, j不一致，说明有0元素段的出现，这时候需要交换元素
                    t = nums[i]
                    nums[i] = nums[j]
                    nums[j] = t
                    
                    i += 1  # 由于交换材料后，i所在的地方不再是0段的左边一格，所以要加1
                    j += 1  # 同样道理
            else:  # 当nums[j]为0时，j会不断往前移动，而i保持不变
                j += 1
