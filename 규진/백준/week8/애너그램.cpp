#include <iostream>
#include <string>
#include <vector>
#include <algorithm>

using namespace std;

int N;
int check[21];
char arr[21];
vector<char> v;

void initValue() {
    v.clear();
    for (int i = 0; i < 21; i++) {
        check[i] = false;
        arr[i] = '0';
    }
}


void permutation(int depth) {
    if (depth == v.size()) {
        for (int i = 0; i < v.size(); i++) {
            cout << arr[i];
        }
        cout << "\n";
    }

    char before = '0';
    for (int i = 0; i < v.size(); i++) {
        if (!check[i] && v[i] != before) {
            arr[depth] = v[i];
            before = v[i];
            check[i] = true;
            permutation(depth + 1);
            check[i] = false;
        }
    }
}

int main() {
    cin >> N;

    for (int i = 0; i < N; i++) {
        initValue();
        string s;
        cin >> s;
        for (int j = 0; j < s.size(); j++) {
            v.push_back(s[j]);
        }
        sort(v.begin(), v.end());
        permutation(0);
    }

    return 0;
} 