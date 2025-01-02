#include <iostream>

using namespace std;

int N, M;
int cArr[8];

void printArr() {
    for (int i = 0; i < M; i++) {
        cout << cArr[i] << " ";
    }
    cout << "\n";
}

void combination(int depth, int next) {
    if (depth == M) {
        printArr();
        return;
    }

    for (int i = next; i <= N; i++) {
        cArr[depth] = i;
        combination(depth + 1, i);
    }

}

int main(void) {
    cin >> N >> M;
    combination(0, 1);
    return 0;
}