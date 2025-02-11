#include <iostream>

using namespace std;

int dp[10001];
int w[10001];

int main(void){
    int n;

    cin >> n;

    for(int i = 1; i <= n; i++){
        int x;
        cin >> x;
        w[i] = x;
    }

    dp[1] = w[1];
    dp[2] = w[1] + w[2];

    for (int i = 3; i <= n; i++) {
        dp[i] = max(dp[i - 1], max(dp[i - 3] + w[i] + w[i - 1], dp[i - 2] + w[i]));
    }

    cout << dp[n];

    return 0;
}