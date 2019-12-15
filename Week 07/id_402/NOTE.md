<h1>【402-Week 07】学习总结</h1>
```java
public class Selection_Sort {//选俳
    int[] sort (int[] num) {
        for (int i = 0; i < num.length; i++) {
            for (int j = i; j < num.length; j++) {
                int index = i;
                if (num[j] < num[i]) {
                    index = j;
                }
                int temp =  num[i]; num[i] = num[index]; num[index] = temp;
            }
        }
        return num;
    }
}

```





~~~java
public class Bubble_Sort {//冒泡
    int[] sort(int[] num) {
        int temp;
        for(int i=0;i<num.length-1;i++){
            for(int j=0;j<num.length-i-1;j++){
                if(num[j+1]<num[j]){
                    temp = num[j];
                    num[j] = num[j+1];
                    num[j+1] = temp;
                }
            }
        }
        return num;
    }
}

~~~



~~~java
public class Insertion_Sort {//插入排序
    int[] sort (int[] num) {
        int temp;
        for (int i=1; i < num.length; i++){
            if (num[i] < num[i-1]){
                temp = num[i];
                for (int j = i; j >= 0; j--){
                    if (j > 0 && num[j-1] > temp) {
                        num[j] = num[j-1];
                    } else {
                        num[j] = temp;
                        break;
                    }
                }
            }
        }
        return num;
    }

    int[] sort2 (int[] num) {//示例代码
        int len = num.length;
        int preIndex, current;
        for (var i = 1; i < len; i++) {
            preIndex = i - 1; //前一个下标
            current = num[i];//当前值
            while (preIndex >= 0 && num[preIndex] > current) {//如果 前一个下表大于0 并且 要比当前值大
                num[preIndex + 1] = num[preIndex]; //向后移动数组元素 知道 前一个元素小于当前元素
                preIndex--;
            }
            num[preIndex + 1] = current; //将当前元素赋值给该位置
        }
        return num;
    }
}

~~~

