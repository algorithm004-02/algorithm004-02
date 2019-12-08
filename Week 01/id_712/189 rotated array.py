class solution:
    def rotated_array(self,array,k):
        k%=len(array)
        array.reverse()
        array[:k]=reversed(array[:k])
        array[k:]=reversed(array[k:])

if  __name__ == "__main__":
    s1=solution()
    s1.rotated_array([1,2,3,4,5,6,7],)