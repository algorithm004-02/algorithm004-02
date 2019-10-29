class Solution:
    """
    采用Hash表的方法处理;
    通过构建一个新的字典表,将原本数组中的下标与值分别作为字典的value和Key
    再判断target与循环值的差值是否存在于字典中,从而得出结果
    """
    def twoSum(self, nums: List[int], target: int) -> List[int]:
        dict = {}
        for i, n in enumerate(nums):
            if target - n in dict:
                return [dict[target - n], i]
            dict[n] = i