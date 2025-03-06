#include <iostream>

using namespace std;

int N;

int main(void) {
    cin >> N;
    int i = 666;
    for (;;i++) {
        // cout << i << "\n";
        if (to_string(i).find("666") != string::npos)
            N--;
        if (N == 0)
            break;
    }
    cout << i << "\n";
    return 0;
}