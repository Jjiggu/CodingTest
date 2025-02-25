#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

vector<int> v;
int M, N;

int main(void) {
    cin >> M >> N;
    for (int i = 0; i < N; i++) {
        int input;
        cin >> input;
        v.push_back(input);
    }

    sort(v.begin(), v.end());

    if (M < N) {
        cout << v[N - M];
    } else {
        int low = 1;
        int high = v[v.size() - 1];
        int max = 0;
        while (low <= high) {
            int nephew = 0;
            int mid = (low + high) / 2;
            for (int i = 0; i < N; i++) {
                nephew += v[i] / mid;
            }
            if (nephew < M) {
                high = mid - 1;
            } else {
                max = mid;
                low = mid + 1;
            }
        }
        cout << max;
    }

    return 0;
}