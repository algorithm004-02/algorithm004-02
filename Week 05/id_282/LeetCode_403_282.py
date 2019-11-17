class Solution:
    """
    青蛙过河
    一只青蛙想要过河。 假定河流被等分为 x 个单元格，并且在每一个单元格内都有可能放有一石子（也有可能没有）。 青蛙可以跳上石头，但是不可以跳入水中。
    给定石子的位置列表（用单元格序号升序表示）， 请判定青蛙能否成功过河（即能否在最后一步跳至最后一个石子上）。 开始时， 青蛙默认已站在第一个石子上，并可以假定它第一步只能跳跃一个单位（即只能从单元格1跳至单元格2）。
    如果青蛙上一步跳跃了 k 个单位，那么它接下来的跳跃距离只能选择为 k - 1、k 或 k + 1个单位。 另请注意，青蛙只能向前方（终点的方向）跳跃。
    """
    def canCross(self, stones: List[int]) -> bool:
        if not stones:
            return False
        stones_set = set(stones)
        from collections import defaultdict
        stones_dict = defaultdict(set)
        stones_dict[stones[0]] = {0}
        for stone in stones:
            for key in stones_dict[stone]:
                stoneKey = stone + key
                if key + 1 > 0 and (stoneKey + 1) in stones_set:
                    stones_dict[stoneKey + 1].add(key + 1)
                if key > 0 and stoneKey in stones_set:
                    stones_dict[stoneKey].add(key)
                if key - 1 > 0 and (stoneKey - 1) in stones_set:
                    stones_dict[stoneKey - 1].add(key - 1)
        return not(not (stones_dict[stones[-1]]))