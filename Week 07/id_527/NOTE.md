# NOTE

## 位运算

### 异或

> 相同为 `0`，不同为 `1`。（不进位加法）

交换两个数：

`c = a ^ b` => `a ^ c = b` => `b ^ c = a`

### 指定位置的位运算

1. 将 `x` 最右边的 `n` 位清零：`x & (~0 << n)`

2. 获取 `x` 的第 `n` 位值（`0` 或者 `1`）：`(x >> n) & 1`

3. 获取 `x` 的第 `n` 位的幂值：`x & (1 << (n-1))`

4. 仅将第 `n` 位置为 `1`：`x | (1 << n)`

5. 仅将第 `n` 位置为 `0`：`x & (~ (1 << n))`

6. 将 `x` 最高位至第 `n` 位（含）清零：`x & ((1 << n) - 1)`

7. 将第 `n` 位至第 `0` 位（含）清零：`x & (~((1 << (n + 1)) - 1))`

### 位运算要点

- 判断奇偶：

  `x % 2 == 1` -> `(x & 1) == 1`

  `x % 2 == 0` -> `(x & 1) == 0`

- `x >> 1` -> x / 2

  > 即：`x = x / 2` -> `x = x >> 1`

  `mid = (left + right) / 2` -> `mid = left + (right - left) >> 1`

- 清零最低为的 `1`：`x = x & (x - 1)`

- 得到最低位的 `1`：`x & -x`

### N 皇后位运算代码示例

```python
def totalNQueens(self, n):
	if n < 1: return []
	self.count = 0
	self.DFS(n, 0, 0, 0, 0)
	return self.count

def DFS(self, n, row, cols, pie, na):
	# recursion terminator
	if row >= n:
		self.count += 1
		return

	bits = (~(cols | pie | na)) & ((1 << n) — 1)  # 得到当前所有的空位

	while bits:
		p = bits & —bits # 取到最低位的1
		bits = bits & (bits — 1) # 表示在p位置上放入皇后
		self.DFS(n, row + 1, cols | p, (pie | p) << 1, (na | p) >> 1)
        # 不需要revert  cols, pie, na 的状态
```

```java
class Solution {
	private int size;
	private int count;

	private void solve(int row, int ld, int rd) {
		if (row == size) {
			count++;
			return;
		}
		int pos = size & (~(row | ld | rd));
		while (pos != 0) {
			int p = pos & (-pos);
			pos -= p; // pos &= pos - 1;
			solve(row | p, (ld | p) << 1, (rd | p) >> 1);
		}
	}

    public int totalNQueens(int n) {
        count = 0;
        size = (1 << n) - 1;
        solve(0, 0, 0);
        return count;
    }
}
```

## 布隆过滤器

一个很长的二进制向量和一系列随即映射函数。

- 用途：检索一个元素是否在一个集合中。

- **优点**：空间效率和查询时间都远远超过一般算法。

- **缺点**：有一定的误识别率和删除困难。如果判断不存在，则一定不存在，如果判断存在则不一定存在。

- 案例：

  1. 比特币网络

  2. 分布式系统（Map-Reduce）——Hadoop、search engine

  3. Redis 缓存

  4. 垃圾邮件、评论等过滤

