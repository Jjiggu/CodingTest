#include <iostream>
#include <vector>
#include <queue>

using namespace std;

int N, M;
queue<pair<int,int> > q;
int map[101][101] = {-1};
int visited[101][101];
int dy[4] = {-1, 0, 1, 0};
int dx[4] = {0, 1, 0, -1};

void go(int y, int x) {
    q.push(make_pair(y, x));
    visited[y][x] = 1;

    while (!q.empty()) {
        y = q.front().first;
        x = q.front().second;
        q.pop();
        for (int i = 0; i < 4; i++) {
            int ny = y + dy[i];
            int nx = x + dx[i];
            if (nx < 1 || ny < 1 || nx > M || ny > N) {
                continue;
            }
            if (visited[ny][nx] == 0 && map[ny][nx] == 1) {
                visited[ny][nx] = visited[y][x] + 1;
                q.push(make_pair(ny, nx));
            }
        }

    }

}

int main(void) {
    cin.tie(NULL); cout.tie(NULL); ios_base::sync_with_stdio(false);
    cin >> N >> M;

    for (int i = 1; i <= N; i++) {
        for (int j = 1; j <= M; j++) {
            char c;
            cin >> c;
            map[i][j] = int(c - '0');
        }
    }

    go(1, 1);

    cout << visited[N][M];

    return 0;
}