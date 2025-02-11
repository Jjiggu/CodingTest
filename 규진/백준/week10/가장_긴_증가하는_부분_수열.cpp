#include <iostream>

using namespace std;

int arr[1001];
int dp[1001];
int n, ret;

int main() {
    cin >> n;
    for (int i = 0; i < n; i++) {
        int a;
        cin >> a;
        arr[i] = a;
    }
    for (int i = 0; i < n; i++) {
        int maxValue = 0;
        for (int j = 0; j < i; j++) {
            if (arr[i] > arr[j] && maxValue < dp[j]) {
                maxValue = dp[j];
            }
        }
        dp[i] = maxValue + 1;
        ret = max(ret, dp[i]);
    }
    cout << ret << "\n";
    return 0;
}
