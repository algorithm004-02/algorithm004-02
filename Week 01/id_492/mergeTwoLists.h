#include <iostream>

struct ListNode {
    int val;
    ListNode *next;
    ListNode(int x) : val(x), next(NULL) {}
};

class Solution {
public:
    ListNode* mergeTwoLists(ListNode* l1, ListNode* l2) {
        if (l1 == NULL) {
            return l2;
        }
        if (l2 == NULL) {
            return l1;
        }

        ListNode *newhead = new ListNode(-1);
        ListNode *p1, *p2;
        newhead->next = p1;
        p1 = newhead;

        while (l2 != NULL) {
            p1 = l1->next;
            p2 = l2->next;

            if (p1 == NULL) {
                l1->next = l2;
                break;
            }

            if (l2->val <= l1->val) {
                l2->next = l1->next;
                l1->next = l2;
                l2 = p2;
            }

            l1 = l1->next;
        }
        return newhead->next;
    }
};