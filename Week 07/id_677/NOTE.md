# NOTE
```
数据结构与算法，相辅相成，互为补充。参加训练营的核心目标之一就是提升自己的硬核知识能力，进而更好的去实现产品落地能力。本周知识点在工业环境中都有相关应用场景。
位运算，在JDK的源码中多次使用，如线程池类ThreadPoolExecutor中，使用位运算操作使得并发任务执行更加高效，个人觉得有点儿黑科技，模拟计算机的数据存储与计算方式，逆人性，但是效率喜人。
BloomFilter & LRU Cache，在计算机系统的核心组件Cache中应用广泛使用，BloomFilter可以作为缓存命中器，拦截绝大多数Miss情况；LRU Cache的替换算法，可以根据实际情况自行扩展实现，更加人性化，老师引申出替换算法可以通过AI程序来实现。
排序算法，老生常谈，经久不衰。核心指标：时间复杂度、空间复杂度、是够稳定排序、是否原地排序
```

## 选择排序
```
public class SelectionSort {
    public void sort(int[] nums) {
        if (nums == null) return;
        for (int i = 0; i < nums.length - 1; i++) {
            int min = i;
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[j] < nums[min]) {
                    min = j;
                }
            }
            // swap
            int tmp = nums[i];
            nums[i] = nums[min];
            nums[min] = tmp;
        }
    }

    public static void main(String[] args) {
        int[] data = new int[] {3, 8, 9, 0, 1, 4, 2, 7};
        SelectionSort s = new SelectionSort();
        s.sort(data);
        for (int i = 0; i < data.length; i++) {
            System.out.print(data[i] + ",");
        }
    }
}
```
