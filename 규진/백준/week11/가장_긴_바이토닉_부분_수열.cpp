#include <iostream>

using namespace std;

int N;
int arr[1001];
int upDp[1001];
int downDp[1001];

int main(void) {
    cin >> N;
    for (int i = 0; i < N; i++) {
        cin >> arr[i];
    }

    for (int i = 0; i < N; i++) {
        upDp[i] = 1;
        for (int j = 0; j < i; j++) {
            if (arr[i] > arr[j]) {
                upDp[i] = max(upDp[i], upDp[j] + 1);
            }
        }
    }  

    for (int i = N - 1; i >= 0; i--) {
        downDp[i] = 1;
        for (int j = N - 1; j >= i; j--) {
            if (arr[i] > arr[j]) {
                downDp[i] = max(downDp[i], downDp[j] + 1);
            }
        }
    }

    int maxNum = 0;
    for (int i = 0; i < N; i++) {
        maxNum = max(maxNum, upDp[i] +downDp[i]);
    }
    cout << maxNum - 1;

    return 0;
}