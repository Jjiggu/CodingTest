#include <iostream>

using namespace std;

long long arr[1000001];
int N;

int main(void) {
    cin >> N;
    arr[1] = 1;
    arr[2] = 2;
    for (int i = 3; i <= N; i++) {
        arr[i] = (arr[i - 1] + arr[i - 2]) % 15746;
    }
    cout << arr[N];
    return 0;
}