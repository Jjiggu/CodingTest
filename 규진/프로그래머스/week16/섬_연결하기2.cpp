#include <string>
#include <vector>
#include <queue>
#include <iostream>

using namespace std;
vector<pair<int, int>> graph[101];
bool visited[101];

int prim(int start, int n) {
    priority_queue<pair<int, int>, vector<pair<int, int>>, greater<pair<int, int>>> pq;
    
    int totalCost = 0;
    int connected = 0;
    pq.push({0, start});
    
    while (!pq.empty()) {
        int node = pq.top().second;
        int cost = pq.top().first;
        pq.pop();
        
        if (!visited[node]) {
            visited[node] = true;
            totalCost += cost;
            connected++;
            
            // if (n == connected)
            //     break;
            
            for (auto edge : graph[node]) {
                int nextNode = edge.first;
                int nextCost = edge.second;
                if (!visited[nextNode]) {
                    pq.push({nextCost, nextNode});
                }   
            }
        }
    }
    
    return totalCost;
    
}

int solution(int n, vector<vector<int>> costs) {
    int answer = 0;
    
    for (int i = 0; i < costs.size(); i++) {
        graph[costs[i][0]].push_back({costs[i][1], costs[i][2]});
        graph[costs[i][1]].push_back({costs[i][0], costs[i][2],});
    }
    answer = prim(0, n);
    return answer;
}