[布隆过滤器的原理和实现](https://www.cnblogs.com/cpselvis/p/6265825.html)

[使用布隆过滤器解决缓存击穿、垃圾邮件识别、集合判重](https://blog.csdn.net/tianyaleixiaowu/article/details/74721877)

### 布隆过滤器 Python 代码示例

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

[布隆过滤器 Java 实现示例 1](https://github.com/lovasoa/bloomfilter/blob/master/src/main/java/BloomFilter.java)

[布隆过滤器 Java 实现示例 2](https://github.com/Baqend/Orestes-Bloomfilter)

## LRU Cache

- 两个要素：大小、替换策略

- `HashTable` + `DoubleLinkedList`

- 查询、修改、更新 皆为 `O(1)`

### LRU Cache Python 代码示例

```python
class LRUCache(object):

	def __init__(self, capacity):
		self.dic = collections.OrderedDict()
		self.remain = capacity

	def get(self, key):
		if key not in self.dic:
			return -1
		v = self.dic.pop(key)
		self.dic[key] = v   # key as the newest one
		return v

	def put(self, key, value):
		if key in self.dic:
			self.dic.pop(key)
		else:
			if self.remain > 0:
				self.remain -= 1
			else:   # self.dic is full
				self.dic.popitem(last=False)
		self.dic[key] = value
```

## 排序算法

- 比较类排序

    通过比较来决定元素间的相对次序，由于其时间复杂度不能突破 `O(nlogn)`，因此也成为非线性时间比较类排序。

- 非比较类排序

    不通过比较来决定元素间的相对次序，它可以突破基于比较排序的时间下界，以线性时间运行，因此也成为线性时间比较类排序。

[十大经典排序算法](https://www.cnblogs.com/onepixel/p/7674659.html)

### 初级排序 - O(n^2)

1. 选择排序（`Selection Sort`）

   每次找到最小值，然后放到待排序数组的起始位置。

2. 插入排序（`Insertion Sort`）

   从前到后逐步构建有序序列。对于未排序数据，在已排序序列中从后向前扫描，找到相应位置并插入。

3. 冒泡排序（`Bubble Sort`）

   嵌套循环，每次查看相邻的元素如果逆序，则交换。

### 高级排序 - O(N\*LogN)

1. 快速排序（`Quick Sort`）

   数组取标杆 `pivot`，将小元素放 `pivot` 左侧，大元素放右侧，然后依次对左右子数组继续快排，以达到整个序列有序。

#### 快速排序代码示例

```java
public static void quickSort(int[] array, int begin, int end) {
    if (end <= begin) return;
    int pivot = partition(array, begin, end);
    quickSort(array, begin, pivot - 1);
    quickSort(array, pivot + 1, end);
}

static int partition(int[] a, int begin, int end) {
    // pivot: 标杆位置，counter: 小于pivot的元素的个数
    int pivot = end, counter = begin;
    for (int i = begin; i < end; i++) {
        if (a[i] < a[pivot]) {
            int temp = a[counter]; a[counter] = a[i]; a[i] = temp;
            counter++;
        }
    }
    int temp = a[pivot]; a[pivot] = a[counter]; a[counter] = temp;
    return counter;
}
```

2. 归并排序（`Merge Sort`）——分治

   1. 把长度为 `n` 的输入序列分成两个长度为 `n/2` 的子序列。

   2. 对这两个子序列分别采用归并排序。

   3. 将两个排序好的子序列合并成一个最终的排序序列。

#### 归并排序代码示例

```java
public static void mergeSort(int[] array, int left, int right) {

    if (right <= left) return;
    int mid = (left + right) >> 1; // (left + right) / 2

    mergeSort(array, left, mid);
    mergeSort(array, mid + 1, right);
    merge(array, left, mid, right);

}

public static void merge(int[] arr, int left, int mid, int right) {
    int[] temp = new int[right - left + 1]; // 中间数组
    int i = left, j = mid + 1, k = 0;

    while (i <= mid && j <= right) {
        temp[k++] = arr[i] <= arr[j] ? arr[i++] : arr[j++];
    }

    while (i <= mid)   temp[k++] = arr[i++];
    while (j <= right) temp[k++] = arr[j++];

    for (int p = 0; p < temp.length; p++) {
        arr[left + p] = temp[p];
    }
    // 也可以用 System.arraycopy(a, start1, b, start2, length)
}
```

3. 堆排序（`Heap Sort`）——堆插入 `O(logN)`，取最大/最小值 `O(1)`

   1. 数组元素依次建立小顶堆

   2. 依次取堆顶元素并删除

#### 堆排序代码示例

```java
static void heapify(int[] array, int length, int i) {
    int left = 2 * i + 1, right = 2 * i + 2；
    int largest = i;

    if (left < length && array[left] > array[largest]) {
        largest = left;
    }
    if (right < length && array[right] > array[largest]) {
        largest = right;
    }

    if (largest != i) {
        int temp = array[i]; array[i] = array[largest]; array[largest] = temp;
        heapify(array, length, largest);
    }
}

public static void heapSort(int[] array) {
    if (array.length == 0) return;

    int length = array.length;
    for (int i = length / 2-1; i >= 0; i-) 
        heapify(array, length, i);

    for (int i = length - 1; i >= 0; i--) {
        int temp = array[0]; array[0] = array[i]; array[i] = temp;
        heapify(array, i, 0);
    }
}
```

