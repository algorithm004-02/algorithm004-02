class MyCircularDeque:

    def __init__(self, k: int):
        """
        Initialize your data structure here. Set the size of the deque to be k.
        """
        self.sizelimit = k
        
        self.que=[]

    def insertFront(self, value: int) -> bool:
        """
        Adds an item at the front of Deque. Return true if the operation is successful.
        """
        if len(self.que) < self.sizelimit :
            self.que.insert(0,value)
            
            return  True
        else:
            return   False       

    def insertLast(self, value: int) -> bool:
        """
        Adds an item at the rear of Deque. Return true if the operation is successful.
        """
        if len(self.que) < self.sizelimit :
            self.que+=[value]
            return True
        else:
            return False        

    def deleteFront(self) -> bool:
        """
        Deletes an item from the front of Deque. Return true if the operation is successful.
        """
        if len(self.que) ==0 :
            return False
        else:
            self.que.pop(0)
            return True      

    def deleteLast(self) -> bool:
        """
        Deletes an item from the rear of Deque. Return true if the operation is successful.
        """
        if len(self.que) ==0 :
            return False
        else:
            self.que.pop()
            return True  		
 
    def getFront(self) -> int:
        """
        Get the front item from the deque.
        """
        return -1 if len(self.que) ==0 else self.que[0]       

    def getRear(self) -> int:
        """
        Get the last item from the deque.
        """
        return -1 if len(self.que) ==0 else self.que[-1]  
        
    def isEmpty(self) -> bool:
        """
        Checks whether the circular deque is empty or not.
        """
        return True if len(self.que)==0 else False
        
    def isFull(self) -> bool:
        """
        Checks whether the circular deque is full or not.
        """
        return True if len(self.que) == self.sizelimit  else False