#include <iostream>
#include <vector>

using namespace std;

int dp[101][100001];
vector<pair<int ,int> > v;
int N, K;

int main(void) {
    cin >> N >> K;
    for (int i = 0; i < N; i++) {
        int W, V;
        cin >> W >> V;
        v.push_back(make_pair(W, V));
    }

    for (int i = 1; i <= N; i++) {
        for (int j = 1; j <= K; j++) {
            if (j - v[i - 1].first >= 0) {
                dp[i][j] = max(dp[i - 1][j], v[i - 1].second + dp[i - 1][j - v[i - 1].first]);
            } else {
                dp[i][j] = dp[i - 1][j];
            }
        }
    }

    cout << dp[N][K];

    return 0;
}