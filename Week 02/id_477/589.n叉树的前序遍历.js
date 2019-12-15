// @lc code = start

var preorder = function(root) {
    if (!root) {
        return [];
    }
    let res = [];
    res.push(root.val);
    for (let i = 0; i < root.children.length; i++) {
        res = res.concat(preorder(root.children[i]));
    }
    return res;
};

// @lc code = end