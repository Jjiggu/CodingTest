#include <string>
#include <vector>
#include <set>
#include <map>
#include <iostream>

using namespace std;

vector<int> solution(vector<string> gems) {
    vector<int> answer;
    set<string> s;
    map<string, int> m;
    int start = 0, end = 0;
    
    for (int i = 0; i < gems.size(); i++)
        s.insert(gems[i]);
    
    for (auto i : gems) {
        m[i]++;
        if (m.size() == s.size()) {
            break;
        }
        end++;
    }
    
    // for (auto iter = m.begin(); iter != m.end(); iter++) {
    //     cout << iter->first << " : " << iter->second << endl;
    // }
    
    int m_size = end;

    while (true) {
        int cnt = 0;
        auto key = gems[start];
        m[key]--;
        for (auto iter = m.begin(); iter != m.end(); iter++) {
            if (iter->second > 0)
                cnt++;
        }
        
        if (cnt != s.size()) {
            break;
        } else {
            m_size = cnt;
            start++;
        }
    }
    start = start + 1;
    end = end + 1;
    
    answer.push_back(start);
    answer.push_back(end);
    
    return answer;
}