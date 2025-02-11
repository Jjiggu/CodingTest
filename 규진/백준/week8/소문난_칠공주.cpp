#include <iostream>
#include <queue>

using namespace std;
char map[5][5];
int dy[4] = {-1, 0, 1, 0};
int dx[4] = {0, 1, 0, -1};
int check[5][5];
int answer;
int combination[25];

bool bfs(int index) {
    fill(&check[0][0], &check[4][5], 0);

    queue<pair<int, int> > q;
    int count = 0;

    q.push(make_pair(index / 5, index % 5));
    check[index / 5][index % 5] = 1;

    while (!q.empty()) {
        int y = q.front().first;
        int x = q.front().second;
        q.pop();

        count++;
        if (count == 7)
            return true;
        for (int i = 0; i < 4; i++) {
            int ny = y + dy[i];
            int nx = x + dx[i];
            if (ny < 0 || nx < 0 || ny >= 5 || nx >= 5)
                continue;
            if (!combination[ny * 5 + nx])
                continue;
            if (check[ny][nx]) 
                continue;
            
            q.push(make_pair(ny, nx));
            check[ny][nx] = 1;
        }

    }

    return false;
}

void backTracking(int cnt, int depth, int sCnt) {
    if (cnt == 7) {
        if (sCnt >= 4) {
            if (bfs(depth))
                answer++;
        }
        return;
    }

    for (int i = depth; i < 25; i++) {
        if (combination[i]) 
            continue;

        combination[i] = 1;
        backTracking(cnt + 1, i, sCnt + (map[i / 5][i % 5] == 'S'));
        combination[i] = 0;
    }


}

int main(void) {

    for (int i = 0; i < 5; i++)
        for (int j = 0; j < 5; j++)
            cin >> map[i][j];

    backTracking(0, 0, 0);

    cout << answer;
    return 0;
}