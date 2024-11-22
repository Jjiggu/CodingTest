#include <vector>
#include <iostream>
#include <stack>
#include <algorithm>

using namespace std;

vector<int> solution(vector<int> arr)
{
    vector<int> answer;
    stack<int> st;
    if (arr.size() <= 0) {
        return answer;
    }

    st.push(arr[0]);

    for (int i = 1; i < arr.size(); i++) {
        int num = st.top();
        if (num == arr[i]) {
            continue;
        } else {
            st.push(arr[i]);
        }
    }

    while (!st.empty()) {
        answer.push_back(st.top());
        st.pop();
    }

    reverse(answer.begin(), answer.end());

    return answer;
}