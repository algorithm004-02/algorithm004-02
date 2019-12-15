class Solution:
    def reverseWords(self, s: str) -> str:
        handle_str = s.strip()
        new_list = []
        str_list = handle_str.split(" ")
        for string in str_list:
            if string:
                new_list.insert(0, string)
        return " ".join(new_list)
