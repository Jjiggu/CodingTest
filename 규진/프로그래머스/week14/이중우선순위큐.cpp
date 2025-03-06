// #include <iostream>
// #include <string>
// #include <sstream>
// #include <vector>
// #include <queue>

// using namespace std;

// vector<string> split(string input, char delimiter) {
//     stringstream ss(input);
//     string temp = "";
//     vector<string> answer;
//     while (getline(ss, temp, delimiter)) {
//         answer.push_back(temp);
//     }
//     return answer;
// }


// vector<int> solution(vector<string> operations) {
//     vector<int> answer;
//     priority_queue<int> pq;
//     priority_queue<int, vector<int>, greater<int>> lpq;
    
//     int cnt = 0;
//     for (int i = 0; i < operations.size(); i++) {
//         if (operations[i][0] == 'I') {
//             string num = split(operations[i], ' ')[1];
//             pq.push(stoi(num));
//             lpq.push(stoi(num));
//             cnt++;
//         } else if (operations[i].substr(0, 3) == "D -") {
//             if (!lpq.empty()) {
//                 lpq.pop();
//                 cnt--;
//             } else
//                 continue;
//         } else {
//             if (!pq.empty()) {
//                 pq.pop();
//                 cnt--;
//             } else
//                 continue;
//         }
//         if (cnt == 0) {
//             while (!pq.empty())
//                 pq.pop();
//             while (!lpq.empty())
//                 lpq.pop();
//             continue;
//         }
//     }
//     cout << cnt << endl;
//     if (cnt == 0) {
//         answer.push_back(0);
//         answer.push_back(0);
//     } else {
//         answer.push_back(pq.top());
//         answer.push_back(lpq.top());
//     }
    
//     return answer;
// }

// int main(void) {
//     vector<string> t = { "I 10", "I 20", "D 1", "I 30", "I 40", "D -1", "D -1" };
//     vector<int> v = solution(t);
//     for (int i = 0; i < v.size(); i++)
//         cout << v[i] <<  " ";
//     return 0;
// }
#include <string>
#include <vector>
#include <sstream>
#include <algorithm>
#include <functional>
 
using namespace std;

vector<string> split(string input, char delimiter) {
    stringstream ss(input);
    string temp = "";
    vector<string> answer;
    while (getline(ss, temp, delimiter)) {
        answer.push_back(temp);
    }
    return answer;
}


vector<int> solution(vector<string> operations) {
    vector<int> answer;
    vector<int> num;
    for(auto operation: operations) {
        vector<string> oper = split(operation, ' ');
        if(oper[0] == "I") num.push_back(stoi(oper[1]));
        else if(!num.empty() && oper[1] == "1") {
            make_heap(num.begin(), num.end());
            pop_heap(num.begin(), num.end());
            auto max = num.back();
            num.pop_back();
        }
        else if(!num.empty() && oper[1] == "-1") {
            make_heap(num.begin(), num.end(), greater<int>{});
            pop_heap(num.begin(), num.end());
            auto min = num.back();
            num.pop_back();
        }
    }
    if(num.empty()) answer = {0, 0};
    else {
        int max = *max_element(num.begin(), num.end());
        int min = *min_element(num.begin(), num.end());
        answer = {max, min};
    }
    return answer;
}