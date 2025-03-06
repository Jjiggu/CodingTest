#include <iostream>
#include <vector>
#include <queue>

using namespace std;
const int INF = 1e9;

vector<pair<int, int>> adj[2004];
vector<int> dist(0, INF);

void dijkstra(int start) {
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