#include <iostream>
#include <vector>

using namespace std;

int N;
pair<int, int> input[1500001];
int dp[1500001];


int main(void) {
    cin >> N;
    for (int i = 0; i < N; i++) {
        int a, b;
        cin >> a >> b;
        input[i] = make_pair(a, b);
    }


    cout << dp[N];
    return 0;
}