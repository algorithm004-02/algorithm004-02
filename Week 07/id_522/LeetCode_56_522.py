class Solution(object):
    def merge(self, intervals):
        """
        :type intervals: List[List[int]]
        :rtype: List[List[int]]
        """
        tt=sorted(intervals)
        res=[tt[0]]
        for t in tt:
            if  res[-1][-1]<t[0]:
                res.append(t)
            else:
                res[-1][-1]=max(res[-1][-1],t[-1])

        return res


'''  change some code 
class Solution(object):
    def merge(self, intervals):
        if not intervals:return []
        tt=sorted(intervals)
        w=[tt[0]]
        for t in tt:
            if  w[-1][-1]<t[0]:
                w.append(t)
            else:
                w[-1][-1]=max(w[-1][-1],t[-1])
        return w 
'''
