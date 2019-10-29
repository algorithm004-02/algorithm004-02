# 第一遍自己手写，超时了，卡在第21个测试用例上。用了3个多小时，累死。
class Solution:
    def ladderLength(self, beginWord, endWord, wordList):
        if endWord not in wordList: return 0

        def hao(a, b):  # a ,b is two words
            sum = 0
            for i in range(len(a)):
                if a[i] != b[i]: sum += 1
            return sum

        visited = set()
        que = [(beginWord, visited)]

        def bfs(res):
            flag1 = flag2 = True
            while que:
                level = []
                ll = len(que)

                for kk in range(ll):
                    node, vv = que.pop(0)
                    # print(node)
                    vv.add(node)
                    # 拿出node
                    if hao(node, endWord) == 1:
                        # if node == endWord and hao(node,endWord):
                        return res + 2
                    # flag2=False
                    # flag1=False
                    # break

                    for i in wordList:
                        if i == beginWord: continue

                        if hao(node, i) == 1 and i not in vv:
                            flag3 = True
                            vv.add(i)
                            que.append((i, vv))
                            vv.remove(i)
                # print(que)
                if que == []: return 0

                # if not flag1:break
                res += 1
            # return res

        res = bfs(0)
        return res
