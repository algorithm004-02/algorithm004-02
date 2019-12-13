1. 26. 删除排序数组中的重复项
class Solution {
public:
    int removeDuplicates(vector<int>& nums) {
        if (nums.size() < 2) return nums.size();
        int idx = 0;
        for (int i = 1; i < nums.size(); ++i) {
            if (nums[idx] != nums[i]) {
                nums[++idx] = nums[i];
            } 
        }
        return idx + 1;
    }
};


3. 21. 合并两个有序链表
class Solution {
public:
    ListNode* mergeTwoLists(ListNode* l1, ListNode* l2) {
        if (l1 == NULL) return l2;
        if (l2 == NULL) return l1;
        ListNode* head = new ListNode(0);
        ListNode* n1 = l1;
        ListNode* n2 = l2;
        while (n1 && n2) {
            if (n1->val < n2->val) {
                head->next = n1;
                n1 = n1->next;
            } else {
                head->next = n2;
                n2 = n2->next;
            }
            head = head->next;
        }
        head->next = n1 ? n1 : n2;
        return head = (l1->val < l2->val) ? l1 : l2;
    }
};


4. 88. 合并两个有序数组
class Solution {
public:
    void merge(vector<int>& nums1, int m, vector<int>& nums2, int n) {
        int i = m - 1;
        int j = n - 1;
        int k = m + n - 1;
        while (i >= 0 && j >= 0) {
			nums1[k--] = (nums1[i] > nums2[j]) ? nums1[i--] : nums2[j--];
		}
        while (j >= 0) {
			nums1[k--] = nums2[j--];  
		}
    }
};


5. 1. 两数之和
class Solution {
public:
    vector<int> twoSum(vector<int>& nums, int target) {
        map<int,int> m;
        vector<int> res(2,-1);
        for (int i = 0; i<nums.size(); i++) {
            if (m.count(target - nums[i]) > 0) {
                res[0] = m[target-nums[i]];
                res[1] = i;
                break;
            }
            m[nums[i]] = i;
        }
        return res;
    }
};


6. 283. 移动零
class Solution {
public:
    void moveZeroes(vector<int>& nums) {
        int idx = 0;
        for (int i = 0; i < nums.size(); ++i) {
            if (0 != nums[i]) {
                nums[idx] = nums[i];
                if (i != idx) nums[i] = 0;
                ++idx;
            }
        }
    }
};


7. 66. 加一
class Solution {
public:
    vector<int> plusOne(vector<int>& digits) {
        for (int i = digits.size() - 1; i >= 0; --i) {
            digits[i] = ++digits[i] % 10;
            if (0 != digits[i]) {
                return digits;
            }
        }  
        digits.insert(digits.begin(), 1);
        return digits;
    }
};

