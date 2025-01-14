#include <iostream>

using namespace std;

int map[26][26];
int N, M, ans;
int dy[3] = {-1,0,-1};
int dx[3] = {0,-1,-1};

bool check(int y, int x) {
    int cnt = 0;
    for (int i = 0; i < 3; i++) {
        int ny = y + dy[i];
        int nx = x + dx[i];
        if (ny >= 0 && nx < N && nx >= 0 && nx< M) {
            if (map[ny][nx])
                cnt++;
        }
    }
    if (cnt == 3)
        return false;
    return true;
}


void backTracking(int y, int x) {
    if (x == M && y == N - 1) {
        ans++;
        return;
    }

    if (x == M) {
        x = 0;
        y++;
    }
    map[y][x] = 1;
    if (check(y, x))
        backTracking(y, x + 1);
    map[y][x] = 0;
    backTracking(y, x + 1);

}

int main(void) {

    cin >> N >> M;

    backTracking(0, 0);
    cout << ans;
    return 0;
}
