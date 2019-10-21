/**
 * 26. ɾ�����������е��ظ��� :
 * https://leetcode-cn.com/problems/remove-duplicates-from-sorted-array/ ��
 * 1. ���� for ѭ���� O(n^2), splice ɾ���ظ���
 * 2. һ�� for ѭ���� O(n), splice ɾ���ظ���
 * 3. ��ɾ����ֻ�ǰ��ظ���������
 */
const removeDuplicates = (nums) => {

    for (let i = 0; i < nums.length; i++) {

        for (let j = i + 1; j < nums.length; j++) {

            if (nums[i] === nums[j]){

                nums.splice(j, 1)
                j--
            }
        }
    }
    return nums.length
}

const removeDuplicates2 = (nums) => {

    let i = 0
    for (let j = 1; j < nums.length; j++) {

        if (nums[i] === nums[j]) {

            nums.splice(j, 1)
            j--
        }
        else
            i++
    }
    console.log( nums )
    return nums.length
}

const removeDuplicates3 = (nums) => {

    let i = 0
    for (let j = i + 1; j < nums.length; j++) {

        if (nums[i] !== nums[j]) {

            i++
            nums[i] = nums[j]
        }
    }
    return i + 1
}
