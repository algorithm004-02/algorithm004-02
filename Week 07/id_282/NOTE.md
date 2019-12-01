### 第16课 位运算符

|含义|	运算符|	示例|
|:-:|:-:|:-:|
|左移|	<<	|0011=>0110
|右移|	>>	|0110=>0011
|按位或|	丨	|0011丨1011=>1011
|按位与|	&	|0011&1011=>0011
|按位取反|	~	|0011=>1100
|按位异或(相同为零不同为一)|	^	|0011^1011=>1000
##### XOR-异或
异或: 相同为0,不同为1.也可用"不进位加法"来理解
同位相加,超过1则置为0
异或操作的一些特点:
```js
x^0 = x
```
每个位与0异或保持不变
```js
x^1s = ~x //注意1s = ~0
```
每个位与1异或相当于取反)
```js
x^(~x) = 1s
```
用到"不同为1"的规律, 位与位取反后的异或结果为1
```js
x^x = 0
```
用到"相同为0"的规律, 位与位的异或为0
```js
c = a^b => a^c = b, b^c = a //交换两个数
a^b^c = a^(b^c)= (a^b)^c //associative
```
#### 指定位置的位运算
1、将x最右边的n位清零: x&(~0<<n)
>先创建111... 再左移空出n个0, 最后用111..00..与x与运算,将x的后n位清零

2、获取x的第n位值(0或者1): (x>>n)&1
>右移n次, x的第n位移动到最右, 与1与运算得出n位的值

3.获取x的第n位的幂值: x&(1<<(n-1))
>得出第n位后面的值, 将1左移n-1位, 变为100... , 与x与运算截取了x的n-1到最后一位的总值

4.仅将第n位置为1: x|(1<<n)
>1左移n位变为100.. ,与x或运算不改变n后的值, 而将n位置为1(1或运算一定为1)

5.仅将第n位置为0: x&(~(1<<n))
>1左移n位变为100.. ,取反后变为011.. ,与x与运算不该变n后的值,而将n位置为0(0与运算一定为0)
为什么要取反运算而不是减1取反, 是因为要进行与运算, 要保证高位数都为1, 默认为0取反后变为1

6.将x最高位至第n位(含)清零: x&((1<<n)-1)
>1左移n位变为100.. ,减1变为011.. ,与x与运算将包含n的高位全置为0, n后的位因为都是与1做与运算, 保持不变

7.将第n位至第0位(含)清零: x&(~((1<<(n+1))-1))
>1左移n+1位变为1000.. , 减一变为0111.. ,其中0在第n+1位, 取反后为1000.. ,与x与运算后会将n值第0位置为0, n+1至高位因为是与1与运算, 保持不变

##### 实战位运算要点
- 判断奇偶
>x%2==1 -> (x&1)==1
x%2==0 -> (x&1)==0
- x>>1 -> x/2
>即: x=x/2; -> x=x>>1;
mid=(left+right)/2; -> mid=(left+right)>>1;
- x=x&(x-1) 清零最低位的1
>x = 01101000
x-1= 01100111
& => 01100000
- x&-x => 得到最低位的1
>x = 01101000
~x = 10010111
-x = ~x + 1
-x = 10011000
& = 00001000
- x&~x => 0

### 第17课 布隆过滤器 Bloom Filter
一个很长的二进制向量和一系列随机映射函数. 布隆过滤器可以用于检索一个元素是否在一个集合中.

