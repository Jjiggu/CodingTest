#include <iostream>
#include <queue>

using namespace std;

int dy[4] = {-1, 0, 1, 0};
int dx[4] = {0, 1, 0, -1};
queue<pair<int, int>> q;
int N, M;
int map[9][9];
int tempMap[9][9];
int visited[9][9];
int cnt;
pair<int, int> cArr[3];
vector<pair<int, int>> virusList;
vector<pair<int, int>> wallList;

void initValue() {
    for (int i = 0; i < 9; i++) {
        for (int j = 0; j < 9; j++) {
            tempMap[i][j] = 0;
        }
    }

    for (int i = 0; i < N; i++) {
        for (int j = 0; j < M; j++) {
            tempMap[i][j] = map[i][j];
        }
    }
    for (int i = 0; i < 9; i++) {
        for (int j = 0; j < 9; j++) {
            visited[i][j] = 0;
        }
    }
}

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
            if (ny < 0 || nx < 0 || ny >= N || nx >= M)
                continue;
            if (tempMap[ny][nx] == 1)
                continue;
            if (tempMap[ny][nx] == 0 && tempMap[y][x] == 2 && visited[ny][nx] == 0) {
                tempMap[ny][nx] = 2;
                visited[ny][nx] = 1;
                q.push({ny, nx});
            }
        }
    }
}

void combination(int depth, int next) {
    if (depth == 3) {
        initValue();
        int counting = 0;

        for (int i = 0; i < 3; i++) {
            tempMap[cArr[i].first][cArr[i].second] = 1;
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (tempMap[i][j] == 2 && visited[i][j] == 0) {
                    bfs(i, j);
                }
            }
        }
        
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (tempMap[i][j] == 0)
                    counting++;
            }
        }
        if (counting == 46) {

            cout << endl;
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    cout << tempMap[i][j] << " ";
                }
                cout << endl;
            }
        }

        cnt = max(cnt, counting);
        return;
    }

    for (int i = next; i <= wallList.size(); i++) {
        cArr[depth] = wallList[i - 1];
        combination(depth + 1, i + 1);
    }
}

int main(void) {
    cin >> N >> M;
    for (int i = 0; i < N; i++) {
        for (int j = 0; j < M; j++) {
            int num;
            cin >> num;
            map[i][j] = num;
            if (num == 2)
                virusList.push_back({i, j});
            if (num == 0) {
                wallList.push_back({i, j});
            }
        }
    }
    
    combination(0, 1);

    cout << cnt;
    return 0;
}

// 7 7
// 2 1 0 0 1 1 0
// 1 0 1 0 1 2 0
// 0 1 1 0 1 0 0
// 0 1 0 0 0 1 0
// 0 0 0 0 0 1 1
// 0 1 0 0 0 0 0
// 0 1 0 0 0 0 0