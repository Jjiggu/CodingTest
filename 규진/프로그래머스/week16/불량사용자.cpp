#include <string>
#include <vector>
#include <iostream>
#include <set>

using namespace std;
int pArr[10];
bool visited[10];
set<set<string>> s;

bool strCompare(string ban_id, string user_id) {
    int cnt = 0;
    if (ban_id.length() != user_id.length())
        return false;
    
    for (int i = 0; i < ban_id.length(); i++) {
        if (ban_id[i] == '*' || ban_id[i] == user_id[i]) {
            cnt++;
        }
    }
    
    if (cnt == ban_id.length()) {
        return true;
    }
    
    return false;
}

void checkCorrect(vector<string> &user_str, vector<string> &banned_id, set<string> &currentSet) {
    int cnt = 0;
    for(int i = 0; i < banned_id.size(); i++) {
        for (int j = 0; j < user_str.size(); j++) {
            if (i == banned_id.size())
                break;
            bool flag = strCompare(banned_id[i], user_str[j]);
            if (flag) {
                cnt++;
                i++;
            }
        }
    }
    
    if (cnt == banned_id.size()) {
        s.insert(currentSet);
    }
}

void permutation(int depth, int combSize, vector<string> &user_id, vector<string> &banned_id, set<string> &currentSet) {
    vector<string> user_str;
    if (depth == combSize) {
        for (int i = 0; i < combSize; i++) {
            user_str.push_back(user_id[pArr[i]]);
        }
        checkCorrect(user_str, banned_id, currentSet);
    }
    
    for (int i = 0; i < user_id.size(); i++) {
        if (!visited[i]) {
            visited[i] = true;
            pArr[depth] = i;
            currentSet.insert(user_id[i]);
            permutation(depth + 1, combSize, user_id, banned_id, currentSet);
            currentSet.erase(user_id[i]);
            visited[i] = false;
        }
    }
}

int solution(vector<string> user_id, vector<string> banned_id) {
    int answer = 0;
    set<string> currentSet;
    permutation(0, banned_id.size(), user_id, banned_id, currentSet);
    answer = s.size();
    return answer;
