#include <iostream>
#include <queue>
#include <tuple>

using namespace std;

int M, N, H;
int dz[6] = {0, 0, 0, 0, 1, -1};
int dy[6] = {-1, 0, 1, 0, 0, 0};
int dx[6] = {0, 1, 0, -1, 0, 0};
int visited[101][101][101];
int day = 0;
queue<tuple<int, int, int>> q;

int main(void) {

    cin >> M >> N >> H;
    for (int i = 0; i < H; i++) {
        for (int j = 0; j < N; j++) {
            for (int k = 0; k < M; k++) {
                int num;
                cin >> num;
                visited[i][j][k] = num;
                if (num == 1) {
                    q.push(make_tuple(i, j, k));
                }
            }
        }
    }

    while (!q.empty()) {
        int z = get<0>(q.front());
        int y = get<1>(q.front());
        int x = get<2>(q.front());
        q.pop();
        for (int i = 0; i < 6; i++) {
            int nz = z + dz[i];
            int ny = y + dy[i];
            int nx = x + dx[i];
            if (nz < 0 || ny < 0 || nx < 0 || nz >= H || ny >= N || nx >= M)
                continue;
            if (!visited[nz][ny][nx]) {
                visited[nz][ny][nx] = visited[z][y][x] + 1;
                q.push(make_tuple(nz, ny, nx));
            }
        }
    }

    for (int i = 0; i < H; i++) {
        for (int j = 0; j < N; j++) {
            for (int k = 0; k < M; k++) {
                if (visited[i][j][k] == 0) {
                    cout << -1;
                    return 0;
                }
                day = max(day, visited[i][j][k]);
            }
        }
    }

    cout << day - 1;
    return 0;
}