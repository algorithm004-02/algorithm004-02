#执行用时 :92 ms, 在所有 python3 提交中击败了99.54%的用户
class Solution(object):
    def ladderLength(self, beginWord, endWord, wordList):
        if endWord not in wordList: return 0
        front = {beginWord}
        back = {endWord}
        dist = 1
        wordList = set(wordList)
        word_len = len(beginWord)
        while front:
            dist += 1
            next_front = set()
            for word in front: #对每一个单词都要处理
                for i in range(word_len): #对每一个单词替换每一个字母
                    for c in "abcdefghigklmnopqrstuvwxyz": #每次尝试26个
                        if c !=word[i]:  #去掉这个更快。
                            new_word = word[:i]+c+word[i+1:]
                            if new_word in back:
                                return dist
                            if new_word in wordList:
                                next_front.add(new_word)
                                wordList.remove(new_word)
            front = next_front
            if len(back)<len(front):
                front, back = back, front
        return 0


'''
# 96ms ,
class Solution:
    def ladderLength(self, beginWord, endWord, wordList):
        if endWord not in wordList: return 0
        step, b, e, w = 1, {beginWord}, {endWord}, set(wordList)
        size = len(beginWord)
        while b:
            step += 1
            newb = set()

            for word in b:
                for i in range(size):
                    for c in "abcdefghigklmnopqrstuvwxyz":
                        newword = word[:i] + c + word[i + 1:]
                        if newword in e: return step
                        if newword in w:
                            newb.add(newword)
                            w.remove(newword)
            b = newb
            if len(b) > len(e): b, e = e, b
        return 0



class Solution:
    def ladderLength(self, beginWord, endWord, wordList):
        if endWord not in wordList: return 0

        #step,b,e,w=1,{beginWord},{endWord},{wordList}             error
        #step,b,e,w=1,set(beginWord},set(endWord),set(wordList)    error
        step,b,e,w=1,{beginWord},{endWord},set(wordList)
        #print(b,e)
        size=len(beginWord)

        while b:
            step+=1
            newb=set()

            for word in b:
                for i in range(size):
                    for  c in "abcdefghigklmnopqrstuvwxyz":
                        if c !=word[i]:                         #去掉这个更快。
                            newword=word[:i]+c+word[i+1:]

                            if newword in e:return step
                            if newword in w:
                                newb.add(newword)
                                w.remove(newword)
            b=newb
            if len(b)>len(e):b,e=e,b
        return 0
'''

# 第一遍自己手写，超时了，卡在第21个测试用例上。用了3个多小时，累死。

# 没有测试完毕，超时了，先写到这里，
'''
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
        res=0
        #def bfs(res):
        while que:
            level = []
            ll = len(que)

            for kk in range(ll):
                node, vv = que.pop(0)
                vv.add(node)
                # 拿出node
                if hao(node, endWord) == 1:return res + 2

                for i in wordList:
                    if i == beginWord: continue

                    if hao(node, i) == 1 and i not in vv:
                        vv.add(i)
                        que.append((i, vv))
                        vv.remove(i)
            if que == []: return 0
            res += 1
        return res
'''
