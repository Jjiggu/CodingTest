#include <iostream>
#include <cmath>

using namespace std;

int map[16];
int N, cnt;

void NQueen(int x) {
    if (x == N) {
        cnt++;
    } else {
        for (int i = 0; i < N; i++) {
            map[x] = i;
            bool can = true;
            for (int j = 0; j < x; j++) {
                if (map[x] == map[j] || abs(map[x] - map[j]) == x - j) {
                    can = false;
                    break;
                }
            }
            if (can) {
                NQueen(x + 1);
            }
        }
    }
}

int main(void) {
    cin >> N;
    NQueen(0);
    cout << cnt;
    return 0;
}