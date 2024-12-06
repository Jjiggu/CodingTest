#include <iostream>
#include <queue>

using namespace std;

int N, K;
int dist[100001];
queue<int> q;

void soombak(int num, int orgNum) {
    if (num >= 0 && num <= 100000 && dist[num] == 0) {
        dist[num] = dist[orgNum] + 1;
        q.push(num);
    }
}

int main() {
    cin.tie(NULL); cout.tie(NULL); ios::sync_with_stdio(false);
    cin >> N >> K;
    q.push(N);
    while (!q.empty()) {
        int x = q.front();
        q.pop();
        int before = x - 1;
        int after = x + 1;
        int doub = x * 2;

        if (x < 0 || x > 100000)
            continue;

        if (x == K) {
            cout << dist[x];
            break;
        }

        soombak(before, x);
        soombak(after, x);
        soombak(doub, x);

    }
    return 0;
}
