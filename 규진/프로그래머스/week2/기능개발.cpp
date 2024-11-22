#include <string>
#include <vector>
#include <queue>
#include <iostream>

using namespace std;

vector<int> solution(vector<int> progresses, vector<int> speeds) {
    vector<int> answer;
    queue<int> q;

    for (int i = 0; i < progresses.size(); i++) {
        int calNum = (100 - progresses[i]);
        int num = calNum % speeds[i] == 0 ? calNum / speeds[i] : calNum / speeds[i] + 1;
        q.push(num);
    }




    int front = q.front();
    q.pop();
    int cnt = 1;
    while (!q.empty()) {
        if (front >= q.front()) {
            q.pop();
            cnt++;
        } else {
            front = q.front();
            q.pop();
            answer.push_back(cnt);
            cnt = 1;
        }

        if (q.empty()) {
            answer.push_back(cnt);
        }
    }

    return answer;
}