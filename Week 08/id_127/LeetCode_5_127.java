public class D {
	public String longestPalindrome(String s) {
        if (s == null || "".equals(s)) {
            return s;
		}

        int strLength = s.length();
        int max = 0;
        int index = 0;
		int flag = 0;
        char previousChar = s.charAt(0);
        for (int i = 1; i<strLength; i++) {
            int curMax = 0;
            if (s.charAt(i) == previousChar) {
                previousChar = s.charAt(i);
                curMax = compareEven(s, i-1, i);
                if (curMax > max) {
                    index = i;
                    max = curMax;
                    flag = 1;
                }
            }

            curMax = compareEven(s, i-2, i);
            if (curMax >= max) {
                index = i;
                max = curMax;
                flag = 0;
            }
            
            if (max > strLength - 1 - i) {
                break;
            }
            previousChar = s.charAt(i);
        }

        if (flag == 1) {
            return s.substring(index - max, index + max);
        } else {
            if (index - 1 < 0) {
                return s.substring(index, index+1);
            }
            return s.substring(index - max - 1, index + max);
        }
    }

    int compareEven(String s, int pre, int last) {
        if (pre < 0 || last > s.length()-1) {
            return 0;
        }
        if (s.charAt(pre) == s.charAt(last)) {
            return compareEven(s, pre-1, last+1) + 1;
        }
        return 0;
    }

}