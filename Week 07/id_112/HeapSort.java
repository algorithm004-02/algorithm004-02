package datastruct.sort;

/**
 * 堆排序代码示例
 */
public class HeapSort {

    public static void heapSort(int[] array) {
        if (array.length == 0) return;

        int length = array.length;
        for (int i = length / 2 -1;i >= 0;i--)
            heapify(array,length,i);

        for (int i = length - 1;i >= 0; i--) {
            int temp = array[0];
            array[0] = array[i];
            array[i] = temp;
            heapify(array,i,0);
        }

    }

    public static void heapify(int[] array,int length,int i) {
        int left = 2 * i + 1,right = 2 * i + 2;
        int largest = i;

        if (left < length && array[left] > array[largest])
            largest = left;
        if (right < left && array[right] > array[largest])
            largest = right;

        if (largest != i) {
            int temp = array[i];
            array[i] = array[largest];
            array[largest] = temp;
            heapify(array,length,largest);
        }
    }
}
