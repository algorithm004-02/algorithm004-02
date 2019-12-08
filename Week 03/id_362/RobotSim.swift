class Solution {
    func robotSim(_ commands:[Int], _ obstacles: [[Int]]) -> Int {
        let dirs = [[0, 1], [1, 0], [0, -1], [-1, 0]]
        let obs = Set<[Int]>(obstacles)

        var x = 0, y = 0, d = 0, maxSquare = 0
        for cmd in commands {
            if cmd == -1 {
                d += 1
                d %= 4
            } else if cmd == -2 {
                d -= 1
                if d < 0 {
                    d += 4
                }
            } else {
                var step = 0
                while step < cmd && !obs.contains([x + dirs[d][0], y + dirs[d][1]]) {
                    x += dirs[d][0]
                    y += dirs[d][1]
                    step += 1
                }
            }
            maxSquare = max(maxSquare, x * x + y * y)
        }

        return maxSquare
    }
}
