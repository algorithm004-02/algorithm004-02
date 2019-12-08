# 第七周总结



## 位运算要点

判断奇偶：
x % 2 == 1 —> (x & 1) == 1
x % 2 == 0 —> (x & 1) == 0

x >> 1 —> x / 2

X = X & (X-1) 清零最低位的 1

X & -X => 得到最低位的 1

X & ~X => 0



## LRU Cache 

```java
class LRUCache {
        private Map<Integer, Integer> map;
        public LRUCache(int capacity) {
            map = new LinkedCappedHashMap<>(capacity);
        }
        public int get(int key) {
            if(!map.containsKey(key)) { return -1; }
            return map.get(key);
        }
        public void put(int key, int value) {
            map.put(key,value);
        }
        private static class LinkedCappedHashMap<K,V> extends LinkedHashMap<K,V> {
            int maximumCapacity;
            LinkedCappedHashMap(int maximumCapacity) {
                super(16, 0.75f, true);
                this.maximumCapacity = maximumCapacity;
            }
            protected boolean removeEldestEntry(Map.Entry eldest) {
                return size() > maximumCapacity;
            }
        }
}
```



## 排序算法

- 插入排序

```java
 public void insertSort(int [] a){
        int len=a.length;//单独把数组长度拿出来，提高效率
        int insertNum;//要插入的数
        for(int i=1;i<len;i++){//因为第一次不用，所以从1开始
            insertNum=a[i];
            int j=i-1;//序列元素个数
            while(j>=0&&a[j]>insertNum){//从后往前循环，将大于insertNum的数向后移动
                a[j+1]=a[j];//元素向后移动
                j--;
            }
            a[j+1]=insertNum;//找到位置，插入当前元素
        }
    }
```

- 希尔排序

```java
public void sheelSort(int [] a){
        int len=a.length;//单独把数组长度拿出来，提高效率
        while(len!=0){
            len=len/2;
            for(int i=0;i<len;i++){//分组
                for(int j=i+len;j<a.length;j+=len){//元素从第二个开始
                    int k=j-len;//k为有序序列最后一位的位数
                    int temp=a[j];//要插入的元素
                    /*for(;k>=0&&temp<a[k];k-=len){
                        a[k+len]=a[k];
                    }*/
                    while(k>=0&&temp<a[k]){//从后往前遍历
                        a[k+len]=a[k];
                        k-=len;//向后移动len位
                    }
                    a[k+len]=temp;
                }
            }
        }
    }
```

- 选择排序

```java
public void selectSort(int[]a){
        int len=a.length;
        for(int i=0;i<len;i++){//循环次数
            int value=a[i];
            int position=i;
            for(int j=i+1;j<len;j++){//找到最小的值和位置
                if(a[j]<value){
                    value=a[j];
                    position=j;
                }
            }
            a[position]=a[i];//进行交换
            a[i]=value;
        }
    }
```

- 堆排序

```java
public  void heapSort(int[] a){
           int len=a.length;
           //循环建堆  
           for(int i=0;i<len-1;i++){
               //建堆  
               buildMaxHeap(a,len-1-i);
               //交换堆顶和最后一个元素  
               swap(a,0,len-1-i);
           }
       }
        //交换方法
       private  void swap(int[] data, int i, int j) {
           int tmp=data[i];
           data[i]=data[j];
           data[j]=tmp;
       }
       //对data数组从0到lastIndex建大顶堆  
       private void buildMaxHeap(int[] data, int lastIndex) {
           //从lastIndex处节点（最后一个节点）的父节点开始  
           for(int i=(lastIndex-1)/2;i>=0;i--){
               //k保存正在判断的节点  
               int k=i;
               //如果当前k节点的子节点存在  
               while(k*2+1<=lastIndex){
                   //k节点的左子节点的索引  
                   int biggerIndex=2*k+1;
                   //如果biggerIndex小于lastIndex，即biggerIndex+1代表的k节点的右子节点存在  
                   if(biggerIndex<lastIndex){
                       //若果右子节点的值较大  
                       if(data[biggerIndex]<data[biggerIndex+1]){
                           //biggerIndex总是记录较大子节点的索引  
                           biggerIndex++;
                       }
                   }
                   //如果k节点的值小于其较大的子节点的值  
                   if(data[k]<data[biggerIndex]){
                       //交换他们  
                       swap(data,k,biggerIndex);
                       //将biggerIndex赋予k，开始while循环的下一次循环，重新保证k节点的值大于其左右子节点的值  
                       k=biggerIndex;
                   }else{
                       break;
                   }
               }
           }
       }
```

