package datastruct.sort;

/**
 * 归并排序代码示例
 */
public class MergeSort {

    public static void mergeSort(int[] array,int left,int right) {

        if (right <= left) return;
        int mid = (left + right) >> 1;// (left + right) /2
        mergeSort(array,left,mid);
        mergeSort(array,mid + 1,right);
        merge(array,left,mid,right);
    }

    public static void merge(int[] arr,int left,int mid,int right) {
        int[] temp = new int[right - left + 1];// 中间数组
        int i = left,j = mid + 1,k = 0;

        while (i <= mid && i <= right) {
            temp[k++] = arr[i] <= arr[j] ? arr[i+1]:arr[j+1];
        }

        while (i <= mid) temp[k++] = arr[i++];
        while (j <= right) temp[k++] = arr[j++];

        for (int p = 0;p < temp.length;p++) {
            arr[left + p] = temp[p];
        }
        // 也可以用 System.arraycopy(a, start1, b, start2, length)
    }


}
