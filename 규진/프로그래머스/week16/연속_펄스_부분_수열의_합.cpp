#include <string>
#include <vector>
#include <algorithm>

using namespace std;
vector<int> v1;
vector<int> v2;
long long dp[500001];

long long getMaxSum(vector<int> &v) {
    long long ret = v[0];
    dp[0] = v[0];
    
    for (int i = 1; i < v.size(); i++) {
        dp[i] = max(dp[i - 1] , (long long) 0) + v[i];
        ret = max(ret, dp[i]);
    }
    return ret;
}

long long solution(vector<int> sequence) {
    long long answer = 0;
    for (int i = 0; i < sequence.size(); i++) {
        if (i % 2 == 0) {
            v1.push_back(sequence[i]);
            v2.push_back(-sequence[i]);
        } else {
            v1.push_back(-sequence[i]);
            v2.push_back(sequence[i]);
        }
    }
    long long r1 = getMaxSum(v1);
    fill(dp, dp + 500001, 0);
    long long r2 = getMaxSum(v2);
    
    answer = max(r1, r2);
    
    return answer;
}