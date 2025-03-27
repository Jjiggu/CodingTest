#include <string>
#include <vector>
#include <algorithm>
#include <iostream>

using namespace std;
bool binarySearch(int n, int k, vector<int> stones) {
    int cnt = 0;
    for (int i = 0; i < stones.size(); i++) {
        if (n >= stones[i])
            cnt++;
        else
            cnt = 0;
        if (cnt >= k) {
            return false;
        }
    }
    return true;
}

int solution(vector<int> stones, int k) {
    int answer = 0;
    int left = 1;
    int right = *max_element(stones.begin(), stones.end());
    
    while (left <= right) {
        int mid = (left + right) / 2;
        if (binarySearch(mid, k, stones)) {
            left = mid + 1;
        } else {
            right = mid - 1;
        }
    }
    answer = left;
    return answer;
}