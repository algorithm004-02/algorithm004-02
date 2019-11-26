# NOTE

简单过了一遍视频，位运算，有些记不住，，
关于排序，因为个人感觉希尔，冒泡，选择排序，用到的比较小，精力少放。
主要精力，还是要放在老师说的NLOGN 算法上。
LRU 在python 中，正好可以看出，是两种数据结构同时配合使用的结果。

这个星期，一共在leetcode 做题，大约180 道，开始感觉到，代码之间的关系。
也就是说，**他山之石可以功玉。代码似曾相识，结构可以复用，框架可以参考，**
当看到老师讲快排的代码，最佳实现时，
立马感觉到，这个代码的结构与移动零，删除排序数组中的重复项，有些相似。talk is cheap show me the code
```
class Solution:
    def qsort(self,arr,begin,end):
        if begin>=end:return
        def findp(arr,ss,ee):
            counter =ss
         
            for i in range(ss,ee):      #循环
                if arr[i]<arr[ee]:      #判断
                    arr[i],arr[counter]=arr[counter],arr[i] #交换
                    counter+=1          #向右走一步
                    
            arr[ee],arr[counter]=arr[counter],arr[ee]
            return counter
看移动零的代码,思想是相同的。
class Solution:
    def moveZeroes(self, nums: List[int]) -> None:
        slow = 0
        for fast in range(len(nums)):   #循环
            if nums[fast] != 0  :       #判断
                nums[slow],nums[fast]=nums[fast],nums[slow] #交换
                slow += 1               #向右走一步

```

**所以，老师说的，过遍数，是对的，看优秀的代码，是对的。**

由于是python，快速排序10行搞定，归并排序压缩为20行搞定。在下面深处

