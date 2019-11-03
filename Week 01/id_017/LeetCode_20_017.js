
/**
 * @param {string} s
 * @return {boolean}
 */

var map = {
    "[":"]",
    "{":"}",
    "(":")"
}

var isValid = function(s) {
    var stack = [];
    for(let i = 0; i < s.length; i++) {
        let el  = s[i];
        //这个怎么理解？ 
        //元素是key  就把右半部分放进去，然后再等下一步跟出栈的一不一样
        if(map[el]) {
            stack.push(map[el]);
        }else{
            //如果出栈跟元素一样，就是有效的，不一样就是无效
            if(el !== stack.pop()) {
               return false;
            }
        }
    }
    
    return stack.length === 0;
};