#include <iostream>
#include <queue>
#include <vector>

using namespace std;
int map[51][51];
int N, L, R;
int visited[51][51];
int dy[4] = {-1, 0, 1, 0};
int dx[4] = {0, 1, 0, -1};
int sum;
int cnt;
vector<pair<int, int> > v;

void initValue() {
    fill(&visited[0][0], &visited[0][0] + 51 * 51, 0);
}

void dfs(int y, int x, vector<pair<int, int> > &v) {
    for (int i = 0; i < 4; i++) {
        int ny = y + dy[i];
        int nx = x + dx[i];
        if (nx < 0 || ny < 0 || ny >= N || nx >= N)
            continue;
        if ((abs(map[ny][nx] - map[y][x]) >= L && abs(map[ny][nx] - map[y][x]) <= R)
                && !visited[ny][nx]) {
            visited[ny][nx] = 1;
            v.push_back(make_pair(ny, nx));
            sum += map[ny][nx];
            dfs(ny, nx, v);
        }
    }

}


int main(void) {

    cin >> N >> L >> R;

    for (int i = 0; i < N; i++) {
        for (int j = 0; j < N; j++) {
            int input;
            cin >> input;
            map[i][j] = input;
        }
    }

    while (true) {
        bool flag = false;
        initValue();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (!visited[i][j]) {
                    v.clear();
                    visited[i][j] = 1;
                    v.push_back(make_pair(i, j));
                    sum = map[i][j];
                    dfs(i, j, v);
                    if (v.size() == 1)
                        continue;
                    for (pair<int, int> a : v) {
                        map[a.first][a.second] = sum / v.size();
                        flag = 1;
                    }
                }
            }
        }
        if (!flag)
            break;
        cnt++;
    }

    cout << cnt << "\n";

    return 0;
}