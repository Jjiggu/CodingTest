#include <string>
#include <vector>
#include <queue>
#include <iostream>

using namespace std;

int solution(int bridge_length, int weight, vector<int> truck_weights) {
    queue<int> q;
    int answer = 0;
    int index = 0;
    int sum = 0;

    while (true) {
        if (index == truck_weights.size()) {
            answer += bridge_length;
            return answer;
        }

        if (q.size() == bridge_length) {
            sum -= q.front();
            q.pop();
        }

        if (truck_weights[index] + sum <= weight) {
            sum += truck_weights[index];
            q.push(truck_weights[index]);
            index++;
        } else {
            q.push(0);
        }

        answer++;

    }

    return answer;
}