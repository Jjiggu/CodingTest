#include <iostream>
#include <vector>
#include <unordered_map>

using namespace std;

int N, M;
unordered_map<int, int> m;

int main(void) {
	ios::sync_with_stdio(false); cin.tie(0); cout.tie();

    cin >> M;
    for (int i = 0; i < M; i++) {
        int num;
        cin >> num;
        m[num]++;
    }

    cin >> N;
    for (int i = 0; i < N; i++) {
        int findNum;
        cin >> findNum;
        cout << m[findNum] << " ";
    }

    return 0;
}