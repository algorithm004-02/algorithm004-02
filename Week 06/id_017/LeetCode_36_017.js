
/**
 * 36.有效数独
 * @param {character[][]} board
 * @return {boolean}
 */
var isValidSudoku = function(board) {
    //创建三个数组，每个数组的元素都是字典
    //盒子
    const boxes = [{}, {}, {}, {}, {}, {}, {}, {}, {}];
    //列
    const cols = [{}, {}, {}, {}, {}, {}, {}, {}, {}]; 
    //行
    const rows = [{}, {}, {}, {}, {}, {}, {}, {}, {}];   
    //循环遍历
    for (let i = 0; i < 9; i++) {              
        for (let j = 0; j < 9; j++) {            
            const digit = board[i][j];
            //处理非空格 剪枝思想
            if (digit !== '.') {
                //所在的盒子
                const k = Math.floor(j / 3) + (Math.floor(i / 3) * 3);

                if (boxes[k][digit] || cols[j][digit] || rows[i][digit]) {
                    return false;
                }

                boxes[k][digit] = cols[j][digit] = rows[i][digit] = true;       
            }
        }
    }
    
    return true;
};