var postorder = function(root) {
    if (!root) {
        return [];
    }
    let res = [];
    for (let i = 0; i < root.children.length; i++) {
        res = res.concat(postorder(root.children[i]));
    }
    res.push(root.val);
    return res;
};