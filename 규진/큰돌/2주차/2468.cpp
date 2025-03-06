#include <iostream>

using namespace std;

int N, maxNum;
int map[101][101];
int tempMap[101][101];
int visited[101][101];
int dy[4] = {-1, 0, 1, 0};
int dx[4] = {0, 1, 0, -1};
int tempSafety;
int maxSafety;

void dfs(int y, int x) {
    visited[y][x] = 1;
    for (int i = 0; i < 4; i++) {
        int ny = y + dy[i];
        int nx = x + dx[i];
        if (ny < 0 || nx < 0 || ny >= N || nx >= N)
            continue;
        if (!visited[ny][nx] && tempMap[ny][nx] > 0) {
            dfs(ny, nx);
        }
    }
}

void initVar() {
    for (int i = 0; i < 101; i++) {
        for (int j = 0; j < 101; j++) {
            visited[i][j] = 0;
        }
    }
    tempSafety = 0;
}

int main(void) {
    cin >> N;
    for (int i = 0; i < N; i++) {
        for (int j = 0; j < N; j++) {
            int num;
            cin >> num;
            map[i][j] = num;
            maxNum = max(num, maxNum);
        }
    }

    for (int i = 0; i < maxNum; i++) {
        for (int j = 0; j < N; j++) {
            for (int k = 0; k < N; k++) {
                tempMap[j][k] = map[j][k] - i;
            }
        }
        for (int j = 0; j < N; j++) {
            for (int k = 0; k < N; k++) {
                if (!visited[j][k] && tempMap[j][k] > 0) {
                    dfs(j, k);
                    tempSafety++;
                }
            }
        }
        maxSafety = max(maxSafety, tempSafety);
        initVar();
    }
    cout << maxSafety;

    return 0;
}