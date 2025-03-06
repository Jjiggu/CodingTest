#include <iostream>

using namespace std;

int n, r;
int cArr[100];

void combination(int depth, int next) {
    if (depth == r) {
        for (int i = 0; i < r; i++) {
            cout << cArr[i] << " ";
}
        cout << endl;
        return;
    }
    
    for (int i = next; i <= n; i++) {
        cArr[depth] = i;
        combination(depth + 1, i + 1);
    }
}

int main(void) {
    cin >> n >> r;
    combination(0, 1);
    return 0;
}