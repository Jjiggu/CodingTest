#include <string>
#include <vector>
#include <algorithm>
#include <iostream>

using namespace std;
bool cmp(vector<int> a, vector<int> b) {
    return a[0] < b[0];
}

int solution(vector<vector<int>> routes) {
    int answer = 1;
    
    sort(routes.begin(), routes.end(), cmp);
    
    int pos = routes[0][1];
    
    for (int i = 1; i < routes.size(); i++) {
        if (routes[i][1] < pos)
            pos = routes[i][1];
        else if (routes[i][0] > pos) {
            answer++;
            pos = routes[i][1];
        }
    }
    
    return answer;
}