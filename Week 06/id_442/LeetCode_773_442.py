# https://leetcode-cn.com/problems/sliding-puzzle/ 


# BFS
from collections import deque

class Solution:
    def slidingPuzzle(self, board: List[List[int]]) -> int:
        board = board[0] + board[1]
        moves = [(1, 3), (0, 2, 4), (1, 5), (0, 4), (1, 3, 5), (2, 4)]
        queue, visited = deque([(tuple(board), board.index(0), 0)]), set()
        while queue:
            state, now, step = queue.popleft()
            if state == (1, 2, 3, 4, 5, 0):
                return step
            for n in moves[now]:
                _state = list(state)
                _state[n], _state[now] = _state[now], _state[n]
                _state = tuple(_state)
                if _state not in visited:
                    queue.append((_state, n, step+1))
            visited.add(state)
        return -1