> **优点是空间效率和查询时间都远远超过一般的算法**
> **缺点是有一定的误识别率和删除困难**
##### 案例
- 比特币网络
- 分布式系统(Map-Reduce) - Hadoop、search engine
- Redis缓存
- 垃圾邮件、评论等的过滤
##### 扩展链接
布隆过滤器 Python 代码示例
```python
from bitarray import bitarray 
import mmh3 

class BloomFilter: 
	def __init__(self, size, hash_num): 
		self.size = size 
		self.hash_num = hash_num 
		self.bit_array = bitarray(size) 
		self.bit_array.setall(0) 

	def add(self, s): 
		for seed in range(self.hash_num): 
			result = mmh3.hash(s, seed) % self.size 
			self.bit_array[result] = 1 

	def lookup(self, s): 
		for seed in range(self.hash_num): 
			result = mmh3.hash(s, seed) % self.size 
			if self.bit_array[result] == 0: 
				return "Nope" 
		return "Probably" 

bf = BloomFilter(500000, 7) 
bf.add("dantezhao") 
print (bf.lookup("dantezhao")) 
print (bf.lookup("yyj")) 
```
- [布隆过滤器的原理和实现](https://www.cnblogs.com/cpselvis/p/6265825.html)
```python
import mmh3
from bitarray import bitarray


# zhihu_crawler.bloom_filter

# Implement a simple bloom filter with murmurhash algorithm.
# Bloom filter is used to check wether an element exists in a collection, and it has a good performance in big data situation.
# It may has positive rate depend on hash functions and elements count.



BIT_SIZE = 5000000

class BloomFilter:
    
    def __init__(self):
        # Initialize bloom filter, set size and all bits to 0
        bit_array = bitarray(BIT_SIZE)
        bit_array.setall(0)

        self.bit_array = bit_array
        
    def add(self, url):
        # Add a url, and set points in bitarray to 1 (Points count is equal to hash funcs count.)
        # Here use 7 hash functions.
        point_list = self.get_postions(url)

        for b in point_list:
            self.bit_array[b] = 1

    def contains(self, url):
        # Check if a url is in a collection
        point_list = self.get_postions(url)

        result = True
        for b in point_list:
            result = result and self.bit_array[b]
    
        return result

    def get_postions(self, url):
        # Get points positions in bit vector.
        point1 = mmh3.hash(url, 41) % BIT_SIZE
        point2 = mmh3.hash(url, 42) % BIT_SIZE
        point3 = mmh3.hash(url, 43) % BIT_SIZE
        point4 = mmh3.hash(url, 44) % BIT_SIZE
        point5 = mmh3.hash(url, 45) % BIT_SIZE
        point6 = mmh3.hash(url, 46) % BIT_SIZE
        point7 = mmh3.hash(url, 47) % BIT_SIZE


        return [point1, point2, point3, point4, point5, point6, point7]
```


[使用布隆过滤器解决缓存击穿、垃圾邮件识别、集合判重](https://blog.csdn.net/tianyaleixiaowu/article/details/74721877)

#### LRU Cache
##### Cache缓存
1、记忆
2、钱包 - 储物柜
3、代码模块
##### LRU Cache
- 两个要素: 大小、替换策略
- Hash Table + Double LinkedList
- O(1)查询 O(1)修改、更新
##### 替换策略
- LFU - least frequently used
- LRU - least recently used


### 第18课 排序算法
1、比较类排序:
通过比较来决定元素间的相对次序, 由于其时间复杂度不能突破O(nlogn), 因此也称为非线性时间比较类排序.

2、非比较类排序:
不通过比较来决定元素间的相对次序, 它可以突破基于比较排序的时间下界, 以线性时间运行, 因此也称为线性时间非比较类排序.

|排序方法	|时间复杂度(平均)	|时间复杂度(最坏)	|时间复杂度(最好)	|空间复杂度	|稳定性|
|:-:|:-:|:-:|:-:|:-:|:-:|
|插入排序	|O(n^2)	|O(n^2)	|O(n)	|O(1)	|稳定|
|希尔排序	|O(n^1.3)	|O(n^2)	|O(n)	|O(1)	|不稳定|
|选择排序	|O(n^2)	|O(n^2)	|O(n^2)	|O(1)	|不稳定|
|堆排序	|O(nlogn)|	O(nlogn)|	O(nlogn)|	O(1)|	不稳定|
|冒泡排序	|O(n^2)	|O(n^2)	|O(n)	|O(1)	|稳定|
|快速排序	|O(nlogn)	|O(n^2)	|O(nlogn)	|O(nlogn)	|不稳定|
|归并排序	|O(nlogn)	|O(nlogn)	|O(nlogn)	|O(n)	|稳定|
|计数排序	|O(n+k)	|O(n+k)	|O(n+k)	|O(n+k)	|稳定|
|桶排序	|O(n+k)	|O(n^2)	|O(n)	|O(n+k)	|稳定|
|基数排序	|O(n*k)	|O(n*k)	|O(n*k)	|O(n+k)	|稳定|

##### 初级排序 - O(n^2)
1、选择排序(Selection Sort)
每次找最小值, 然后放到待排序数组的起始位置.

2、插入排序(Insertion Sort)
从前到后逐步构建有序序列; 对于未排序数据, 在已排序序列中从后向前扫描, 找到相应位置并插入

3、冒泡排序(Bubble Sort)
嵌套循环, 每次查看相邻的元素如果逆序, 则交换

##### 高级排序 - O(N*LognN)
1、快速排序(Quick Sort)
>数组取标杆pivot, 将小元素放pivot左边, 大元素放右侧, 然后依次对右边和右边的子数组继续快排; 以达到整个序列有序
```java
public static void quickSort(int[] array, int begin, int end){
    if(end <= begin) return;
    int pivot = partition(array, begin, end);
    quickSort(array, begin, pivot - 1);
    quickSort(array, pivot + 1, end);
}

static int partition(int[] a, int begin, int end){
    // pivot: 标杆位置, counter: 小于pivot的元素的个数
    int pivot = end, counter = begin;
    for(int i = begin; i < end; i++){
        if(a[i] < a[pivot]){
            int temp = a[counter];
            a[counter] = a[i];
            a[i] = temp;
            counter++;
        }
    }
    int temp = a[pivot];
    a[pivot] = a[counter];
    a[counter] = temp;
    return counter;
}
```
2、归并排序(Merge Sort) - 分治
>把长度为n的输入序列分成两个长度为n/2的子序列;
对这两个子序列分别采用归并排序
将两个排序好的子序列合并成一个最终的排序序列
```java
public static void mergeSort(int[] array, int left, int right){
    if(right <= left) return;
    int mid = (left + right) >> 1; // (left + right) / 2
    
    mergeSort(array, left, mid);
    mergeSort(array, mid + 1, right);
    merge(array, left, mid, right);
}

public static void merge(int[] arr, int left, int mid, int right){
    int[] temp = new int[right - left + 1]; // 中间数组
    int i = left, j = mid + 1, k = 0;
    
    while(i <= mid && j <= right){
        temp[k++] = arr[i] <= arr[j] ? arr[i++] : arr[j++];
    }
    while(i <= mid) temp[k++] = arr[i++];
    while(j <= right) temp[k++] = arr[j++];
    
    for(int p = 0; p < temp.length; p++){
        arr[left + p] = temp[p];
    }
    // 也可以用 System.arraycopy(a, start1, b, start2, length);
}
```
##### 快排 VS 归并
1.归并 和 快排 具有相似性, 但步骤顺序相反
2.归并: 先排序左右子数组, 然后合并两个有序子数组
3.快排: 先调配出左右子数组, 然后对左右子数组进行排序

##### 堆排序(Heap Sort) - 堆插入O(logN), 取最大/小值O(1)
>数组元素依次建立小顶堆
>依次取堆顶元素, 并删除
```java
void head_sort(int a[], int len){
    priority_queue<int, vector<int>, greater<int>> q;
    
    for(int i = 0; i < len; i++){
        q.push(a[i]);
    }
    
    for(int i= 0; i < len; i++){
        a[i] = q.pop();
    }
}
```
```java
static void heapify(int[] array, int length, int i){
    int left = 2 * i + 1, right = 2 * i - 2;
    int largest = i;
    
    if(left < length && array[left] > array[largest]){
        largest = leftChild;
    }
    if(right < length && array[right] > array[largest]){
        largest = right;
    }
    
    if(largest != i){
        int temp = array[i];
        array[i] = array[largest];
        array[largest] = temp;
        heapify(array, length, largest);
    }
}

public static void headSort(int[] array){
    if(array.length == 0) return;
    
    int length = array.length;
    for(int i = length / 2 - 1; i >= 0; i--){
        heapify(array, length, i);
    }
    
    for(int i = length - 1; i >= 0; i--){
        int temp = array[0];
        array[0] = array[i];
        array[i] = temp;
        heapify(array, i, 0);
    }
}
```