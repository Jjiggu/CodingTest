#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

int N, M;
vector<long long> v;

int main(void) {
    cin >> N >> M;
    for (int i = 0; i < N; i++) {
        long long num;
        cin >> num;
        v.push_back(num);
    }
    sort(v.begin(), v.end());
    long long sum = 0;
    long long low = 0;
    long long high = v[v.size() - 1];
    long long max = 0;

    while(low <= high) {
        sum = 0;
        long long mid = (low + high) / 2;
        for (int i = 0; i < N; i++) {
            if (v[i] - mid > 0)
                sum += v[i] - mid;
        }
        if (sum >= M) {
            max = mid;
            low = mid + 1;
        } else {
            high = mid - 1;
        }
    }
    cout << max;
    return 0;
}