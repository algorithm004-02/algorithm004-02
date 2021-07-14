# 几种排序算法的写法
* 冒泡排序
  ```javascript
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
  ```
* 插入排序  
  ```javascript
    function insertionSort(arr) {
        let len = arr.length;
    
        for (let i = 0; i < len; i ++) {
            let cur = i;

            while(cur - 1 >= 0 && arr[cur - 1] > arr[cur]) {
                [arr[cur - 1], arr[cur]] = [arr[cur], arr[cur - 1]];
                cur --;
            }
        }

        return arr;
    }
  ```
* 选择排序
  ```javascript
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
  ```
* 快速排序
* 归并排序