```
#insert sort  
class Solution:

    def inssort(self,nums):
        size=len(nums)
        for i in range(1,size):
            j=i
            now =nums[i]
            while j>0 and now < nums[j-1]:
                nums[j]=nums[j-1]
                j-=1
            nums[j]=now

'''
cc=Solution()
a=[2,3,6,5,1,7]
cc.inssort(a)
print(a)
'''
#bubble sorted
class Solution:
    def bubble(self,nums):
        size=len(nums)
        for i in range(size):
            for j in range(size-1,i,-1):
                if nums[j]<nums[j-1]:
                    #swap 
                    nums[j],nums[j-1]=nums[j-1],nums[j]
cc=Solution()
a=[2,3,6,5,1,7,7,7,66,88,44,34]
cc.bubble(a)
print(a)

#select sorted
class Solution:
    def select(self,nums):
        size=len(nums)
        for i in range(size):
            smallindex=i
            #for j in range(size-1,i,-1):
            for j in range(i+1,size):
                if nums[j]<nums[smallindex]:
                    smallindex=j
            nums[smallindex],nums[i]=nums[i],nums[smallindex] # 一行搞定，最佳实践
cc=Solution()
a=[2,3,6,5,1,7,7,7,66,88,44,34]
cc.select(a)
print(a)

#快速排序 ，双指针两边夹逼法定位pivot
class Solution:
    def qsort(self,arr,begin,end):
        if begin>=end:return
        def findp(arr,ss,ee):
            left =ss
            right=ee
            #双指针夹逼的方法
            while 1:
                while arr[left] < arr[p] and left<right:  left +=1
                while arr[right] >= arr[p] and left<right: right-=1
                if left !=right:
                    arr[left],arr[right]=arr[right],arr[left]
                    left+=1
                else:
                    break
                    
            arr[ee],arr[left]=arr[left],arr[ee]
            return left

        p=findp(arr,begin,end)
        self.qsort(arr,begin,p-1)
        self.qsort(arr,p+1,end)

cc=Solution()
aa=[440, 551, 2, 34444444, 5, 6, 107, 7, 79999, 107, 7, 79999, 134, 44, 65,1,1,123,23,3333,66, 88,79999, 134, 44, 65,1,1,79999]
s=0
end=len(aa)-1
cc.qsort(aa,s,end)
print(aa)


#老师上课讲解的，好理解，快速排序
class Solution:
    def qsort(self,arr,begin,end):
        if begin>=end:return
        
        def findp(arr,start,ee):
            counter =start
            #pivot=ee
            for i in range(start,ee):
                if arr[i]<arr[ee]:
                    arr[i],arr[counter]=arr[counter],arr[i]
                    counter+=1
            arr[ee],arr[counter]=arr[counter],arr[ee]
            return counter

        p=findp(arr,begin,end)
        self.qsort(arr,begin,p-1)
        self.qsort(arr,p+1,end)

cc=Solution()
aa=[440, 551, 2, 3444444, 5, 6, 107, 7, 79,99, 107, 7, 799,99, 134, 44,123,23,3333,66, 88,79999, 134, 44, 65,1,1,79999]
cc.qsort(aa,0,len(aa)-1)
print(aa)


#快速排序的，第三种写法，10行搞定，需要额外空间
class Solution:
    def qsort(self, arr):
        if len(arr) <= 1:return arr
        
        p,small,big =arr[-1],[],[]
        #a=[m for m in arr[:-1] if m<=p]
        #b=[bb for bb in arr[:-1] if bb>p]
        #优化为一次遍历
        for k in arr[:-1]:
            if k>p:
                big.append(k)
            else:
                small.append(k)
        #return self.qsort(a)+[p]+self.qsort(b)
        return self.qsort(small)+[p]+self.qsort(big)

cc= Solution()
aa=[440, 551, 223232, 3444444, 5, 6, 107, 7, 79,99, 107, 7, 799,99, 134, 44,123,23,3333,66, 88,79999, 134, 44, 65,1,1,79999]
print(cc.qsort(aa))

#在归并排序中，使用了 更python 的写法，力求比JAVA 行数少
class Solution:
    def mergesort(self,arr,begin,end):
        if begin>=end:return
        def merge(arr,begin,mid,end):
            if begin>=end:return

            #tt=[0 for _ in range(begin+end-1)]
            tt=[0 for _ in range(end-begin+1)]
            p1=begin; p2=mid+1; p=0
            while p1<=mid and p2<=end:

                (tt[p],p1,p2,p) = (arr[p1],p1+1 ,p2,p+1) if arr[p1]<=arr[p2] else (arr[p2],p1,p2+1,p+1)
             '''if arr[p1]<=arr[p2]:
                    tt[p]=arr[p1]
                    p1+=1
                else:
                    tt[p]=arr[p2]
                    p2+=1
                p+=1'''
            while p1<=mid:
                tt[p]=arr[p1]
                p+=1
                p1+=1
            while p2<=end:
                tt[p],p,p2=arr[p2],p+1,p2+1
            #copy tt to arr
            for i in range(len(tt)):arr[begin+i]=tt[i]

        mid=begin+end >>1
        self.mergesort(arr,begin,mid)
        self.mergesort(arr,mid+1,end)
        merge(arr,begin,mid,end)

cc=Solution()
aa=[440, 551, 2, 3444444, 5, 6, 107, 70909, 79,99, 107, 7, 799,99, 134, 44,123,23,3333,66, 88,79999, 134, 44, 65,1,1,79999]
cc.mergesort(aa,0,len(aa)-1)
print(aa)

#归并排序，压缩为20行，python 3，用到了，多个值，一次性赋值第8行代码
class Solution:
	def mergesort(self, arr, begin, end):
		if begin >= end: return
		def merge(arr, begin, mid, end):
			if begin >= end: return
			p1, p2, p, tt = begin, mid + 1, 0, [0 for _ in range(end - begin + 1)]
			while p1 <= mid and p2 <= end:
				(tt[p], p1, p2, p) = (arr[p1], p1 + 1, p2, p + 1) if arr[p1] <= arr[p2] else (
				arr[p2], p1, p2 + 1, p + 1)
			while p1 <= mid:
				tt[p], p, p1 = arr[p1], p + 1, p1 + 1
			while p2 <= end:
				tt[p], p, p2 = arr[p2], p + 1, p2 + 1
			# copy tt to arr
			for i in range(len(tt)): arr[begin + i] = tt[i]

		mid = begin + end >> 1
		self.mergesort(arr, begin, mid)
		self.mergesort(arr, mid + 1, end)
		merge(arr, begin, mid, end)
```
