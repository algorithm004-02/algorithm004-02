class Solution:
    """
    注意点：
    找规律
    机器人行走中，最远的距离，而不是终点的距离
    """
    def robotSim(self, commands: List[int], obstacles: List[List[int]]) -> int:
        dx = [0, 1, 0, -1]
        dy = [1, 0, -1, 0]
        di, x, y = 0, 0, 0
        distance = 0
        obs_dict = {}
        # 这一步很重要，因为后面有很多次需要进行判断是否存在
        # list的查找的复杂度明显高于dict的O(1)，提前转，节省很多消耗
        for obs in obstacles:
            obs_dict[tuple(obs)] = 0
        for com in commands:
            if com == -2:
                di = (di + 3)%4
            elif com == -1:
                di = (di + 1)%4
            else:
                for j in range(com):
                    next_x = x + dx[di]
                    next_y = y + dy[di]
                    if (next_x, next_y) in obs_dict:
                        break
                    x, y = next_x, next_y
                    distance = max(distance, x*x + y*y)
        return distance
