#include <iostream>
#include <stack>
#include <string>

using namespace std;
string str;

bool check(string s) {
    stack<char> st;
    for (char a : s) {
        if (a == '(' || a == '[') {
            st.push(a);
        } else if (a == ')') {
            if (st.empty()) {
                return false;
            }
            if (st.top() == '(')
                st.pop();
            else
                return false;
        } else if (a == ']') {
            if (st.empty()) {
                return false;
            }
            if (st.top() == '[')
                st.pop();
            else return false;
        }
    }
    return st.empty();
}

int main(void) {
    while (true) {
        getline(cin, str);
        if (str[0] == '.') {
            break;
        }
        if (check(str) && str[str.length() - 1] == '.') {
            cout << "yes\n";
        } else {
            cout << "no\n";
        }
    }
    return 0;
}