# NOTE

### 基础堆排序的练习
```java
public class MainClass {
    public static void main(String[] args) {
       int[] a = {1,2,5,9,3,6,7,11,4,8,10};
        //bubbleSort(a);
        //selectionSort(a);
        //selectionSort2(a);
        //insertSort(a);
        //quickSort(a);
        //mergeSort(a);
        heapSort(a);
        System.out.println(Arrays.toString(a));
    }
    /**
     * 冒泡排序：相邻的两个元素两两比较，大的往后，小的往前。每一轮下来，最末位的那个元素就是最大的
     * 冒牌排序属于稳定排序算法，因为只有大的时候才交换，不会改变值一样的数据的相对顺序
     * @param a a
     */
    private static void bubbleSort(int[] a) {
        for(int i = 0; i < a.length;i++) {
            for (int j = 0; j < a.length - i - 1; j++) {
                if (a[j] > a[j + 1]) {
                    int temp = a[j + 1];
                    a[j + 1] = a[j];
                    a[j] = temp;
                }
            }
        }
    }

    /**
     * 选择排序：每次从未排序区间选择最小值，放入已排序区间的末尾
     * 选择排序算法不稳定，可能会破坏值相同的元素的相对顺序。
     * @param a a
     */
    private static void selectionSort(int[] a) {
        for (int i = 0; i < a.length; i++) {
            for (int j = i + 1;j < a.length; j++) {
                if(a[j] < a[i]) {
                    int temp = a[i];
                    a[i] = a[j];
                    a[j] = temp;
                }
            }
        }
    }

    /**
     * 选择排序：每次从未排序区间选择最小值，放入已排序区间的末尾
     * 选择排序算法不稳定，可能会破坏值相同的元素的相对顺序。
     * 选择排序算法的优化：避免数据交换多次，只在每次循环中找出最小值的额时候才交换。
     * @param a a
     */
    private static void selectionSort2(int[] a) {
        for (int i = 0; i < a.length - 1; i++) {
            int minIndex = i;
            for (int j = i + 1;j < a.length; j++) {
                if(a[j] < a[minIndex]) {
                   minIndex = j;
                }
            }
            int temp = a[i];
            a[i] = a[minIndex];
            a[minIndex] = temp;

        }
    }

    /**
     * 插入排序。插入排序是从未排序区间找一个元素，插入到已排序区间里面对应的位置
     * 插入排序是稳定排序。不会破坏元素的相对顺序
     * @param a a
     */
    private static void insertSort(int[] a) {
        for (int i = 1; i < a.length; i++) {
            int preIndex = i - 1;//已经有序的index
            int current = a[i];
            while (preIndex >= 0 && a[preIndex] > current) {
                a[preIndex + 1] = a[preIndex];
                preIndex--;
            }
            a[preIndex + 1] = current;
        }
    }

    /**
     * 快速排序，快速排序的原理是找到一个分区点，然后分区点左边的元素必须比分区点右边的元素小。
     * 然后再分治对分区点坐右边进行快速排序。不稳定，会破坏相对顺序
     * @param a a
     */
    private static void quickSort(int[] a) {
        quickSort(a,0,a.length - 1);
    }
    private static void quickSort(int[] a, int begin, int end) {
        if (begin >= end) {
            return;
        }
        int pivot = partion(a,begin,end);
        quickSort(a,begin,pivot - 1);
        quickSort(a,pivot + 1,end);
    }
    /**
     * 快速排序的分区函数
     * @param a a
     * @param begin begin
     * @param end end
     * @return ;
     */
    private static int partion(int[] a, int begin, int end) {
        //选择一个分区点
        int pivot = end;
        int beginIndex = begin;
        for(int i = begin; i < end; i++) {
            if(a[i] < a[pivot]) {
                int temp = a[beginIndex];
                a[beginIndex ++] = a[i];
                a[i] = temp;
            }
        }
        int temp = a[beginIndex];
        a[beginIndex] = a[pivot];
        a[pivot] = temp;
        return beginIndex;
    }

    /**
     * 归并排序: 先对左右两边进行排序。排序好了进行合并。
     * 属于分治算法
     * 稳定排序。因为归并时，值为左边的可以先放.
     * @param a a
     */
    private static void mergeSort(int[] a) {
        mergeSort(a,0,a.length - 1);
    }

    private static void mergeSort(int[] a, int begin, int end) {
        if (end <= begin){
            return;
        }
        
        int mid = (begin + end) >> 1;
        mergeSort(a, begin, mid);
        mergeSort(a, mid + 1, end);
        merge(a, begin, mid, end);

    }
    /**
     * 将2边的排序结果合并
     * @param a a
     * @param begin begin
     * @param mid mid
     * @param end end
     */
    private static void merge(int[] a, int begin, int mid, int end) {
         int[] temp  = new int[end - begin + 1];
         int i = begin,j = mid + 1,k = 0;
         while (i <= mid && j <= end) {
             temp[k++] = a[i] <= a[j] ? a[i++] : a[j++];
         }
         while (i <= mid){ temp[k++] = a[i++]; }
         while (j <= end){ temp[k++] = a[j++]; }
         //将结果拷贝回原数组
        for(int p = 0; p < temp.length; p++) {                  
            a[begin + p] = temp[p];
        }
    }

    /**
     * 堆排序
     * @param a  a
     */
    private static void heapSort(int[] a) {
        int[] temp = new int[a.length];
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
        for (int i = 0; i < a.length; i++) {
           priorityQueue.add(a[i]);
        }
        int index = 0;
        while (!priorityQueue.isEmpty()){
            temp[index++] = priorityQueue.poll();
        }
        //排好序的数组
        System.out.println(Arrays.toString(temp));
    }
}
```
  

