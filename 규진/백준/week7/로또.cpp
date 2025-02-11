#include <iostream>
#include <vector>
#include <algorithm>
#define LOTTO 6

using namespace std;

int arr[7];
vector<int> bucket;

void printArr() {
    for (int i = 0; i < LOTTO; i++) {
        cout << arr[i] << " ";
    }
    cout << endl;
}

void combination(int depth, int next, int loopCnt) {
    if (depth == LOTTO) {
        printArr();
        return;
    }

    for (int i = next; i <= loopCnt; i++) {
        arr[depth] = bucket[i - 1];
        combination(depth + 1, i + 1, loopCnt);
    }

}


int main(void) {
    int n = 1;
    while (true) {
        bucket.clear();
        cin >> n;
        if (n == 0) {
            break;
        }
        for (int i = 0 ; i < n; i++) {
            int a;
            cin >> a;
            bucket.push_back(a);
        }
        sort(bucket.begin(), bucket.end());
        combination(0, 1, n);
        cout << "\n";
    }
    return 0;
}