class Solution(object):
    def toLowerCase(self, str):
        """
        :type str: str
        :rtype: str
        """
        return ''.join([chr(ord(c) + 32) if ord(c) >= 65 and ord(c) <= 90  else c for c in str])