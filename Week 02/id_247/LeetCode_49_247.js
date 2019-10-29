/**
 * 49. ��ĸ��λ�ʷ���
  ����һ���ַ������飬����ĸ��λ�������һ����ĸ��λ��ָ��ĸ��ͬ�������в�ͬ���ַ�����["eat", "tea", "tan", "ate", "nat", "bat"],
 [
 ["ate","eat","tea"],
 ["nat","tan"],
 ["bat"]
 ]
 * https://leetcode-cn.com/problems/group-anagrams/
 *
 * 1. ��ϣӳ�� ans : {String -> List}
      "aet" -> ["ate","eat","tea"]           136 ms , ������ javascript �ύ�л����� 96.05%

 * 2. �Զ����ϣ��������ǰ26���������          132 ms ,  97.94%
 */
const groupAnagrams = (strs) => {

    const map = new Map()

    for (let i = 0; i < strs.length; i++) {

        const word = strs[i].split('').sort().join('')

        if (map.has( word )) {
            const temp = hash.get(word)
            temp.push( strs[i] )
            map.set(word, temp)
        }
        else
            map.set(word, [ strs[i] ])
    }

    return [...map.values()]
};


const groupAnagrams2 = (strs) => {

    const res = {}
    const primes = [2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 41, 43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89, 97, 101, 103]

    for (let i = 0; i < strs.length; i++) {

        const word = strs[i]
        const charArr = word.split('')

        const hash = charArr.reduce( (sum, s) => {

            return sum * primes[s.charCodeAt(0) - 'a'.charCodeAt()]  // e:11 * a:2 * t:73 = 1606,   n:47 * a:2 * t:73 = 6862
        }, 1 )

        res[hash] ? res[hash].push(word) : res[hash] = [word]
    }
    return Object.values(res)
}