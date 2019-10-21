#include <vector>

using namespace std;

// ��ת����
class Solution {
public:
    void rotate(vector<int>& nums, int k) {
        int length = nums.size();
        k = k % length;
        // count��¼����ı�������
        int count = 0;
        // û�б������������ֵ��ǻص��������֣�������һ����������
        for (int start = 0; count < length; start++) {
            int prev = nums[start];
            int current = start;
            do {
                // �ҵ���ǰλ�����ֵ�Ŀ��λ��
                int next = (current + k) % length;

                int temp = nums[next];
                nums[next] = prev;
                prev = temp;
                current = next;
                count++;
            } while (current != start);
        }
    }
};