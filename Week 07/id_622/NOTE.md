# NOTE

## 位运算
位运算是计算机的最基础的操作，二进制数在编程珠玑这本书中一开始就提到了。  
位运算在实际的开发过程中使用的非常少了，主要是因为现在的计算机硬件性能飞速提升，不需要考虑特别极端的性能和存储的问题。在硬件开发过程中，位运算可以用来存储一些状态。  
### 实战中常用运算
#### 取模
n % 2 == 1 等价于 n & 1 == 1
n % 2 == 0 等价于 n & 1 == 0
#### 除二
n // 2 等价于 n >> 1
#### 清零最低位的1
n & (n - 1)
#### 得到最低位的1
n & -n (补码)
#### 取0
n & ~n  
### N皇后问题的位运算
N皇后问题采用位运算可以提高效率，一开始理解非常晦涩，代码都没看懂。通过调试也没有理解。再看一遍视频，先从正常的思路理解N皇后问题。既如果使用位运算，则一开始所有位是全部可填写的，以四皇后为例：  
起始阶段：所有位置都为1111，那思路是如何通过col, pie, na用二进制的方法找到所有可填写的空位，既不为0的位。  
逻辑终止条件：递归终止条件为row和N相等，此处引入逻辑终止条件，既如果所有位置都为0000了，则可以逻辑终止。此时验证N个皇后都摆放完成，且没有空位可以供摆放。  
所以问题转化为如何高效的找到可放置王后的位置  


## 布隆过滤器 Bloom Filter
Bloom Filter，用来判断某个元素在某个结果中是否存在，由于设计原理的问题，会导致如下结果：  
**如果某个元素在Bloom Filter中判断为不存在的话，则它一定不存在。如果判断它为存在的话，它可能存在**  
### 实现原理
1. 初始化  
初始化一个给定长度的数组，设定为Bloom Filter的存储，设置一个对给定元素的哈希处理生成的结果的长度，**长度是否有讲究？**  
2. 插入操作  
对给定的元素做哈希处理，计算出这个元素在Bloom Filter中所处的位置（**名词表述不准确，需要修改**），并且插入。代码设计过程中需要小心，要对hash长度取模，防止溢出  
3. 查询操作
对给定的元素做哈希处理，计算出这个元素在Bloom Filter中所处的位置，查询对应位置是否存在，如果不存在，则返回不存在。如果都存在，则判断为可能存在，哈希冲突的原因。（**提升平衡因子可以提高准确率，哈希函数的选择**）  
参考：https://www.geeksforgeeks.org/bloom-filters-introduction-and-python-implementation/  
### Code
```Python
from bitarray import bitarray
import mmh3
class BloomFilter:
    def __init__(self, size, hash_size):
        self.size = size
        self.hash_size = hash_size
        self.bit_array = bitarray(size)
        self.bit_array.setall(0)

    def add(self, key):
        for v in range(self.hash_size):
            result = mmh3.hash(key, v) % self.size # 防止溢出
            self.bit_array[result] = 1

    def get(self, key):
        for v in range(self.hash_size):
            result = mmh3.hash(key, v) % self.size
            if self.bit_array[result] != 1:
                return -1
        return "Probably"
```
### 用途
主要用于判断数据是否存在，节约请求的次数  

## LRU Cache (Least Recently Used Cache)
LRU Cache，如其名，最近使用的缓存，主要由HashTable和Doubled-LinkedList构成，查询复杂度O(1)，修改，更新复杂度也为O(1)。Hashtable中除了存key以外，最好能存储位置信息，提升查询速度    
### 实现原理
1. 初始化长度为N的Double-LinkedList，初始化一个dictionary用于存储，用来判断是否存在（保障速度O（1）的查询）  
2. **插入操作：**插入前先去判断是否存在，如果存在，则进行替换操作，如果不存在，则进行插入操作。插入操作还需要区分是否Cache是满的，如果是满的，则淘汰最后一个，如果有剩余空间，则插入头部head。注意更新Hashtable中的位置信息    
3. **替换操作：**替换操作直接找到对应的位置，进行一次操作，并且需要更新Hashtable中的位置信息  
```Python
from collections import OrderedDict
class LRUCache:
    """
    此题用orderdictionary
    OrderedDict(), 字典的子类，保存了他们被添加的顺序
    """
    def __init__(self, capacity):
        self.dict = OrderedDict()
        self.capacity = capacity

    def get(self, key):
        if key not in self.dict:
            return -1
        v = self.dict.pop(key)
        self.dict[key] = v # 利用了OrderedDict的特性，处理了排序的问题
        return v

    def put(self, key, val):
        if key not in self.dict:
            if self.capacity > 0:
                self.capacity -= 1
            else:
                self.dict.popitem(last=False)
        else:
            self.dict.pop(key)
        self.dict[key] = val
```

