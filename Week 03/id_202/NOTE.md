# NOTE
############################################################# week03 ##############################################################

1、使用二分查找，寻找一个半有序数组 [4, 5, 6, 7, 0, 1, 2] 中间无序的地方
public Map<Integer, Integer> finTurningPoint(int nums[]) {
        Map<Integer, Integer> resultMap = new HashMap();
        if (nums.length == 1) {
            resultMap.put(0, nums[0]);
            return resultMap;
        }
        int left = 0, right = nums.length - 1;
        while (left < right) {
            int mid = (left + right) >> 1;
            if (nums[mid] > nums[mid + 1]) {
                resultMap.put(mid + 1, nums[mid + 1]);
                return resultMap;
            }
            if (nums[mid - 1] > nums[mid]) {
                resultMap.put(mid, nums[mid]);
                return resultMap;
            }
            //左有序，变化点在右侧
            if (nums[mid] > nums[0]) {
                left = mid + 1;
            } else {
                //右有序，变化点在左侧
                right = mid - 1;
            }
        }
        return resultMap;
    }  

2、学习总结

​	1、深度优先搜索：水滴掉入平静的水中引起的轻微荡漾，水纹一层层的扩散。

​	2、广度优先搜索：重复重复再重复，不撞南墙不回头，撞完南墙在回过头找墙撞。

​	3、贪心算法：只看眼前利益，从点看全局。

​	4、二分查找：有序、有界、每次杀一半。

