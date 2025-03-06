#include <iostream>
#include <stack>

using namespace std;

int N;
string str;

bool check(string s) {
    stack<char> st;
    for (int i = 0; i < s.length(); i++) {
        if (s[i] == '(')
            st.push(s[i]);
        else {
            if (!st.empty())
                st.pop();
            else
                return false;
        }
    }
    return st.empty();
}

int main(void) {
    cin >> N;

    for (int i = 0; i < N; i++) {
        cin >> str;
        if (check(str))
            cout << "YES\n";
        else
            cout << "NO\n";
    }

    return 0;
}