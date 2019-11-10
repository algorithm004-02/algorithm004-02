/** 874. 模拟行走机器人 **/

/**
 * @param {number[]} commands
 * @param {number[][]} obstacles
 * @return {number}
 */
var robotSim = function(commands, obstacles) {
    let obsSet = new Set(obstacles.map(obs =>`${obs[0]}-${obs[1]}`));
    let dirs =  [[0, 1], [1, 0], [0, -1], [-1, 0]];
    
    let d = 0, x = 0, y = 0, result = 0;
    for (let c of commands) {
        if (c === -1) {
            d ++;
            d >= 4 && (d = 0);
        } else if (c === -2) {
            d --
            d <= -1 && (d = 3);
        } else {
            while(c-- > 0 && !obsSet.has(`${x + dirs[d][0]}-${y + dirs[d][1]}`)) {         
                x += dirs[d][0];
                y += dirs[d][1];
            }
            
            result = Math.max(result, x * x + y * y);
        }
    }
    
    return result;
};