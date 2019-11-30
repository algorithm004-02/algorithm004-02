// 1. 冒泡
function bubblesort(arr) {
    var len = arr.length;
    for (let i = 0; i < len; i ++) {
        for (j = 0; j < len - i; j ++) {
            if (arr[j] > arr[j + 1]) {
                [arr[j], arr[j + 1]] = [arr[j + 1], arr[j]];
            }
        }
    }

    return arr;
}

// 2. 插入排序
function insertionSort(arr) {
    let len = arr.length;
   
    for (let i = 0; i < len - 1; i ++) {
        let cur = i;

        while(cur - 1 >= 0 && arr[cur - 1] > arr[cur]) {
            [arr[cur - 1], arr[cur]] = [arr[cur], arr[cur - 1]];
            cur --;
        }
    }

    return arr;
}

// 3. 选择排序
function selectionSort(arr) {
    let len = arr.length;
    let minIdx = 0;

    for (let i = 0; i < len; i ++) {
        minIdx = i;
        for (let j = i + 1; j < len;  j++) {
            if (arr[j] < arr[minIdx]) minIdx = j;
        }

        [arr[i], arr[minIdx]] = [arr[minIdx], arr[i]];
    }
}

// 4. 快速排序
function quickSort(arr, begin = 0, end = arr.length - 1) {
    if (begin >= end) return;

    let pivot = partition(begin, end);
    quickSort(arr, begin, pivot - 1);
    quickSort(arr, pivot + 1, end);
    
    function partition(begin, end) {
        let pivot = end;
        let counter = begin;

        for (let i = begin; i < end; i ++) {
            if (arr[i] < arr[pivot]) {
                let temp = arr[counter]; arr[counter] = arr[i]; arr[i] = temp;

                counter ++;
            }
        }

        let temp = arr[pivot]; arr[pivot] = arr[counter]; arr[counter] = temp;

        return counter;
    }
}

// 5. 归并排序
function mergeSort(array, left = 0, right = array.length - 1) {
    if (left >= right) return;

    let mid = (left + right) >> 1;

    mergeSort(array, left, mid);
    mergeSort(array, mid + 1, right);
    merge(array, left, mid, right);

    function merge(array, left, mid, right) {
        let i = left;
        let j = mid + 1;
        let k = 0;
        let tmp = [];
    
        while(i <= mid && j <= right) {
            tmp[k++] = array[i] <= array[j] ? array[i++] : array[j++];
        }
    
        while(i <= mid) temp[k++] = array[i++];
        while(j <= right) temp[k++] = array[j++];
    
        for(let p = 0; p < temp.length; p ++) {
            array[left + p] = temp[p];
        }
    }
}

// 6. 堆排序
