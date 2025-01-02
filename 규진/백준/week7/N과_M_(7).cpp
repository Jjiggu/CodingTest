#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

int N, M;
int pArr[8];
int check[8];
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

    for (int i = 1; i <= N; i++) {
        pArr[depth] = bucket[i - 1];
        permutation(depth + 1);
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