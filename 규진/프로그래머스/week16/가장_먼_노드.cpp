#include <string>
#include <vector>
#include <queue>
#include <iostream>

using namespace std;
vector<int> v[200001];
int visited[200001];
queue<int> q;

void bfs(int a) {
    while (!q.empty()) {
        int first = q.front();
        q.pop();
        for (int i = 0; i < v[first].size(); i++) {
            if (!visited[v[first][i]]) {
                visited[v[first][i]] = visited[first] + 1;
                q.push(v[first][i]);
            }
        }
    }
}

int solution(int n, vector<vector<int>> edge) {
    int answer = 0;
    for (int i = 0; i < edge.size(); i++) {
        int a = edge[i][0];
        int b = edge[i][1];
        v[a].push_back(b);
        v[b].push_back(a);
    }
    
    visited[1] = 1;
    q.push(1);
    bfs(1);
    
    int maxDistance = 0;
    for (int i = 1; i <= n; i++) {
        maxDistance = max(maxDistance, visited[i]);
    }
    
    for (int i = 1; i <= n; i++) {
        if (maxDistance == visited[i]) {
            answer++;
        }
    }
    
    return answer;
}