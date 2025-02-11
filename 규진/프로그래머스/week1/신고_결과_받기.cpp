#include <string>
#include <vector>
#include <map>
#include <set>
#include <sstream>
#include <iostream>

using namespace std;

vector<string> split(string str, char delimeter) {
    vector<string> answer;
    stringstream ss(str);
    string temp;
    
    while (getline(ss, temp, delimeter)) {
        answer.push_back(temp);
    }
    
    return answer;
}


vector<int> solution(vector<string> id_list, vector<string> report, int k) {
    vector<int> answer(id_list.size(), 0);
    map<string, int> idMap;
    map<string, set<string>> reportMap;
    
    for (int i = 0; i < id_list.size(); i++) {
        idMap[id_list[i]] = i;
    }
    
    for (int i = 0; i < report.size(); i++) {
        vector<string> message = split(report[i], ' ');
        string sender = message[0];
        string receiver = message[1];
        reportMap[receiver].insert(sender);
    }
    
    for (auto i_iter : reportMap) {
        if (i_iter.second.size() >= k) {
            for (auto j_iter : i_iter.second) {
                answer[idMap[j_iter]]++;
            }
        }
    }
    
    return answer;
}