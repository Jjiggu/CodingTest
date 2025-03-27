#include <iostream>
#include <vector>

using namespace std;

const static int INF = 1e6;

int N, M;
int saveMap[51][51];
int tempMap[51][51];
int chickenCnt;
int dy[4] = {-1, 0, 1, 0};
int dx[4] = {0, 1, 0, -1};
vector<pair<int, int>> v;
pair<int, int> comb[14];
int minCnt = INF;

void initMap() {
    for (int i = 0; i < N; i++) {
        for (int j = 0; j < N; j++) {
            tempMap[i][j] = saveMap[i][j];
            if (tempMap[i][j] == 2) {
                tempMap[i][j] = 0;
            }
        }
    }
}

void printMap() {
    for (int i = 0; i < N; i++) {
        for (int j = 0; j < N; j++) {
            cout << tempMap[i][j] << " ";
        }
        cout << endl;
    }
}

void combination(int depth, int next) {
    if (depth == M) {
        initMap();
        int distanceSum = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (tempMap[i][j] == 1) {
                    int distanceMin = INF;
                    for (int k = 0; k < M; k++) {
                        int tempDistance = abs(i - comb[k].first) + abs(j - comb[k].second);
                        distanceMin = min(distanceMin, tempDistance);
                    }
                    distanceSum += distanceMin;
                }
            }
        }
        minCnt = min(minCnt, distanceSum);
    }

    for (int i = next; i < v.size(); i++) {
        comb[depth] = v[i];
        combination(depth + 1, i + 1);
    }
}

int main(void) {
    cin >> N >> M;
    for (int i = 0; i < N; i++) {
        for (int j = 0; j < N; j++) {
            int input;
            cin >> input;
            saveMap[i][j] = input;
            if (input == 2) {
                chickenCnt++;
                v.push_back({i, j});
            }
        }
    }

    combination(0, 0);

    cout << minCnt;

    return 0;
}