#include <string>
#include <vector>
#include <algorithm>

using namespace std;

bool cmp(int a, int b) {
    return a > b;
}

int solution(vector<int> A, vector<int> B) {
    int answer = 0;
    int a_len = 0;
    sort(A.begin(), A.end());
    sort(B.begin(), B.end());
    for (int i = 0; i < B.size(); i++) {
        if (A[a_len] < B[i]) {
            answer++;
            a_len++;
        }
    }
    return answer;
}