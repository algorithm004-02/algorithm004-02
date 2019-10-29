<<<<<<< HEAD
class Solution(object):
    def plusOne(self, digits):
        """
        :type digits: List[int]
        :rtype: List[int]
        """
        size=len(digits)
        for i in range(-1,-size-1,-1): #the most useful part -size-1
            
            if digits[i] == 9:
                digits[ i] = 0
                if -i == size:    #reach the left border 
                    digits[ i ] = 1
                    digits.append(0)
                    
                    return digits
            else:
                digits[ i] += 1
                
=======
class Solution(object):
    def plusOne(self, digits):
        """
        :type digits: List[int] 
        :rtype: List[int]
        """
        size=len(digits)
        for i in range(-1,-size-1,-1): #the most useful part -size-1
            
            if digits[i] == 9:
                digits[ i] = 0
                if -i == size:    #reach the left border 
                    digits[ i ] = 1
                    digits.append(0)
                    
                    return digits
            else:
                digits[ i] += 1
                
>>>>>>> upstream/master
                return digits