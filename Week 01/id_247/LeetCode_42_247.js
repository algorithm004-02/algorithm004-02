/**
 * 42. ����ˮ
  ���� n ���Ǹ�������ʾÿ�����Ϊ 1 �����ӵĸ߶�ͼ�����㰴�����е����ӣ�����֮���ܽӶ�����ˮ
 *
 * https://leetcode-cn.com/problems/trapping-rain-water/ ����
 *
 * ˫ָ�룬����߶Ȳ�
 */

const trap = ( heights ) => {

    let left = 0
    let right = heights.length - 1
    let left_max = 0
    let right_max = 0
    let sum = 0

    while (left < right) {

        if (heights[left] < heights[right]) {

            heights[left] > left_max ? (left_max = heights[left]) : sum += (left_max - heights[left])
            left++
        }
        else {
            heights[right] > right_max ? (right_max = heights[right]) : sum += (right_max - heights[right])
            right--
        }
    }

    return sum
}