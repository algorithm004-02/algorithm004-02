/**
 * 66. ��һ
 ����һ����������ɵķǿ���������ʾ�ķǸ��������ڸ����Ļ����ϼ�һ��  ���λ���ִ�����������λ�� ������ÿ��Ԫ��ֻ�洢�������֡�  ����Լ���������� 0 ֮�⣬��������������㿪ͷ��

 * https://leetcode-cn.com/problems/plus-one/ ��
 */
const plusOne = (digits) => {

    const n = digits.length

    for (let i = n - 1; i >= 0; i-- ) {

        digits[i]++

        if (digits[i] !== 10) {       //  % 10 !== 0 ��

            return digits
        }
        else {
            digits[i] = 0
            if (i === 0) {
                digits.unshift(1)
                return digits
            }
        }
    }
    return digits
}