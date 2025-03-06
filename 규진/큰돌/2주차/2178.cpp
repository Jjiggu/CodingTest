#include <iostream>
#include <queue>

using namespace std;

int N, M;
int map[101][101];
int visited[101][101];
int dy[4] = {-1, 0, 1, 0};
int dx[4] = {0, 1, 0, -1};
queue<pair<int, int>> q;
int cnt;

void bfs(int a, int b) {
    visited[a][b] = 1;
    q.push({a, b});
    while (!q.empty()) {
        int y = q.front().first;
        int x = q.front().second;
        q.pop();
        for (int i = 0; i < 4; i++) {
            int ny = y + dy[i];
            int nx = x + dx[i];
            if (ny < 1 || nx < 1 || ny > N || nx > M)
                continue;
            if (!visited[ny][nx] && map[ny][nx] == 1) {
                visited[ny][nx] = visited[y][x] + 1;
                q.push({ny, nx});
                cnt++;
            }
        }
    }
}

int main(void) {
    cin >> N >> M;

    for (int i = 1; i <= N; i++) {
        for (int j = 1; j <= M; j++) {
            scanf("%1d", &map[i][j]);
        }
    }
    bfs(1, 1);
    cout << visited[N][M];

    return 0;
}