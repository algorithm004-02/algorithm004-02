class Solution:
    def racecar(self, target: int) -> int:
        def race(t):
            if t not in dp:
                n = t.bit_length()
                if (1 << n) - 1 == t:  # 如果刚好是全A指令就能到达的，如1/3/7
                    dp[t] = n
                else:  # 先n次A到达2^n-1后再R，已操作n+1次，然后转换为从2^n-1到t的正向问题的指令次数
                    dp[t] = n+1+race((1 << n)-1-t)
                    for m in range(n-1):  # 2^m < 2^(n-1)
                        # 先n-1次A到达2^(n-1)-1后再R，然后m次A往回走，再R变为正向，已指令n-1+2+m次，
                        # 接着转换为剩余差值即t-(2^(n-1)-1)+(2^m-1)的正向问题即可
                        dp[t] = min(dp[t], n + m + 1 + race(t - (1 << n - 1) + (1 << m)))
            return dp[t]
        dp = {0: 0}
        return race(target)