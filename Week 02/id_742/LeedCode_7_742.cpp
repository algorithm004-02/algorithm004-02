class Solution {
public:
    vector<vector<int>> res;
    vector<vector<int>> combine(int n, int k) {
        vector<int> tmp;
        Solve(tmp,1,k,n);
        return res;
    }
    
    void Solve(vector<int> &tmp,int begin,int k,int n){
        if(tmp.size() == k){
            res.push_back(tmp);
            return;
        }
        
        for(int i = begin ; i <= n - ( k - tmp.size()) + 1 ; ++i){
            tmp.push_back(i);
            Solve(tmp,i+1,k,n);
            tmp.pop_back();
        } 
    }
};
