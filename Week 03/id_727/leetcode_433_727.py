def minMutation(self, start: str, end: str, bank: List[str]) -> int:
        def check(s,e):
            change = 0
            for i in range(len(s)):
                if s[i] != e[i]:
                    change += 1
            return change == 1
        queue = [(start, 0)]
        visited = set()
        while queue:
            curr, step = queue.pop()
            visited.add(curr)
            if curr == end:
                return step
            for string in bank:
                if check(string,curr) and string not in visited:
                    queue.append((string, step + 1))
        return -1