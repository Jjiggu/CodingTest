#include <iostream>
#include <string>
#include <vector>
#include <algorithm>

using namespace std;

string str1, str2;
int dp[1001][1001];
vector<char> v;

void printCnt() {
    for (int i = 0; i <= str1.length(); i++) {
        for (int j = 0; j <= str2.length(); j++) {
            if (i == 0 || j == 0)
                continue;
            if (str1[i - 1] == str2[j - 1]) {
                dp[i][j] = dp[i - 1][j - 1] + 1;
            } else {
                dp[i][j] = max(dp[i - 1][j], dp[i][j - 1]);
            }
        }
    }
    
    cout << dp[str1.length()][str2.length()];
    cout << "\n";
}

void printStr() {
    int i = str1.length();
    int j = str2.length();

    while(i > 0 && j > 0) {
        if (str1[i - 1] == str2[j - 1]) {
            v.push_back(str1[i - 1]);
            i--;
            j--;
        } else {
            if (dp[i - 1][j] > dp[i][j - 1]) {
                i--;
            } else {
                j--;
            }
        }
    }
    reverse(v.begin(), v.end());

    for (int i = 0; i < v.size(); i++) {
        cout << v[i];
    }

}

int main(void) {
    cin >> str1 >> str2;

    printCnt();
    printStr();
    

    return 0;
}