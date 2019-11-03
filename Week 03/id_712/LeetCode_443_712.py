class Solution(object):
    def minMutation(self,start,end,bank):
        bank=set(bank)
        if end not in bank:
            return -1
        quene=[(start,0)]
        while quene:
            curr,step=quene.pop(0)
            if curr==end:
                return step
            for i in range(len(curr)):
                for c in "AGCT":
                    mutation=curr[:i]+c+curr[i+1:]
                    if mutation in bank:
                        bank.remove(mutation)
                        quene.append((mutation,step+1))

        return -1

if __name__=="__main__":
    s1=Solution()
    result=s1.minMutation("AACCGGTT","AACCGGTA",["AACCGGTA"])
    print(result)