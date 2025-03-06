#include <bits/stdc++.h>
#define MAX 1000001
#define X first
#define Y second

using namespace std;

typedef pair<int, int> pii;

vector<int> solution(vector<string> operations) {
  priority_queue<pii> maxHeap;
  priority_queue<pii, vector<pii>, greater<pii>> minHeap;
  bool exist[MAX];

  for (int i = 0; i < (int)operations.size(); i++) {
    string opcode;
    int n;
    istringstream iss(operations[i]);
    iss >> opcode >> n;
    if (opcode == "I") {
      maxHeap.push({n, i});
      minHeap.push({n, i});
      exist[i] = true;
    } else {
      if (n == 1) {
        while (!maxHeap.empty() && !exist[maxHeap.top().Y])
          maxHeap.pop();
        if (!maxHeap.empty()) {
          exist[maxHeap.top().Y] = false;
          maxHeap.pop();
        }
      } else {
        while (!minHeap.empty() && !exist[minHeap.top().Y])
          minHeap.pop();
        if (!minHeap.empty()) {
          exist[minHeap.top().Y] = false;
          minHeap.pop();
        }
      }
    }
  }

  while (!maxHeap.empty() && !exist[maxHeap.top().Y])
    maxHeap.pop();
  while (!minHeap.empty() && !exist[minHeap.top().Y])
    minHeap.pop();
  if (minHeap.empty() && maxHeap.empty())
    return {0, 0};
  return {maxHeap.top().X, minHeap.top().X};
}