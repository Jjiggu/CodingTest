#include <string>
#include <vector>

using namespace std;

int visited[201];
int dy[4] = {-1, 0, 1, 0};
int dx[4] = {0, 1, 0, -1};

void dfs(int cur, vector<vector<int>> com, int n) {
    visited[cur] = 1;
    for(int i = 0; i < n; i++){
        if(!visited[i] && com[cur][i] == 1){
            dfs(i, com, n);
        }
    }
}

int solution(int n, vector<vector<int>> computers) {
    int answer = 0;
    for (int i = 0; i < n; i++) {
        if (!visited[i]) {
            dfs(i, computers, n);
            answer++;
        }
    }
    return answer;
}