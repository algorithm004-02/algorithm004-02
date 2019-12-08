/*
 * @lc app=leetcode.cn id=21 lang=cpp
 *
 * [21] 合并两个有序链表
 *
 * https://leetcode-cn.com/problems/merge-two-sorted-lists/description/
 *
 * algorithms
 * Easy (57.59%)
 * Likes:    692
 * Dislikes: 0
 * Total Accepted:    135K
 * Total Submissions: 232.2K
 * Testcase Example:  '[1,2,4]\n[1,3,4]'
 *
 * 将两个有序链表合并为一个新的有序链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。 
 * 
 * 示例：
 * 
 * 输入：1->2->4, 1->3->4
 * 输出：1->1->2->3->4->4
 * 
 * 
 */

// @lc code=start
/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     ListNode *next;
 *     ListNode(int x) : val(x), next(NULL) {}
 * };
 */
class Solution {
public:
    ListNode* mergeTwoLists(ListNode* l1, ListNode* l2) {
        if (l1 == nullptr) return l2;
        if (l2 == nullptr) return l1;

        auto l = l1, m = l2;

        // 设定要返回的链表地址
        ListNode* head = nullptr;
        ListNode* other = nullptr;
        if (l->val > m->val) {
            head = m;
            other = l;
            m = m->next;
        } else {
            head = l;
            other = m;
            l = l->next;
        }
        
        ListNode* cur = head;
        while (cur && cur->next && other) {
            if (cur->next->val <= other->val) {
                cur = cur->next;
            } else {
                auto tmp = cur->next;
                cur->next = other;
                other = other->next;
                cur->next->next = tmp;
                cur = cur->next;
            }
        }
        if (!cur->next && other) {
            cur->next = other;
        }

        return head;
    }
};
// @lc code=end

