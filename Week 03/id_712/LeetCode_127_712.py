import collections
class Solution():
    def ladderLength(self,bword,eword,wordlist):
        m=len(wordlist[0])
        wordlist=set(wordlist)
        if eword not in wordlist:
            return 0
        wordlist.add(bword)
        matrix=collections.defaultdict(list)
        for word in wordlist:
            for i in range(m):
                s=word[:i]+'_'+word[i+1:]
                matrix[s].append(word)

        quene=[bword]
        mark=set()
        mark.add(bword)
        dist=1
        while quene:
            nex_quene=[]
            while quene:
                word=quene.pop(0)
                for i in range(m):
                    s=word[:i]+'_'+word[i+1:]
                    for next_word in matrix[s]:
                        if next_word not in mark:
                            if next_word==eword:
                                return dist+1
                            mark.add(next_word)
                            nex_quene.append(next_word)
            quene=nex_quene
            dist+=1
        return 0

if __name__=="__main__":
    s1=Solution()
    result=s1.ladderLength("hit","cog", ["hot","dot","dog","lot","log","cog"])
    print(result)