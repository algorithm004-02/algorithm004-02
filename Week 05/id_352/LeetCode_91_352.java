/**
 * @(#)NumDecoding.java, Nov 17, 2019.
 * <p>
 * Copyright 2019 fenbi.com. All rights reserved.
 * FENBI.COM PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

/**
 * @author helloliu
 */

/**
 * 和LCS有点相似，但是这里要注意0,如果0不能和前一个数组组合在一起编码，那么这个编码就没有解
 */
public class NumDecoding {


    public int numDecodings(String s) {
        if (s == null || "".equals(s) || s.charAt(0) == '0') {
            return 0;
        }
        int pre1 = 1;
        int pre2 = 1;
        for (int i = 1; i < s.length(); i++) {
            int temp = pre1;
            if (s.charAt(i) == '0') {
                if (s.charAt(i - 1)  == '1' || s.charAt(i - 1) == '2') {
                    pre1 = pre2;
                } else {
                    return 0;
                }
            } else if (s.charAt(i - 1) == '1' || (s.charAt(i - 1) == '2' && s.charAt(i) >= '1' && s.charAt(i) <= '6')) {
                pre1 = pre1 + pre2;
            }

            pre2 = temp;
        }

        return pre1;
    }
}