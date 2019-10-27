/*
 * @lc app=leetcode.cn id=42 lang=javascript
 *
 * [42] 接雨水
 */

// @lc code=start
/**
 * @param {number[]} height
 * @return {number}
 */
let trap = function(height) {
    let res = 0;
    let i = 0;
    const st = [];
    while (i < height.length) {
        while (st.length !== 0 && height[i] > height[st[st.length - 1]]) {
            const top = st[st.length - 1];
            st.pop();
            if (st.length === 0) {
                break;
            }
            const dist = i - st[st.length - 1] - 1;
            const h = Math.min(height[i], height[st[st.length - 1]]) - height[top];
            res += dist * h;
        }
        st.push(i++);
    }
    return res;
};
// @lc code=end