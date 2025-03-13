#include <iostream>
#include <vector>
#include <algorithm>
#include <queue>

using namespace std;

int N, M;
int map[51][51];
vector<pair<int, int> > v;
pair<int, int> cArr[2501];
int maxCnt;
int visited[51][51];
int dy[4] = {-1, 0, 1, 0};
int dx[4] = {0, 1, 0, -1};


void initValue() {
    fill(&visited[0][0], &visited[0][0] + 51 * 51, 0);
}

void bfs(int y, int x) {
    initValue();
    queue<pair<int, int> > q;
    visited[y][x] = 1;
    q.push(make_pair(y, x));
    while (!q.empty()) {
        int a = q.front().first;
        int b = q.front().second;
        q.pop();
        for (int i = 0; i < 4; i++) {
            int ny = a + dy[i];
            int nx = b + dx[i];
            if (ny < 0 || nx < 0 || ny >= N || nx >= M)
                continue;
            if (!visited[ny][nx] && map[ny][nx] == 1) {
                visited[ny][nx] = visited[a][b] + 1;
                q.push(make_pair(ny, nx));
                maxCnt = max(maxCnt, visited[ny][nx]);
            }
        }
    }
}

int main(void) {
    cin >> N >> M;
    cout.tie(0); cin.tie(0); ios_base::sync_with_stdio(false);
    for (int i = 0; i < N; i++) {
        for (int j = 0; j < M; j++) {
            char c;
            cin >> c;
            if (c == 'W') {
                map[i][j] = 0;
            } else if (c == 'L') {
                map[i][j] = 1;
            }
        }
    }

    for (int i = 0; i < N; i++) {
        for (int j = 0; j < M; j++) {
            if (map[i][j] == 1) {
                bfs(i, j);
            }
        }
    }

    cout << maxCnt - 1 << "\n";

    return 0;
}