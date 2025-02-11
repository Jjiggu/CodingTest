#include <iostream>
#include <algorithm>
#include <queue>

using namespace std;

int T, M, N, K;

int dy[4] = {-1, 0, 1, 0};
int dx[4] = {0, 1, 0, -1};

int map[51][51];
int visited[51][51];
queue<pair<int, int>> q;

void bfs() {
    while (!q.empty()) {
        int y = q.front().first;
        int x = q.front().second;
        visited[y][x] = 1;
        q.pop();

        for (int i = 0; i < 4; i++) {
            int ny = y + dy[i];
            int nx = x + dx[i];
            if (y < 0 || x < 0 || ny >= N || nx >= M)
                continue;
            if (map[ny][nx] == 1 && visited[ny][nx] == 0) {
                q.push(make_pair(ny, nx));
                visited[ny][nx] = 1;
            }    
        }
    }

}

int main(void) {
    cin >> T;

    for (int i = 0; i < T; i++) {
        cin >> M >> N >> K;

        int cnt = 0;
        fill(&map[0][0], &map[N - 1][M], 0);
        fill(&visited[0][0], &visited[N - 1][M], 0);

        for (int j = 0; j < K; j++) {
            int x, y;
            cin >> x >> y;
            map[y][x] = 1;
        }

        for (int j = 0; j < N; j++) {
            for (int k = 0; k < M; k++) {
                if (map[j][k] == 1 && visited[j][k] == 0) {
                    q.push(make_pair(j, k));
                    bfs();
                    cnt++;
                }
            }
        }
        cout << cnt << "\n";
    }

    return 0;
}
