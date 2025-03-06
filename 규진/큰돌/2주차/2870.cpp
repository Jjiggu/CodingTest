#include <iostream>
#include <string>
#include <vector>
#include <algorithm>

using namespace std;

int N;
vector<string> v;

bool comp(string a, string b) {
    if (a.size() == b.size())
		return a < b;
	else
		return a.size() < b.size();
}

string checkDigit(string str) {
    string temp = str;
    while (true) {
        if (temp.size() && temp.front() == '0') {
            temp.erase(temp.begin());
        } else
            break;
    }
    if (temp.size() == 0)
        return "0";
    else
        return temp;
}

int main(void) {
    cin >> N;
    for (int i = 0; i < N; i++) {
        string str;
        cin >> str;
        string temp = "";
        for (int j = 0; j < str.size(); j++) {
            if (str[j] >= '0' && str[j] <= '9') {
                temp += str[j];
                if (str.size() > 0) {
                    if (j == str.size() - 1) {
                        v.push_back(checkDigit(temp));
                    }
                }
            } else {
                if (temp != "") {
                    v.push_back(checkDigit(temp));
                }
                temp = "";
            }
        }
    }

    sort(v.begin(), v.end(), comp);
    for (auto i : v) {
        cout << i << "\n";
    }
    

    return 0;
}