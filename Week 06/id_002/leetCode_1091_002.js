/** 1091. 二进制矩阵中的最短路径 **/

// 1. BFS
// 2. DP
// 3. A*

/**
 * BFS
 * @param {number[][]} grid
 * @return {number}
 */
var shortestPathBinaryMatrix = function(grid) {
    let n = grid.length;
    if (grid[0][0] || grid[n - 1][n - 1]) return - 1;
    if (n <= 2) return n;

    let dir = [[0, 1], [1, 0], [0, -1], [-1, 0], [1, -1], [-1, 1], [-1, -1], [1, 1]];  

    let queue = [[0, 0, 2]];

    while(queue.length) {
        let [i, j, dep] = queue.shift();

        for(var [dx, dy] of dir) {
            let x = i + dx;
            let y = j + dy;


            if (x < 0 || x >= n || y < 0 || y >= n) continue;
            if (grid[x][y] === 1) continue;

            if (x === n - 1 && y === n - 1) return dep
            
            grid[x][y] = 1;
            queue.push([x, y, dep + 1])
        }
    }

    return -1;
};

/**
 * @param {number[][]} grid
 * @return {number}
 */
var shortestPathBinaryMatrix = function(grid) {
    let n = grid.length;
    if (grid[0][0] || grid[n - 1][n - 1]) return - 1;
    if (n <= 2) return n;


    let priority = new PriorityQueue();
    let node = [0, 0, 1];
    priority.push(node, getHeuristic(node));

    while(priority.size()) {
        let [i, j, dep]= priority.pop();
        if (i === n - 1 && j === n - 1) return dep;

        for (let [x, y] of succFun(i, j)) {
            priority.push([x, y, dep + 1], getHeuristic(x, y));
            grid[x][y] = 1;
        }

        return -1;
    }

    return -1;

    function * succFun(i, j) {
        let dir = [[0, 1], [1, 0], [0, -1], [-1, 0], [1, -1], [-1, 1], [-1, -1], [1, 1]]; 

        for(var [dx, dy] of dir) {
            let x = i + dx;
            let y = j + dy;

            if (x < 0 || x >= n || y < 0 || y >= n) continue;
            if (grid[x][y] === 1) continue;

            yield [x, y];
        }
    }
    function getHeuristic(x, y) {
        return Math.max(Math.abs(n - 1 - x), Math.max(n - 1 -y));
    }
};

/**
 * @param {number[][]} grid
 * @return {number}
 */
var shortestPathBinaryMatrix = function(grid) {
    let n = grid.length;
    if (grid[0][0] || grid[n - 1][n - 1]) return - 1;
    if (n <= 2) return n;

    let dir = [[0, 1], [1, 0], [0, -1], [-1, 0], [1, -1], [-1, 1], [-1, -1], [1, 1]];  
    
    let queue = [[0, 0, 2]];
    grid[0][0] = 1;

    while(queue.length) {
        queue.sort(sort);
        
        let tmp = [];
        for (let [i, j, dep] of queue) {
            for(var [dx, dy] of dir) {
                let x = i + dx;
                let y = j + dy;

                if (x < 0 || x >= n || y < 0 || y >= n) continue;
                if (grid[x][y] === 1) continue;

                if (x === n - 1 && y === n - 1) return dep
                
                grid[x][y] = 1;
                tmp.push([x, y, dep + 1])
            }
        }

        queue = tmp;
    }

    return -1;

    function sort(a, b) {
        let [x1, y1] = a;
        let [x2, y2] = b;
         
        let m = n - 1;
        let dis1 = Math.max(Math.abs(m - x1), Math.abs(m - y1));
        let dis2 = Math.max(Math.abs(m - x2), Math.abs(m - y2));

        return dis1 - dis2;
    }
};

function PriorityQueue() {
    let data = [];

    return {push, pop, size};
    function push(value, priority = 0) {
        data.push({
            value,
            priority
        });
    }

    function pop() {
        let index = 0;
        let min = Infinity;

        for (var i = 0; i < data.length; i ++) {
            let priority = data[i].priority;
            if (Math.min(priority, min) === priority) {
                min = priority;
                index = i; 
            }
        }

        return data.splice(index, 1)[0].value;
    }

    function size(){
        return data.length;
    }
}