#include <iostream>
#include <algorithm>
#include <stack>

using namespace std;

int N;
int seq[1000001] = {-1};
int ret[1000001] = {-1};
stack<int> s;

int main(void) {
    cin >> N;
    fill(&ret[0], &ret[0] + 1000001, -1);
    for (int i = 0; i < N; i++) {
        cin >> seq[i];
        while (s.size() && seq[s.top()] < seq[i]) {
            ret[s.top()] = seq[i];
            s.pop();
        }
        s.push(i);
    }

    for (int i = 0; i < N; i++) {
        cout << ret[i] << " ";
    }
    return 0;
}