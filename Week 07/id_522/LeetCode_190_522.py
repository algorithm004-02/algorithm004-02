class Solution:
    # @param n, an integer
    # @return an integer
    def reverseBits(self, n):
        ans=0
        MM=1
        for i in range(32):
            if n&MM :
                ans |= 1<< (31-i)
            MM <<= 1
        return ans

'''
class Solution:
    # @param n, an integer
    # @return an integer
    def reverseBits(self, n):
        str2=bin(n)
        str3= str2[2:]
        str4=str3.zfill(32)
        sdddao= str4[::-1]
        return int(sdddao,2)

'''
