class Solution:
    def reverseStr(self, s: str, k: int) -> str:
        before, after = "", ""
        mod = len(s) % (2 * k)
        handle_str = s
        if 2 * k > len(s):
            if mod <= k:
                after = s[-mod:][::-1]
            elif k < mod < 2 * k:
                after = s[-mod: -mod + k][::-1] + s[-mod + k:]
            return after
        elif 2 * k < len(s):
            if mod > 0:
                if mod <= k:
                    after = s[-mod:][::-1]
                elif k < mod < 2 * k:
                    after = s[-mod: -mod + k][::-1] + s[-mod + k:]
                handle_str = s[:-mod]

        for i in range(int(len(handle_str) / (2 * k))):
            per_str = handle_str[i * 2 * k:2 * k * i + 2 * k]
            before += per_str[:k][::-1] + per_str[k:]
        return before + after
