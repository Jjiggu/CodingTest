#include <iostream>

using namespace std;
int visited[100];
int n, r;
int pArr[100];

void permutation(int depth) {
    if (depth == r) {
        for (int i = 0; i < r; i++) {
            cout << pArr[i] << " ";
        }
        cout << endl;
        return;
    }

    for (int i = 1; i <= n; i++) {
        if (!visited[i]) {
            visited[i] = 1;
            pArr[depth] = i;
            permutation(depth + 1);
            visited[i] = 0;
        }
    }

}

int main(void) {
    cin >> n >> r;
    permutation(0);
    return 0;
}