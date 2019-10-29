/**
 * 242. ��Ч����ĸ��λ��
   ���������ַ��� s �� t ����дһ���������ж� t �Ƿ��� s ����ĸ��λ�ʡ�s = "anagram", t = "nagaram"  -> true

 * https://leetcode-cn.com/problems/valid-anagram/description/
 *
 * 1. sort:                                            116 ms , ������ javascript �ύ�л����� 51.25%
 * 2. ��ϣ��26λ������                                  68 ms ,  98.91%
 * 3. ��ϣ��s,t �ֱ�������� t ��һ��С��0������ false     76 ms ,  94.44%
 */

const isAnagram = ( s, t ) => {

    if (s.length !== t.length)
        return false

    const s_arr = s.split('').sort()
    const t_arr = t.split('').sort()
    const s_sort = s_arr.join()
    const t_sort = t_arr.join()
    return s_sort === t_sort
}


const isAnagram2 = ( s, t ) => {

    if (s.length !== t.length)
        return false

    const counter = new Array(26).fill(0)

    for (let i = 0; i < s.length; i++) {
        counter[s.charCodeAt(i) - 'a'.charCodeAt()]++
        counter[t.charCodeAt(i) - 'a'.charCodeAt()]--
    }

    /*counter.forEach ( i => {
        if (i !== 0)
            return false
    })*/

    for (let i = 0; i < counter.length; i++){
        if (counter[i] !== 0)
            return false
    }

    return true
}


const isAnagram3 = ( s, t ) => {

    if (s.length !== t.length)
        return false

    const counter = new Array(26).fill(0)

    for (let i = 0; i < s.length; i++) {
        counter[s.charCodeAt(i) - 'a'.charCodeAt()]++
    }

    for (let i = 0; i < t.length; i++) {
        counter[t.charCodeAt(i) - 'a'.charCodeAt()]--
        if (counter[t.charCodeAt(i) - 'a'.charCodeAt()] < 0)
            return false
    }

    return true
}