/** 岛屿数量 */
/**
 * 深度优先搜索
 * @param {character[][]} grid
 * @return {number}
 */
var numIslands = function(grid) {
    let dx = [-1, 1, 0, 0];
    let dy = [0, 0, -1, 1];
    let lands = 0;
    
    for (let r = 0; r < grid.length; r ++) {
        for (let c = 0; c < grid[r].length; c ++) {
            if (grid[r][c] == 0) continue;
            lands += sink(r, c);
        }
    }
   
    return lands;
    
    function sink(r, c) {
        if (grid[r][c] == 0) return 0; 
        grid[r][c] = '0';
        for(let i = 0; i < dx.length; i ++) {
            let x = r + dx[i], y = c + dy[i];
            if (x >= 0 && x < grid.length && y >= 0 && y < grid[r].length) {
                if (grid[x][y] == '0') continue;
                sink(x, y);
            }
        }
        
        return 1;
    }
};

/**
 * 广度优先搜索
 * @param {character[][]} grid
 * @return {number}
 */
var numIslands2 = function(grid) {
    let lands = 0;
    let dx = [-1, 1, 0, 0];
    let dy = [0, 0, -1, 1];
    let rLen = grid.length;
    
    for(let r = 0; r < rLen; r++) {
        let cLen = grid[r].length;
        for (let c = 0; c < cLen; c ++) {
            if (grid[r][c] == '0') continue; 
            lands ++;

            let queue = [{r, c}];
            while(queue.length) {
                let {r, c} = queue.shift();
                if(grid[r][c] == 0) continue;
                
                grid[r][c] = '0';
                for(let i = 0; i < dx.length; i++) {     
                    let x = r + dx[i], y = c + dy[i];
                    if (x >= 0 && x < rLen && y >= 0 && y < cLen) {
                        queue.push({ r: x, c: y });
                    }
                }
            }
        }
    }
    
    return lands;
};