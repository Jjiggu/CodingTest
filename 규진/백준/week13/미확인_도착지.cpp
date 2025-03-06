#include <iostream>
#include <vector>
#include <algorithm>
#include <queue>

using namespace std;

const int INF = 1e9;

vector<pair<int, int>> adj[2001];
vector<int> dist(2001, INF);
vector<int> orgDist(2001, INF);
vector<int> candidate;
int T, n, m, t, s, g, h;

void init() {
    for (int i = 0; i < 2001; i++) {
        adj[i].clear();
        dist[i] = INF;
        orgDist[i] = INF;
    }
    candidate.clear();
}

void initDist() {
    for (int i = 0; i < 2001; i++) {
        dist[i] = INF;
    }
}

void dijkstra(int start) {
    priority_queue<pair <int, int>, vector<pair<int, int>>, greater<pair<int, int>>> pq;
    pq.push({0, start});
    dist[start] = 0;
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
    cin >> T;
    for (int i = 0; i < T; i++) {
        init();
        cin >> n >> m >> t;
        cin >> s >> g >> h;
        int maxGH = max(g, h);
        int minGH = min(g, h);
        int GTOH = 0;
        for (int j = 0; j < m; j++) {
            int a, b, c;
            cin >> a >> b >> c;
            adj[a].push_back({c, b});
            adj[b].push_back({c, a});
            if (a == minGH && b == maxGH) {
                GTOH = c;
            }
        }
        dijkstra(s);
        for (int i = 0; i < 2001; i++) {
            orgDist[i] = dist[i];
        }
        int SToG = dist[g];
        int SToH = dist[h];
        int shortestDistance = INF;
        initDist();
        if (SToG > SToH) {
            dijkstra(g);
            shortestDistance = SToH + GTOH;
        } else {
            dijkstra(h);
            shortestDistance = SToG + GTOH;
        }

        for (int j = 0; j < t; j++) {
            int x;
            cin >> x;
            candidate.push_back(x);
        }
    
        sort(candidate.begin(), candidate.end());

        for (int j = 0; j < candidate.size(); j++) {
            if (shortestDistance + dist[candidate[j]] == orgDist[candidate[j]]) {
                cout << candidate[j] << " ";
            }
        }
        cout << "\n";

    }
    return 0;
}

// 1
// 6 9 2
// 2 3 1
// 1 2 1
// 1 3 3
// 2 4 4
// 2 5 5
// 3 4 3
// 3 6 2
// 4 5 4
// 4 6 3
// 5 6 7
// 5
// 6


// 1
// 5 4 2
// 1 2 3
// 1 2 6
// 2 3 2
// 3 4 4
// 3 5 3
// 5
// 4