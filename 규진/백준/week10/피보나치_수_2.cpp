#include <iostream>

using namespace std;

long long arr[91];
int n;

int calculate(int num) {
    return arr[num - 1] + arr[num - 2];
}

int main(void) {
    cin >> n;

    arr[0] = 0;
    arr[1] = 1;

    for (int i = 2; i <= n; i++) {
        arr[i] = arr[i - 1] + arr[i - 2];
    }
    cout << arr[n];

    return 0;
}