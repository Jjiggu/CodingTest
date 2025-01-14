#include <iostream>
#include <cmath>

using namespace std;
int N;
int egg[8][2];
int answer;

void backTracking(int index) {
    if (index == N) {
        int cnt = 0;
        for (int i = 0; i < N; i++) {
            if (egg[i][0] <= 0)
                cnt++;
        }
        answer = max(answer, cnt);
        return;
    }

    if (egg[index][0] <= 0)
        backTracking(index + 1);
    else {
        bool check = false;
        for (int i = 0; i < N; i++) {
            if (index == i || egg[i][0] <= 0)
                continue;
            egg[i][0] -= egg[index][1];
            egg[index][0] -= egg[i][1];
            check = true;
            backTracking(index + 1);
            egg[i][0] += egg[index][1];
            egg[index][0] += egg[i][1];
        }

        if (!check)
            backTracking(N);
    }

}

int main(void) {
    cin >> N;

    for (int i = 0; i < N; i++) {
        cin >> egg[i][0] >> egg[i][1];
    }
    backTracking(0);
    cout << answer;
    return 0;
}