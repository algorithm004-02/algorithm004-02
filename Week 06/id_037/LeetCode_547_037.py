# From some source, we can visit every connected node to it with a simple DFS. As is the case with DFS's, seen will keep track of nodes that have been visited.

# For every node, we can visit every node connected to it with this DFS, and increment our answer as that represents one friend circle (connected component.)

def findCircleNum(self, A):
    N = len(A)
    seen = set()
    def dfs(node):
        for nei, adj in enumerate(A[node]):
            if adj and nei not in seen:
                seen.add(nei)
                dfs(nei)
    
    ans = 0
    for i in xrange(N):
        if i not in seen:
            dfs(i)
            ans += 1
    return ans