/*
 * @lc app=leetcode.cn id=126 lang=cpp
 *
 * [126] 单词接龙 II
 *
 * https://leetcode-cn.com/problems/word-ladder-ii/description/
 *
 * algorithms
 * Hard (28.36%)
 * Likes:    78
 * Dislikes: 0
 * Total Accepted:    3.5K
 * Total Submissions: 12.3K
 * Testcase Example:  '"hit"\n"cog"\n["hot","dot","dog","lot","log","cog"]'
 *
 * 给定两个单词（beginWord 和 endWord）和一个字典 wordList，找出所有从 beginWord 到 endWord
 * 的最短转换序列。转换需遵循如下规则：
 * 
 * 
 * 每次转换只能改变一个字母。
 * 转换过程中的中间单词必须是字典中的单词。
 * 
 * 
 * 说明:
 * 
 * 
 * 如果不存在这样的转换序列，返回一个空列表。
 * 所有单词具有相同的长度。
 * 所有单词只由小写字母组成。
 * 字典中不存在重复的单词。
 * 你可以假设 beginWord 和 endWord 是非空的，且二者不相同。
 * 
 * 
 * 示例 1:
 * 
 * 输入:
 * beginWord = "hit",
 * endWord = "cog",
 * wordList = ["hot","dot","dog","lot","log","cog"]
 * 
 * 输出:
 * [
 * ⁠ ["hit","hot","dot","dog","cog"],
 * ["hit","hot","lot","log","cog"]
 * ]
 * 
 * 
 * 示例 2:
 * 
 * 输入:
 * beginWord = "hit"
 * endWord = "cog"
 * wordList = ["hot","dot","dog","lot","log"]
 * 
 * 输出: []
 * 
 * 解释: endWord "cog" 不在字典中，所以不存在符合要求的转换序列。
 * 
 */

// @lc code=start
class Solution {
private:
    vector<vector<string>> results;
    unordered_map<string, set<string>> allcombo;
    int maxdepth;
    string endword;
public:
    vector<vector<string>> findLadders(string beginWord, string endWord, vector<string>& wordList) {
        // 建立索引表
        auto rlt = create_all_combo(wordList, endWord);
        if (!rlt) return {};

        maxdepth = wordList.size();
        endword = endWord;

        // 访问记录
        set<string> visit;
        visit.insert(beginWord);
   
        vector<string> result;
        result.push_back(beginWord);
        find_all_link(beginWord, result, visit);

        return results;
    }

    void find_all_link(const string& word, vector<string>& result, set<string>& visit) {
        // 找到最终结果，放入记录集
        if (word == endword) {
            results.push_back(result);
            return;
        }
        // 深度过深，直接返回
        if (result.size() >= maxdepth) return;

        // 生成通配符
        for (int i = 0; i < word.length(); ++i) {
            auto combo = word.substr(0, i) + "*" + word.substr(i + 1);

            auto combo_rlt = allcombo.find(combo);
            if (combo_rlt == allcombo.end()) continue;

            bool insert = false;
            auto combo_set = combo_rlt->second;
            for (auto& w : combo_rlt->second) {
                // 访问过的不访问
                if (visit.count(w)) continue;

                result.push_back(w);
                visit.insert(w);
                find_all_link(w, result, visit);
                visit.erase(w);
                result.pop_back();
            }
        }
    }

    bool create_all_combo(vector<string>& wordList, const string& endWord) {
        if (wordList.empty()) return false;
        int L = endWord.length();
        for (auto& w1 : wordList) {
            for (int i = 0; i < L; ++i) {
                auto k = w1.substr(0, i) + "*" + w1.substr(i+1);

                //如果通配符存在，则跳过，因为上次已经遍历过一次
                auto combo_rlt = allcombo.find(k);
                if (combo_rlt != allcombo.end()) continue;

                bool find = false;
                for (auto& w2 : wordList) {
                    auto v = w2.substr(0, i) + "*" + w2.substr(i+1);

                    if (v == k) {
                        allcombo[k].insert(w2);
                    }
                    if (w2 == endWord) find = true;
                }
                if (!find) return false;
            }
        }

        return true;
    }

   

};
// @lc code=end

