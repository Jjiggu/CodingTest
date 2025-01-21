#include <iostream>
#include <algorithm>

using namespace std;

int dp[501];
int stair[501];
int N;

int main(void) {
	cin >> N;
	for (int i = 1; i <= N; i++) {
		cin >> stair[i];
	}

	dp[0] = 0;
	dp[1] = stair[1];
	dp[2] = stair[1] + stair[2];

	for (int i = 3; i <= N; i++) {
		dp[i] = max(dp[i - 3] + stair[i - 1], dp[i - 2]) + stair[i];
	}

	cout << dp[N] << endl;

}