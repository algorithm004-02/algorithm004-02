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
 * A* 
 * @param {number[][]} grid
 * @return {number}
 */
var shortestPathBinaryMatrix = function(grid) {
    let n = grid.length;
    if (grid[0][0] || grid[n - 1][n - 1]) return - 1;
    if (n <= 2) return n;

    let visited = new Set();
    let priority = new PriorityQueue();
    priority.push([0, 0, 1], 0);

    while(priority.size()) {
        let [i, j, dep] = priority.pop();
        if (i === n - 1 && j === n - 1) return dep;

        let key = [i, j].join(',')
        if (visited.has(key)) continue;

        visited.add(key);
        for (let node of succNode(i, j)) {
            let p = dep + 1 + getHuristic(...node);
            priority.push([...node, dep + 1, p], p);
        }
    }
    
    return -1;

    function * succNode(i, j) {
        let dir = [[0, 1], [1, 0], [0, -1], [-1, 0], [1, -1], [-1, 1], [-1, -1], [1, 1]];  

        for(var [dx, dy] of dir) {
            let x = i + dx;
            let y = j + dy;

            if (x < 0 || x >= n || y < 0 || y >= n) continue;
            if (grid[x][y] === 1) continue;
            
            let node = [x, y];
            let key = node.join(',');

            yield node;
        }
    }

    function getHuristic(i, j) {
        let n = grid.length;
        return Math.max(Math.abs(n - i), Math.abs(n - j));
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