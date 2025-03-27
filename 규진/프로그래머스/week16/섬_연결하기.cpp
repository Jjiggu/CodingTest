#include <string>
#include <vector>
#include <algorithm>

using namespace std;

int findParent(vector<int> &parent, int x) {
    if (parent[x] == x)
        return x;
    else
        return findParent(parent, parent[x]);
}

void unionParent(vector<int> &parent, int a, int b) {
    int root_a = findParent(parent, a);
    int root_b = findParent(parent, b);
    
    if (root_a < root_b) {
        parent[root_b] = root_a;
    } else {
        parent[root_a] = root_b;
    }
    
}

bool findSameParent(vector<int> &parent, int a, int b) {
    int root_a = findParent(parent, a);
    int root_b = findParent(parent, b);
    
    if (root_a == root_b)
        return true;
    else
        return false;
}

bool comp(vector<int> a, vector<int> b) {
    return a[2] < b[2];
}

int solution(int n, vector<vector<int>> costs) {
    int answer = 0;
    vector<int> parent(n);
    
    sort(costs.begin(), costs.end(), comp);
    
    for (int i = 0; i < n; i++)
        parent[i] = i;
    
    for (int i = 0; i < costs.size(); i++) {
        if (!findSameParent(parent, costs[i][0], costs[i][1])) {
            unionParent(parent, costs[i][0], costs[i][1]);
            answer += costs[i][2];
        }
    }
    
    
    
    return answer;
}