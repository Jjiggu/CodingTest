#include <iostream>
#include <vector>
#include <queue>

using namespace std;

int dist[100001];
int visited[100001];
int N, K;
priority_queue<pair<int,int>,vector<pair<int,int> >,greater<pair<int,int> > >pq;

void soombak(int time, int num, int orgNum) {
    if (num >= 0 && num <= 100000 && !visited[num]) {
        if (num == orgNum * 2) {
            pq.push({time, num});
        } else {
            pq.push({time + 1, num});
        }
    }
}

void bfs() {
    pq.push({0, N});
    while (!pq.empty()) {
        int time = pq.top().first;
        int x = pq.top().second;
        // cout << x << endl;
        pq.pop();
        visited[x] = 1;

        if (x < 0 || x > 100000)
            continue;
        if (x == K) {
            cout << time;
            break;
        }
        soombak(time, x - 1, x);
        soombak(time, x + 1, x);
        soombak(time, x * 2, x);
    }
}

int main(void) {
    cin >> N >> K;
    bfs();
    return 0;
}