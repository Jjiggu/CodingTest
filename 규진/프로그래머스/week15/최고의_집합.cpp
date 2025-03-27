#include <string>
#include <vector>

using namespace std;

vector<int> solution(int n, int s) {
    vector<int> answer;
    while (n != 0) {
        if (n > s) {
            answer.push_back(-1);
            break;
        }
        if (s % n == 0) {
            int mok = s / n;
            for (int i = 0; i < n ; i++) {
                answer.push_back(mok);
            }
            break;
        } else {
            int mok = s / n;
            s -= mok;
            n--;
            answer.push_back(mok);
        }
    }
    
    return answer;
}