#include <string>
#include <vector>
#include <queue>

using namespace std;

long long solution(int n, vector<int> works) {
    long long answer = 0;
    priority_queue<int> q(works.begin(), works.end());
    
    for (int i = 0; i < n; i++) {
        int x = q.top() - 1;
        q.pop();
        q.push(x);
    }
    
    while (!q.empty()) {
        int time = q.top();
        q.pop();
        if (time < 0) {
            time = 0;
        }
        answer += time * time;
    }
    
    return answer;
}