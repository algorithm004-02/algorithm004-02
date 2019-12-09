# NOTE

  本周先看视频，动态规划的状态定义，需要费脑子。不是那么容易想到。
  
  这周，感觉收获的，还是老师说的，针对一段代码，要找到哪里可以优化，这个很重要。
  
  思维的方向，或者说数据的操作方向，很重要。。
  
  下面是917 题
  
  '''
针对 917 题

如果一开始，考虑用栈，也是可以的,一共遍历两遍，
拿起字母压入栈，并把这个位置，改写为w,也可以不改写

不是字母的位置，不改变，

第二次遍历，如果某个位置为w ，就从栈中弹出一个字母，放进去。

这就是脑袋里，没有两边向中中间这个思维，导致的。

而后同时用栈和队列，来解决它

```
#两个指针，从两边向中间
class Solution:
    def reverseOnlyLetters(self, S: str) -> str:
        left,r,s=0,len(S)-1,list(S)

        while left<r:
            if not s[left].isalpha(): left+=1
            elif not s[r].isalpha(): r-=1
            else:
                s[left],s[r]=s[r],s[left]
                left+=1
                r-=1
        return "".join(s)

#遍历两遍
class Solution:
    def reverseOnlyLetters(self, S: str) -> str:
        s=list(S)
        stack=[]
        for i in s:
            if i.isalpha(): stack.append(i)

        for i in range(len(s)):
            if s[i].isalpha():     #use isalpha() two times 
                s[i]=stack.pop()
        return "".join(s)

#同时用到栈和队列
class Solution:
    def reverseOnlyLetters(self, S: str) -> str:
        s=list(S)
        stack=[]
        import collections
        q=collections.deque()
        for i,v in enumerate(s):
            if v.isalpha():
                stack.append(v)
                q.append(i)

        while q:
            s[q.popleft()]=stack.pop()
        return "".join(s)
```
有些题目，也能感觉到思维的方向的重要作用。这道题体现的就不错。


再有，对于python 学习者，要使用这个语言的特异功能。 在557题目上 
``` 
class Solution: 
    def reverseWords(self, s: str) -> str: 
        dao=s[::-1]
        kk=dao.split() 
        return " ".join(kk[::-1])


class Solution:
    def reverseWords(self, s: str) -> str:
        return " ".join(s[::-1].split()[::-1])   #一行搞定
        
        
        
        
        
class Solution:
    def reverseWords(self, s: str) -> str:
        
        #use stack
        tt=""
        stack=[]
        for i in s:
            if i != " " :
                stack.append(i)
                continue
            
            while stack:
                tt+=stack.pop()
            tt+=" "
        while stack:
            tt+=stack.pop()
        return tt        
 ```
 
 
 本周体会到了，思维的方向，在438 题中也感受到了
 
 通过上面三道题，我们可以总结出滑动窗口算法的抽象思想： 
 ```
 int left = 0, right= 0;

while (right < s.size()) {
    window.add(s[right]);
    right++;
    
    while (valid) {
        window.remove(s[left]);
        left++;
    }
}

作者：labuladong
链接：https://leetcode-cn.com/problems/find-all-anagrams-in-a-string/solution/hua-dong-chuang-kou-tong-yong-si-xiang-jie-jue-zi-/
```

这个左右指针，来解决滑动窗口问题，思想很重要。

本周有些精力不足，写石墨文档一个 https://shimo.im/docs/VRqwcg6dQPyTjpPh 
```

# 48ms   99%
class Solution:
    def uniquePathsWithObstacles(self, obstacleGrid: List[List[int]]) -> int:

        y=len(obstacleGrid)

        x=len(obstacleGrid[0])

        if not obstacleGrid :return 0
        if obstacleGrid[y-1][x-1]==1:return 0
        if obstacleGrid[0][0]==1:return 0

        dp=[[0 for _ in range(x) ] for _ in range(y)]
        #print(dp)
        #for x1 in range(x):
            #dp[y-1][x1]=1
        #for y1 in range(y):
            #dp[y1][x-1]=1

        for y2 in range(y-1,-1,-1):
            for x2 in range(x-1,-1,-1):
                if y2==y-1 and x2==x-1:
                    dp[y2][x2] =1
                    continue
                if obstacleGrid[y2][x2] ==1:continue #it is stone

                if x2==x-1: #reach the right
                    dp[y2][x2]=dp[y2+1][x2]
                elif y2==y-1: #bottom
                    dp[y2][x2]=dp[y2][x2+1]
                else:  #既不是石头，也不是右边和底边
                    dp[y2][x2]=dp[y2+1][x2]+dp[y2][x2+1]

        return dp[0][0]

```

题解，是从左上角向下推，我是从右下角，反推。

它是初始化后，再进入双重循环，而且利用原来的矩阵，我是新开辟空间。 
``` 
class Solution(object): 
    def uniquePathsWithObstacles(self, obstacleGrid: List[List[int]]) -> int:

        m = len(obstacleGrid)
        n = len(obstacleGrid[0])

        # If the starting cell has an obstacle, then simply return as there would be
        # no paths to the destination.
        if obstacleGrid[0][0] == 1:
            return 0

        # Number of ways of reaching the starting cell = 1.
        obstacleGrid[0][0] = 1

        # Filling the values for the first column
        for i in range(1,m):
            obstacleGrid[i][0] = int(obstacleGrid[i][0] == 0 and obstacleGrid[i-1][0] == 1)

        # Filling the values for the first row        
        for j in range(1, n):
            obstacleGrid[0][j] = int(obstacleGrid[0][j] == 0 and obstacleGrid[0][j-1] == 1)

        # Starting from cell(1,1) fill up the values
        # No. of ways of reaching cell[i][j] = cell[i - 1][j] + cell[i][j - 1]
        # i.e. From above and left.
        for i in range(1,m):
            for j in range(1,n):
                if obstacleGrid[i][j] == 0:
                    obstacleGrid[i][j] = obstacleGrid[i-1][j] + obstacleGrid[i][j-1]
                else:
                    obstacleGrid[i][j] = 0

        # Return value stored in rightmost bottommost cell. That is the destination.            
        return obstacleGrid[m-1][n-1]

作者：LeetCode
链接：https://leetcode-cn.com/problems/unique-paths-ii/solution/bu-tong-lu-jing-ii-by-leetcode/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。

```


```
#=============================
#快速排序上一种写法的优化，改用快慢指针
class Solution:
    def qsort(self,arr,begin,end):
        if begin>=end:return

        def findp(arr,start,last):
            #counter =start
            #pivot=last

            #改用快慢指针
            slow=start

            for fast in range(start,last):
                if arr[fast]<arr[last]:
                    arr[fast],arr[slow]=arr[slow],arr[fast]
                    slow+=1

            arr[last],arr[slow]=arr[slow],arr[last]
            return slow

        p=findp(arr,begin,end)
        self.qsort(arr,begin,p-1)
        self.qsort(arr,p+1,end)

cc=Solution()
aa=[440, 551, 2, 3444444, 5, 6, 107, 7, 79,99, 107, 7, 799,99, 134, 44,123,23,3333,66, 88,79999, 134, 44, 65,1,1,79999]
cc.qsort(aa,0,len(aa)-1)
print(aa)

```
