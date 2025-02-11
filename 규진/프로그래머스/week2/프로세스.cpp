#include <string>
#include <vector>
#include <algorithm>
#include <queue>

using namespace std;

int solution(vector<int> priorities, int location) {
    int answer = 0;

    queue<int> q;

    for (int i = 0; i < priorities.size(); i++)
        q.push(i);

    int max = *max_element(priorities.begin(), priorities.end());
    int count = 1;

    while (true) {
        int num = q.front();

        if (priorities[num] < max) {
            q.push(num);
            q.pop();
        } else {
            if (num == location)
                return count;
            priorities[num] = 0;
            max = *max_element(priorities.begin(), priorities.end());
            count++;
            q.pop();
        }
    }

    return answer;
}