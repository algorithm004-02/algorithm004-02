/**
 * 找到字符串中所有字母异位词
 */
class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        ArrayList<Integer> result = new ArrayList<>();
        if (s == null || s.equals("") || p == null || p.equals("")) {
            return result;
        }
        int[] pcount = new int[26];
        int[] window = new int[26];
        //p中的不重复元素个数
        int size = 0;
        for (char chas : p.toCharArray()) {
            pcount[chas - 'a']++;
            if (pcount[chas - 'a'] == 1) {
                size++;
            }
        }
        int left = 0,right = 0,total = 0;
        while (right < s.length()) {
            char cur = s.charAt(right);
            int index = cur - 'a';
            //在p中包含
            if (pcount[index] > 0) {
                window[index]++;
                //匹配上一个字符串
                if (pcount[index] == window[index]) {
                    total++;
                }
            }
            right++;
            //如果在当前窗口中,字符已经与p中的元素个数已经匹配完,则需要去除多余的元素
            while (total == size) {
                //正好匹配上了
                if (right - left == p.length()) {
                    result.add(left);
                }
                char leftchar = s.charAt(left);
                int leftIndex = leftchar - 'a';
                //如果字符在p中有，因为要滑动了，所在window里次数要减一
                if(pcount[leftIndex] > 0) {
                    window[leftIndex]--;
                    //如果当前窗口的当前字符小于p中的，说明暂时没匹配上，匹配数要--
                    if (window[leftIndex] < pcount[leftIndex]) {
                        total--;
                    }
                }
                left++;
            }
        }
        return result;
    }
}