/**
 * 189. ��ת���飺 ����һ�����飬�������е�Ԫ�������ƶ� k ��λ�ã����� k �ǷǸ�����
 * https://leetcode-cn.com/problems/rotate-array/  ��

 * 1. APIֱ��ɾ������ģ�����ɾ���˵���䵽����  60 ms , ������ javascript �ύ�л����� 99.86% ���û�
 * 2. ������ÿ����һ��
 * 3. ����������ѭ��
 * 4. ��ת
 */
const rotate = (nums, k) => {

    const rightRotat = nums.splice( nums.length - k, k)
    nums.unshift(...rightRotat)
    return nums
};


const rotate2 = (nums, k) => {

    let temp = 0
    let prev = 0
    const n = nums.length

    for (let i = 0; i < k; i++) {

        prev = nums[n - 1]

        for (let j = 0; j < n; j++) {   // 99,-100,3,99   99,-1,3,99   99,-1,-100,99   99,-1,-100,3

            temp = nums[j]
            nums[j] = prev
            prev = temp
        }
    }
    return nums
};


const rotate3 = (nums, k) => {

    const n = nums.length
    const arr = new Array(n)

    for (let i = 0; i < n; i++) {

        arr[ (i + k) % n] = nums[i]
    }
    nums = arr
    return nums
}


const reverse = (nums, start, end) => {

    while (start < end) {

        let temp = nums[start]
        nums[start] = nums[end]
        nums[end] = temp
        start++
        end--
    }
}

const rotate4 = (nums, k) => {

    reverse(nums, 0, nums.length - 1)
    reverse(nums, 0, k - 1)
    reverse(nums, k, nums.length - 1)
    return nums
}