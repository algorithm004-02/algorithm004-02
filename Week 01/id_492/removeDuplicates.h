#include <vector>

using namespace std;

// ɾ�����������е��ظ���
// i��¼�Ƴ��ظ���������λ�ã�j��¼ԭ����λ��
class Solution {
public:
    int removeDuplicates(vector<int>& nums) {
        int length = nums.size();
        if (length <= 1) {
            return length;
        }
        int i = 0;
        for (int j = 1; j < nums.size(); j++) {
            if (nums[i] != nums[j]) {
                nums[++i] = nums[j];
            }
        }
        return i + 1;
    }
};