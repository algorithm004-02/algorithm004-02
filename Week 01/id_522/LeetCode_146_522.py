class LRUCache:
    def __init__(self, capacity: int): 

        self.capacity =capacity
        self.mapp ={}
        self.head=Entry(-6789,0)  #the most useful part
        self.tail=Entry(-8377,0)  #the most useful part
        self.head.next = self.tail
        #self.head.prev=None
        self.tail.prev =self.head
        #self.tail.next =None
        #self.mapp[6789]=self.head
        #self.mapp[-8377]=self.tail

    def get(self, key) :
        if key in self.mapp:
            entry =self.mapp[key]
            self.poptotail(entry)
            return entry.va
        return -1

    def mypop(self,entry):
        prev = entry.prev
        next = entry.next
        prev.next = next
        next.prev = prev


    def poptotail(self,entry):
        #pop
        #prev = entry.prev
        #next = entry.next
        #prev.next = next
        #next.prev = prev
        self.mypop(entry)

        # link it to the last
        self.addToTail(entry)

    def removeFirst(self):
        first = self.head.next
        self.mypop(first)
        #second = first.next
        #self.head.next = second
        #second.prev = self.head
        return first

    def addToTail(self,entry):
        last = self.tail.prev
        last.next = entry
        self.tail.prev = entry
        entry.prev = last
        entry.next = self.tail

    def put(self, key, value) :
        if key in self.mapp:
            entry =self.mapp[key]
            entry.va=value
            self.poptotail(entry)
        else:
            newEntry = Entry(key, value)
            if len(self.mapp) >= self.capacity  :    #the most useful part
                first =self.removeFirst()
                del self.mapp[first.key]
            self.addToTail(newEntry)
            self.mapp[key]=newEntry

class Entry:

        def __init__(self,key ,va):
            self.key=key
            self.va=va
            self.prev= None
            self.next= None