## 排序算法
排序算法分为比较类排序和非比较类排序
### 比较类排序
通过比较元素来决定元素的次序，时间复杂度为O(nlogn)，时间是非线性的。常见的有选择排序，插入排序，冒泡排序，堆排序，归并排序，快速排序等
### 非比较类排序
不通过比较元素来决定元素的次序，可以以线性的时间运行，常见技术排序，基数排序，桶排序

### 初级排序
#### 选择排序 Selection Sort
选择排序：  
step 1: 从begin下标（初始为0）开始遍历整个数组，找出最小的数  
step 2: 把找出最小的数与第一个数进行交换，并且begin下标右移  
step 3: 继续处理step1，直到数组有序  
```Python
def selectionSort(self, nums):
    n = len(nums)
    for i in range(n):
        min_index = i
        for j in range(i + 1, n):
            if nums[min_index] > nums[j]:
                min_index = j
        nums[i], nums[min_index] = nums[min_index], nums[i]
    return nums
```
#### 插入排序 Insertion Sort
插入排序：  
step 1: 从begin下标（初始为0）开始往后查一个数  
step 2: 用查到的数与begin之前的有序数组从后往前比较，假设查到数组下标为N，则比较N - 1 到 begin  
step 2.1: 如果查到的数nums[n]小于nums[n - 1]的话，交换两个元素位置，并继续往前查  
step 3: 重复操作，直到数组有序  
```Python
def insertionSort(self, nums):
    n = len(nums)
    for i in range(1, n):
        for j in range(i, 0, -1):
            if nums[j] < nums[j - 1]:
                nums[j], nums[j - 1] = nums[j - 1], nums[j]
            else:
                break
    return nums
```
#### 冒泡排序 Bubble Sort
冒泡排序：  
step 1: 从头到尾遍历数组，相邻数组两两比较，下标为n  
step 1.1: 如果nums[n] > nums[n - 1]的话，则交换两个数的位置  
step 2: 循环以后则最大的数则会到最后一位  
step 3: 每次遍历以后则重新开始只需要遍历前面无序的数 
```Python
def bubbleSort(self, nums):
    n = len(nums)
    for i in range(n - 1):
        for j in range(n - 1 - i):
            if nums[j] > nums[j + 1]:
                nums[j], nums[j + 1] = nums[j + 1], nums[j]
    return nums
```
#### 快速排序 Quick Sort
快速排序：  
step 1: 对数组进行partition操作，参数nums, begin, end  
step 2: 选择start, end或者之间任意的数做为pivot  
step 3: 设置一个计数器counter，初始值为0（+offset），或者直接用begin  
step 4: 当从头到尾遍历时，找到一个数小于或者大于pivot数时，则counter加一  
step 5: 当遍历完以后，交换pivot和counter的元素的位置，此时pivot就在正确的位置上  
step 6: 分别处理pivot左边的数组和pivot右边的数组
```Python
def quickSort(self, nums, begin, end):
    # terminator
    if end <= begin:
        return
    pivot = self.partition(nums, begin, end)
    self.quickSort(nums, begin, pivot - 1)
    self.quickSort(nums, pivot + 1, end)

def partition(self, nums, begin, end):
    pivot = end
    counter = begin
    n = len(nums)
    for i in range(begin, pivot):
        if nums[i] < nums[pivot]:
            nums[i], nums[counter] = nums[counter], nums[i]
            counter += 1
    nums[counter], nums[pivot] = nums[pivot], nums[counter]
    return counter
```
#### 归并排序 Merge Sort  
归并排序：  
step 1: 对数组进行左右拆分，一般取中间值  
step 2: 对左右的数组进行递归  
step 3: 合并最终的结果  
step 3.1: 比较Left和Right的大小，两边都遍历完  
step 3.2: 把左右较小的值先替换数组中  
step 3.3: 剩余的左值或者优值再写入数组中  
```Python
def mergeSort(self, nums):
    if len(nums) > 1:
        mid = len(nums) >> 1
        Left = nums[:mid]
        Right = nums[mid:]

        mergeSort(Left)
        mergeSort(Right)

        i = j = k = 0

        while i < len(Left) and j < len(Right):
            if Left[i] < Right[j]:
                nums[k] = Left[i]
                i += 1
            else:
                nums[k] = Right[j]
                j += 1
            k += 1

        while i < len(Left):
            nums[k] = Left[i]
            i += 1
            k += 1

        while j < len(Right):
            nums[k] = Right[j]
            j += 1
            k += 1
```


