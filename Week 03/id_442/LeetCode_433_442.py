# https://leetcode-cn.com/problems/minimum-genetic-mutation/submissions/

from collections import deque

class Solution:
    def minMutation(self, start: str, end: str, bank: List[str]) -> int:
        queue, bank_set = deque([(start, 0)]), set(bank)
        while queue:
            current, step = queue.popleft()
            if current == end:
                return step
            for i in range(len(current)):
                for c in 'AGCT':
                    mutation = current[:i] + c + current[i+1:]
                    if mutation in bank_set:
                        bank_set.remove(mutation)
                        queue.append((mutation, step+1))
        return -1
