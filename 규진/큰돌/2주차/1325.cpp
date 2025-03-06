#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

int N, M, mx;
vector<int> adj[10001];
int visited[10001];
int dp[10001];

int dfs(int here) {
    int ret = 1;
    visited[here] = 1;
    for (auto i : adj[here]) {
        if (!visited[i]) {
            ret += dfs(i);
        }
    }
    return ret;
}

int main(void) {
    cin >> N >> M;
    for (int i = 0; i < M; i++) {
        int a, b;
        cin >> a >> b;
        adj[b].push_back(a);
    }

    for (int i = 1; i <= N; i++) {
        fill(&visited[0], &visited[0] + 10001, 0);
        dp[i] = dfs(i);
        mx = max(dp[i], mx);
    }

    for (int i = 1; i <= N; i++) {
        if (mx == dp[i]) {
            cout << i << " ";
        }
    }

    return 0;
}