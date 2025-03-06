#include <iostream>
#include <stack>

using namespace std;

int N;
int seq[1000001] = {-1};
int ret[1000001] = {-1};
stack<int> s;

int main(void) {
    cin >> N;
    for (int i = 1; i <= N; i++) {
        cin >> seq[i];
        while (s.size() && seq[s.top()] < seq[i]) {
            ret[s.top()] = seq[i];
            s.pop();
        }
        s.push(seq[i]);
    }
    return 0;
}