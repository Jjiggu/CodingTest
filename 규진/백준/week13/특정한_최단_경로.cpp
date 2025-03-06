#include <iostream>
#include <vector>
#include <queue>

using namespace std;

int N, E, v1, v2;
const int INF = 1e9; // 무한대 값 설정
vector<pair<int, int>> adj[2004]; // 그래프의 인접 리스트 표현 (정점, 가중치)
vector<int> dist(2004, INF); // 최단 거리 배열

void dijstra(int start) {
    priority_queue<pair<int, int>, vector<pair<int, int>>, greater<pair<int, int>>> pq;
    dist[start] = 0;
    pq.push({0, start});
    while (!pq.empty()) {
        int here_cost = pq.top().first;
        int u = pq.top().second;
        pq.pop();

        if (dist[u] != here_cost)
            continue;
        for (auto there : adj[u]) {
            int new_cost = here_cost + there.first;
            if (new_cost < dist[there.second]) {
                dist[there.second] = new_cost;
                pq.push({new_cost, there.second});
            }
        }
}
}

int main(void) {
    cin >> N >> E;
    for (int i = 0; i < E; i++) {
        int a, b, c;
        cin >> a >> b >> c;
        adj[a].push_back({c, b});
        adj[b].push_back({c, a});
    }
    
    cin >> v1 >> v2;
    dijstra(1);
    int a1 = dist[v1];
    int b1 = dist[v2];

    fill(dist.begin(), dist.end(), INF);

    dijstra(v1);
    int common = dist[v2];
    int b2 = dist[N];

    fill(dist.begin(), dist.end(), INF);

    dijstra(v2);
    int a2 = dist[N];

    int result1 = a1 + common + a2;
    int result2 = b1 + common + b2;

    if ((result1 >= INF || result1 <= 0) && (result2 >= INF || result2 <= 0)) {
        cout << -1;
        return 0;
    }

    if (result1 < result2) {
        cout << result1;
    } else {
        cout << result2;
    }

    return 0;
}