#include <iostream>
#include <queue>
#include <algorithm>

using namespace std;

int visited[1001][1001];
int dy[4] = {-1, 0, 1, 0};
int dx[4] = {0, 1, 0, -1};
queue<pair<int, int>> q;
int M, N;
int day = 0;

void go(int y, int x) {
    for (int i = 0; i < 4; i++) {
        int ny = y + dy[i];
        int nx = x + dx[i];
        if (ny < 0 || nx < 0 || ny >= N || nx >= M)
            continue;
        if (visited[ny][nx] == 0) {
            visited[ny][nx] = visited[y][x] + 1;
            q.push({ny, nx});
        }
    }
}

int main(void) {
    cin >> M >> N;

    for (int i = 0; i < N; i++) {
        for (int j = 0; j < M; j++) {
            int num;
            cin >> num;
            visited[i][j] = num;
            if (num == 1) {
                q.push({i, j});
            }
        }
    }

    while (!q.empty()) {
        int y = q.front().first;
        int x = q.front().second;
        go(y, x);
        q.pop();
    }

    for (int i = 0; i < N; i++) {
        for (int j = 0; j < M; j++) {
            if (visited[i][j] == 0) {
                cout << -1;
                return 0;
            }
            day = max(day, visited[i][j]);
        }
    }

    cout << day - 1;

    return 0;
}