class Solution {//哇 丑的一批 需要优化
   public int firstUniqChar(String s) {
        int res = -1;
        Set<Character> newSet = new HashSet<>() ,deleteSet = new HashSet<>();
        for (char c : s.toCharArray()) {
            if (newSet.contains(c)) {
                newSet.remove(c);
                deleteSet.add(c);
            } else if(!deleteSet.contains(c)){
                newSet.add(c);
            }
        }
        if (!newSet.isEmpty()) {
            for (int i = 0; i < s.toCharArray().length; i++) {
                if (newSet.contains(s.charAt(i))) {
                    res = i;
                    break;
                }
            }
        }
        return res;
    }
}


//思路二
//使用java系统函数，判断26个字母中出现在单词中第一个和最后一个的下标，如果存在并且下标一样，则证明是唯一的，找到其中下表最小的就是出现第一个唯一元素。
class Solution {
    public int firstUniqChar(String s) {
        int res = -1;
        for (char c = 'a'; c <= 'z'; c ++) {
            int index = s.indexOf(c);
            if (index >= 0 && s.lastIndexOf(c) == index) {
                res = res == -1 ? index : Math.min(res, index);
            }
        }
        return res;
    }
}