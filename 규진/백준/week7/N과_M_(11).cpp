#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

int N, M;
int pArr[9];
int check[9];
vector<int> bucket;

void printArr() {
    for (int i = 0; i < M; i++) {
        cout << pArr[i] << " ";
    }
    cout << "\n";
}

void permutation(int depth) {
    if (depth == M) {
        printArr();
        return;
    }
    int before = 0;
    for (int i = 1; i <= N; i++) {
        if (bucket[i - 1] != before) {
            pArr[depth] = bucket[i - 1];
            before = bucket[i - 1];
            permutation(depth + 1);
        }
    }
}

int main(void) {
    cin >> N >> M;
    for (int i = 0; i < N; i++) {
        int a;
        cin >> a;
        bucket.push_back(a);
    }
    sort(bucket.begin(), bucket.end());
    permutation(0);
    return 0;
}