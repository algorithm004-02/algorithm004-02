
class Solution(object):
    def reverseStr(self, s, k):

        a=list(s)
        size=len(s)
        for i in range(0,size,k*2):

            a[i:i+k]= reversed(a[i:i+k])

        return "".join(a)

aa=[1,2,3]
print(aa[2:88])

'''
class Solution(object):
    def reverseStr(self, s, k):
        """
        :type s: str
        :type k: int
        :rtype: str
        """
        kk=2*k
        if k==1:return s

        ll=len(s)
        if ll==1:return s
        def nei(ss):

            qian=ss[0:k]
            #print(qian[::-1]+ ss[k:])
            return qian[::-1]+ss[k:]

        res=""
        n=0
        while ll> kk :

            tempss = s[n*kk :n*kk+kk]

            res += nei(tempss)
            n+=1
            ll-=kk

        ll2=ll

        if k < ll2 <= kk :

            ttt2=s[ n*kk : n*kk+k]
            ttt3=s [n*kk+k:]
            res+= ttt2[::-1]
            res+= ttt3

        if ll2<=k :

            ttt= s[ n*kk :]
            res+= ttt[  : : -1]

        return res  '''