- 归并

```java
public  void mergeSort(int[] a, int left, int right) {  
           int t = 1;// 每组元素个数  
           int size = right - left + 1;  
           while (t < size) {  
               int s = t;// 本次循环每组元素个数  
               t = 2 * s;  
               int i = left;  
               while (i + (t - 1) < size) {  
                   merge(a, i, i + (s - 1), i + (t - 1));  
                   i += t;  
               }  
               if (i + (s - 1) < right)  
                   merge(a, i, i + (s - 1), right);  
           }  
        }  
       
        private static void merge(int[] data, int p, int q, int r) {  
           int[] B = new int[data.length];  
           int s = p;  
           int t = q + 1;  
           int k = p;  
           while (s <= q && t <= r) {  
               if (data[s] <= data[t]) {  
                   B[k] = data[s];  
                   s++;  
               } else {  
                   B[k] = data[t];  
                   t++;  
               }  
               k++;  
           }  
           if (s == q + 1)  
               B[k++] = data[t++];  
           else  
               B[k++] = data[s++];  
           for (int i = p; i <= r; i++)  
               data[i] = B[i];  
        }
```

- 冒泡排序

```java
public void bubbleSort(int []a){
           int len=a.length;
           for(int i=0;i<len;i++){
               for(int j=0;j<len-i-1;j++){//注意第二重循环的条件
                   if(a[j]>a[j+1]){
                       int temp=a[j];
                       a[j]=a[j+1];
                       a[j+1]=temp;
                   }
               }
           }
       }
```

- 快排

```java
public void quickSort(int[]a,int start,int end){
           if(start<end){
               int baseNum=a[start];//选基准值
               int midNum;//记录中间值
               int i=start;
               int j=end;
               do{
                   while((a[i]<baseNum)&&i<end){
                       i++;
                   }
                   while((a[j]>baseNum)&&j>start){
                       j--;
                   }
                   if(i<=j){
                       midNum=a[i];
                       a[i]=a[j];
                       a[j]=midNum;
                       i++;
                       j--;
                   }
               }while(i<=j);
                if(start<j){
                    quickSort(a,start,j);
                }       
                if(end>i){
                    quickSort(a,i,end);
                }
           }
       }
```

### 总结

一、稳定性:

　  稳定：冒泡排序、插入排序、归并排序和基数排序

　　不稳定：选择排序、快速排序、希尔排序、堆排序

二、平均时间复杂度

　　O(n^2):直接插入排序，简单选择排序，冒泡排序。

　　在数据规模较小时（9W内），直接插入排序，简单选择排序差不多。当数据较大时，冒泡排序算法的时间代价最高。性能为O(n^2)的算法基本上是相邻元素进行比较，基本上都是稳定的。

　　O(nlogn):快速排序，归并排序，希尔排序，堆排序。

　　其中，快排是最好的， 其次是归并和希尔，堆排序在数据量很大时效果明显。

三、排序算法的选择

　　1.数据规模较小

 　　（1）待排序列基本序的情况下，可以选择**直接插入排序**；

 　　（2）对稳定性不作要求宜用简单选择排序，对稳定性有要求宜用插入或冒泡

　　2.数据规模不是很大

　　（1）完全可以用内存空间，序列杂乱无序，对稳定性没有要求，**快速排序**，此时要付出log（N）的额外空间。

　　（2）序列本身可能有序，对稳定性有要求，空间允许下，宜用归并排序

　　3.数据规模很大

  　　（1）对稳定性有求，则可考虑归并排序。

  　　（2）对稳定性没要求，宜用堆排序

　　4.序列初始基本有序（正序），宜用直接插入，冒泡

 各算法复杂度如下：

![img](https://images2015.cnblogs.com/blog/1153367/201704/1153367-20170428162241834-892470604.png)





  

