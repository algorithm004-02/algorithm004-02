//最笨的办法，暴力翻转
class Solution {
    public void rotate(int[] nums, int k) {
        int tail,temp;
        for(int i = 0; i < k; i++) {
            tail = nums[nums.length - 1]; //将最后一个元素 提出
            for (int j = 0; j < nums.length; j++) { // 从第一个元素开始，依次向后进行替换。
                temp = nums[j]; //向后位移
                nums[j] = tail;
                tail = temp;
            }
        }
    }
}

//思路2：数组翻转
class Solution {
    public void rotate(int[] nums, int k) {
        k %= nums.length;
        reserve(nums,1,nums.length);
        reserve(nums,1,k++);
        reserve(nums,k ,nums.length);
    }

    private void reserve(int[] nums, int start, int end){//制定坐标 反转链表
        while (start < end) {
            nums[start -1] = nums[start -1]^ nums[end -1];
            nums[end -1] = nums[start -1]^ nums[end -1];
            nums[start -1] = nums[start -1]^ nums[end -1];
            start ++;
            end --;
        }
    }
}

//思路3：使用环状替换
//自己代码 过大数组超出时间，需要优化。 后续加上