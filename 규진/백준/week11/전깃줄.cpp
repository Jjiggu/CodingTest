#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

int N;
vector<pair<int, int> > v;
int dp[101];

bool comp(pair<int, int> a, pair<int, int> b) {
    return a.first < b.first;
}

int main(void) {
    cin >> N;
    for (int i = 0; i < N; i++) {
        int first, second;
        cin >> first >> second;
        v.push_back(make_pair(first, second));
    }

    sort(v.begin(), v.end(), comp);

    int maxCnt = 0;
    for (int i = 0; i < N; i++) {
        dp[i] = 1;
        for (int j = 0; j < i; j++) {
            if (v[i].second > v[j].second)
                dp[i] = max(dp[i], dp[j] + 1);
                maxCnt = max(maxCnt, dp[i]);
        }
    }
    cout << N - maxCnt;
    return 0;
}