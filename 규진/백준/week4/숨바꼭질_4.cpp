#include <iostream>
#include <queue>
#include <vector>

using namespace std;

int visited[100001];
int N, K;
queue<int> q;
vector<int> memo(100001);
vector<int> path;

int main(void) {
    cin >> N >> K;
    q.push(N);
    int cnt = 0;

    while (!q.empty()) {
        int num = q.front();
        q.pop();

        if (num == K) {
            cout << visited[K] << "\n";
            int now = K;
            while (now != N) {
                path.push_back(now);
                int prev = memo[now];
                now = prev;
            }
            path.push_back(N);
            for (int i = path.size() - 1; i >= 0; i--)
                cout << path[i] << ' ';
            break;
        }

        for (auto i : {num - 1, num + 1, num * 2}) {
            if (i < 0 || i > 100000)
                continue;
            if (visited[i] == 0) {
                visited[i] = visited[num] + 1;
                memo[i] = num;
                q.push(i);
            }
        }
    }

    return 0;
}