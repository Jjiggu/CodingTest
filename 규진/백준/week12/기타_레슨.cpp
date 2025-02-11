#include <vector>
#include <algorithm>
#include <iostream>
#include <vector>

using namespace std;
int N, M;
vector<int> v;

int main() {
	int low, row = 0;
	cin >> N >> M;
	for (int i = 0; i < N; i++) {
        int num;
        cin >> num;
        v.push_back(num);
		row += num;
	}

    low = *max_element(v.begin(), v.end());

	while (low <= row) {	
		int mid = (low + row) / 2;

		int sum = 0, cnt = 0;
		for (int i = 0; i < N; i++) {
			if (sum + v[i] > mid) {
				sum = 0;
				cnt++;
			}
			sum += v[i];
		}
        
		if (sum != 0) 
            cnt++;

		if (cnt > M) {
			low = mid + 1;
		} else {
			row = mid - 1;
		}
	}
    
	cout << low;
	return 0;
}