#include <iostream>

using namespace std;

int x, y, z;
long long arr[51][51][51];

bool checkMinus(int a, int b, int c) {
    if (a == -1 && b == -1 && c == -1) {
        return true;
    }
    return false;
}

int w(int a, int b, int c) {
    if (a <= 0 || b <= 0 || c <= 0)
        return 1;
    else if (arr[a][b][c] != 0)
        return arr[a][b][c];
    else if (a > 20 || b > 20 || c > 20)
        return w(20, 20, 20);
    else if (a < b && b < c)
        arr[a][b][c] = w(a, b, c-1) + w(a, b-1, c-1) - w(a, b-1, c);
    else
        arr[a][b][c] = w(a-1, b, c) + w(a-1, b-1, c) + w(a-1, b, c-1) - w(a-1, b-1, c-1);
    return arr[a][b][c];
}


int main(void) {

    while (true) {
        cin >> x >> y >> z;
        if (checkMinus(x, y, z))
            break;
        cout << "w(" << x << ", " << y << ", " << z << ")" << " = " << w(x, y, z) << "\n";
    }

    return 0;
}