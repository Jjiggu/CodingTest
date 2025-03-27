#include <string>
#include <vector>
#include <queue>
#include <iostream>

using namespace std;

vector<int> graph[100001];
int visited[100001];
bool flag;

int bfs(int x, int destination) {
    queue<int> q;
    if (x == destination) {
        return visited[x];
    }
    q.push(x);
    while (!q.empty()) {
        int nx = q.front();
        q.pop();
        for (auto edge : graph[nx]) {
            if (!visited[edge]) {
                visited[edge] = visited[nx] + 1;
                if (edge == destination) {
                    flag = true;
                    return visited[edge];
                }
                q.push(edge);
                
            }
        }
    }
    if (!flag) {
        return -1;
    }
}

vector<int> solution(int n, vector<vector<int>> roads, vector<int> sources, int destination) {
    vector<int> answer;
    for (int i = 0; i < roads.size(); i++) {
        graph[roads[i][0]].push_back(roads[i][1]);
        graph[roads[i][1]].push_back(roads[i][0]);
    }
    
    for (int i = 0; i < sources.size(); i++) {
        flag = false;
        fill(&visited[0], &visited[0] + 100001, 0);
        answer.push_back(bfs(sources[i], destination));
    }
    
    return answer;
}