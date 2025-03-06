/*
9323 무임승차
https://www.acmicpc.net/problem/9323
*/

#include <bits/stdc++.h>
#define fastio             \
  ios::sync_with_stdio(0); \
  cin.tie(0);              \
  cout.tie(0)
#define X first
#define Y second
#define all(x) x.begin(), x.end()
#define INF (~0U >> 2)
#define MAX 201

using namespace std;
typedef long long ll;
typedef pair<int, int> pii;

typedef struct Edge {
  int u, prob, dist;
} Edge;

int n, m, start, end_, s, p, y;
vector<Edge> g[MAX];
double dist[MAX];
double dp[MAX][2];

void solve() {
  cin >> n >> m >> start >> end_ >> s >> p >> y;

  fill(dist + 1, dist + n + 1, INF);
  for (int i = 1; i <= n; i++) {
    dp[i][0] = dp[i][1] = INF;
    g[i].clear();
  }

  for (int i = 0; i < m; i++) {
    int u, v, prob, dist;
    cin >> u >> v >> prob >> dist;
    g[u].push_back({v, prob, dist});
    g[v].push_back({u, prob, dist});
  }

  dist[start] = 0;
  dp[start][0] = s;
  dp[start][1] = 0;
  priority_queue<pair<double, int>> pq;
  pq.push({0, start});
  while (!pq.empty()) {
    auto [d, u] = pq.top();
    pq.pop();
    d = -d;
    if (dist[u] < d)
      continue;
    for (auto [v, prob, nd] : g[u]) {
      double paid = min(dp[u][0], dp[u][1] + s) + nd * p;
      double free = min(dp[u][0], dp[u][1]) + (y + nd * p) * prob / 100.;
      dp[v][0] = min(dp[v][0], paid);
      dp[v][1] = min(dp[v][1], free);
      double minDist = min(dp[v][0], dp[v][1]);
      if (minDist < dist[v]) {
        dist[v] = minDist;
        pq.push({-dist[v], v});
      }
    }
  }
  cout << fixed << setprecision(2) << dist[end_] << '\n';
}

int main() {
  fastio;
#ifndef ONLINE_JUDGE
  freopen("input.txt", "r", stdin);
  freopen("output.txt", "w", stdout);
#endif

  int t = 1;
  cin >> t;
  while (t--) {
    solve();
  }

  return 0;
}