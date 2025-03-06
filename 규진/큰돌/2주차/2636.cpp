#include <iostream>
#include <queue>
#include <vector>

using namespace std;

int N, M;
int map[101][101];
int visited[101][101];
int dy[4] = {-1, 0, 1, 0};
int dx[4] = {0, 1, 0, -1};
int tempMap[101][101];
int cnt, cnt2;
vector<pair<int, int>> v;


void dfs(int a, int b) {
    visited[a][b] = true;

    if (map[a][b] == 1) {
        v.push_back({a, b});
        return;
    }

    for (int i = 0; i < 4; i++) {
        int ny = a + dy[i];
        int nx = b + dx[i];
        if (ny < 0 || nx < 0 || ny >= N || nx >= M)
            continue;
        if (!visited[ny][nx]) {
            visited[ny][nx] = true;
            dfs(ny, nx); 
        }
    }
    return;
}

int main(void) {
    cin >> N >> M;
    for (int i = 0; i < N; i++) {
        for (int j = 0; j < M; j++) {
            int num;
            cin >> num;
            map[i][j] = num;
        }
    }


    while(true) {
        bool flag = 0;
        fill(&visited[0][0], &visited[0][0] + 101 * 101, 0);
        v.clear();
        dfs(0, 0);
        cnt2 = v.size();

        for (pair<int, int> b : v) {
            map[b.first][b.second] = 0;
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] != 0) {
                    flag = 1;
                }
            }
        }
        cnt++;
        if (!flag)
            break;
    }

    cout << cnt << "\n" << cnt2;
    

    return 0;
}