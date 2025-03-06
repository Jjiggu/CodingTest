#include <iostream>
#include <queue>

using namespace std;

int dy[4] = {-1, 0, 1, 0};
int dx[4] = {0, 1, 0, -1};
int map[51][51];
int visited[51][51];
int worms;
queue<pair<int, int>> q;

int T, M, N, K;

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
            if (ny < 0 || nx < 0 || ny >= M || nx >= N)
                continue;
            if (!visited[ny][nx] && map[ny][nx] == 1) {
                visited[ny][nx] = 1;
                q.push({ny, nx});
            }
        }
    }

}

void initVar() {
    for (int i = 0; i < 51; i++) {
        for (int j = 0; j < 51; j++) {
            map[i][j] = 0;
            visited[i][j] = 0;
        }
    }
    worms = 0;
}

int main(void) {
    cin >> T;
    for (int i = 0; i < T; i++) {
        cin >> M >> N >> K;
        for (int j = 0; j < K; j++) {
            int a, b;
            cin >> a >> b;
            map[a][b] = 1;
        }

        for (int j = 0; j < M; j++) {
            for (int k = 0; k < N; k++) {
                if (map[j][k] == 1 && !visited[j][k]) {
                    bfs(j, k);
                    worms++;
                }
            }
        }
        cout << worms << "\n";
        initVar();
    }
    return 0;
}