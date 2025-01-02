#include <iostream>

using namespace std;

int N, M;
int pArr[8];
int check[8];

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

    for (int i = 0; i < N; i++) {
        pArr[depth] = i + 1;
        permutation(depth + 1);
    }
}

int main(void) {
    cin >> N >> M;
    permutation(0);
    return 0;
}