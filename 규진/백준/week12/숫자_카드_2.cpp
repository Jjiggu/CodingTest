#include <iostream>
#include <vector>
#include <map>

using namespace std;

int N, M;
map<int, int> m;
vector<pair<int, int>> v;

void binarySearch(int target) {
    int low = 0;
    int high = v.size() - 1;
    while (low <= high) {
        int mid = (low + high) / 2;
        if (v[mid].first == target) {
            cout << v[mid].second << " ";
            return;
        }
        if (v[mid].first < target) {
            low = mid + 1;
        } else {
            high = mid - 1;
        }
    }
    cout << "0" << " ";
}

int main(void) {
	ios::sync_with_stdio(false); cin.tie(0); cout.tie();

    cin >> M;
    for (int i = 0; i < M; i++) {
        int num;
        cin >> num;
        m[num]++;
    }

    for (auto iter = m.begin(); iter != m.end(); iter++) {
        v.push_back({iter->first, iter->second});
    }

    cin >> N;
    for (int i = 0; i < N; i++) {
        int findNum;
        cin >> findNum;
        binarySearch(findNum);
    }

    return 0;
}