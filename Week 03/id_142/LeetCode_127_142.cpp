/*
 * @lc app=leetcode.cn id=127 lang=cpp
 *
 * [127] 单词接龙
 *
 * https://leetcode-cn.com/problems/word-ladder/description/
 *
 * algorithms
 * Medium (37.14%)
 * Likes:    151
 * Dislikes: 0
 * Total Accepted:    13.1K
 * Total Submissions: 34.9K
 * Testcase Example:  '"hit"\n"cog"\n["hot","dot","dog","lot","log","cog"]'
 *
 * 给定两个单词（beginWord 和 endWord）和一个字典，找到从 beginWord 到 endWord
 * 的最短转换序列的长度。转换需遵循如下规则：
 * 
 * 
 * 每次转换只能改变一个字母。
 * 转换过程中的中间单词必须是字典中的单词。
 * 
 * 
 * 说明:
 * 
 * 
 * 如果不存在这样的转换序列，返回 0。
 * 所有单词具有相同的长度。
 * 所有单词只由小写字母组成。
 * 字典中不存在重复的单词。
 * 你可以假设 beginWord 和 endWord 是非空的，且二者不相同。
 * 
 * 
 * 示例 1:
 * 
 * 输入:
 * beginWord = "hit",
 * endWord = "cog",
 * wordList = ["hot","dot","dog","lot","log","cog"]
 * 
 * 输出: 5
 * 
 * 解释: 一个最短转换序列是 "hit" -> "hot" -> "dot" -> "dog" -> "cog",
 * ⁠    返回它的长度 5。
 * 
 * 
 * 示例 2:
 * 
 * 输入:
 * beginWord = "hit"
 * endWord = "cog"
 * wordList = ["hot","dot","dog","lot","log"]
 * 
 * 输出: 0
 * 
 * 解释: endWord "cog" 不在字典中，所以无法进行转换。
 * 
 */

// @lc code=start
class Solution {
public:
    int ladderLength(string beginWord, string endWord, vector<string>& wordList) {
        // 建立索引表
        unordered_map<string, set<string>> allcombo;
        auto rlt = create_all_combo(allcombo, wordList, endWord);
        if (!rlt) return 0;

        // 建立两个访问数组
        // key 是单词 value 是访问层级
        unordered_map<string, int> visitH, visitT;

        // 两个队列
        // 单词和层级
        queue<pair<string, int>> qH, qT;
        update_queue_and_visit(beginWord, 1, qH, visitH);
        update_queue_and_visit(endWord, 1, qT, visitT);
   
        // 两个队列非空则循环
        while (!qH.empty() && !qT.empty()) {
            auto ret = findWord(qH, allcombo, visitH, visitT, endWord);
            if (ret > 0) return ret;

            ret = findWord(qT, allcombo, visitT, visitH, beginWord);
            if (ret > 0) return ret;
        }

        return 0;
    }

    bool create_all_combo(unordered_map<string, set<string>>& allcombo, 
                          vector<string>& wordList, const string& endWord) {
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

    int findWord(queue<pair<string, int>>& cur_queue, const unordered_map<string, set<string>>& allcombo,
                 unordered_map<string, int>& cur_visit, const unordered_map<string, int>& other_visit,
                 const string& endWord) {
        if (cur_queue.empty()) return 0;

        // 字母头部开始循环
        auto node = cur_queue.front();
        cur_queue.pop();

        // 生成通配符
        for (int i = 0; i < node.first.length(); ++i) {
            auto combo = node.first.substr(0, i) + "*" + node.first.substr(i+1);
            // 查找该通配符下面的全部单词
            auto rlt = allcombo.find(combo);
            if (rlt == allcombo.end()) continue;

            for (auto &word : rlt->second) {
                // 如果等于结束单词，直接返回
                if (word == endWord) {
                    return node.second + 1;
                }
                // 在尾访问集合中查找，是否访问过
                auto level = visited_level(word, other_visit);
                if (level > 0) {
                    return node.second + level;
                }

                // 如果没访问过，把单词插入队列
                if (visited_level(word, cur_visit) == 0) {
                    update_queue_and_visit(word, node.second+1, cur_queue, cur_visit);
                }
            }
        }

        return 0;
    }

    void update_queue_and_visit(const string& word, int level, 
                                queue<pair<string, int>>& q,
                                unordered_map<string, int>& visit) {
        auto pair = make_pair(word, level);
        q.push(pair);
        visit.insert(pair);
    }

    int visited_level(const string& word, const unordered_map<string, int>& visit) {
        auto it = visit.find(word);
        if (it == visit.end()) return 0;

        return it->second;
    }
};
// @lc code=end

