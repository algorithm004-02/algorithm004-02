#!/usr/bin/python
# -*- coding: utf-8 -*-
# @Time    : 2019/11/18
# @Author  : xujun
"""
不同路径 II
一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为“Start” ）。

机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为“Finish”）。

现在考虑网格中有障碍物。那么从左上角到右下角将会有多少条不同的路径？
"""


class Solution:
    def uniquePathsWithObstacles(self, obstacleGrid) -> int:
        m = len(obstacleGrid)
        n = len(obstacleGrid[0])
        if obstacleGrid[0][0] == 1:
            obstacleGrid[0][0] = 0
        else:
            obstacleGrid[0][0] = 1
        for i in range(1, n):
            if obstacleGrid[0][i - 1] == 1 and obstacleGrid[0][i] == 0:
                obstacleGrid[0][i] = 1
            else:
                obstacleGrid[0][i] = 0
        for j in range(1, m):
            if obstacleGrid[j - 1][0] == 1 and obstacleGrid[j][0] == 0:
                obstacleGrid[j][0] = 1
            else:
                obstacleGrid[j][0] = 0
        for i in range(1, m):
            for j in range(1, n):
                if obstacleGrid[i][j] == 0:
                    obstacleGrid[i][j] = obstacleGrid[i - 1][j] + obstacleGrid[i][j - 1]
                else:
                    obstacleGrid[i][j] = 0
        return obstacleGrid[-1][-1]

