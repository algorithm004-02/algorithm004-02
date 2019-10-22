/*
* @Author: yangyazhen
* @Date:   2019-10-20 14:08:27
* @Last Modified by:   yangyazhen
* @Last Modified time: 2019-10-20 14:08:30
*/
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
        if(l1 == NULL) {
            return l2;
        } if (l2 == NULL) {
            return l1;
        } else if (l1->val < l2->val) {
            l1->next = mergeTwoLists(l1->next, l2);
            return l1;
        } else {
            l2->next = mergeTwoLists(l2->next, l1);
            return l2;
        }
    }
};
// 1.迭代插入
// 巧妙的运用头节点，可以避免对空链表的特殊判定
// 执行用时 :12 ms, 在所有 cpp 提交中击败了79.19%的用户
// 内存消耗 :8.9 MB, 在所有 cpp 提交中击败了84.09%的用户
// class Solution {
// public:
//     ListNode* mergeTwoLists(ListNode* l1, ListNode* l2) {
//         ListNode head(-1);
//         ListNode* cur = &head;
//         while (l1 != NULL && l2 != NULL) {
//             if (l1->val < l2->val) {
//                 cur->next = l1;
//                 l1 = l1->next;
//             } else {
//                 cur->next = l2;
//                 l2 = l2->next;
//             }
//             cur = cur->next;
//         }
//         cur->next = l1 == NULL ? l2 : l1;
//         return head.next;
//     }
// };
// 2. 递归
// 执行用时 :8 ms, 在所有 cpp 提交中击败了96.98%的用户
// 内存消耗 :9.1 MB, 在所有 cpp 提交中击败了73.70%的用户

