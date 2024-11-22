#include <string>
#include <vector>
#include <iostream>
#include <sstream>
#include <algorithm>

int presentMap[51][51];
int PDP[51][3];

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


int solution(vector<string> friends, vector<string> gifts) {
    int answer = 0;
    
    for (int i = 0; i < friends.size(); i++) {
        for (int j = 0; j < gifts.size(); j++) {
            vector<string> giftStr = split(gifts[j], ' ');
            string sender = giftStr[0];
            string receiver = giftStr[1];
            if (sender == friends[i]) {
                for (int k = 0; k < friends.size(); k++) {
                    if (receiver == friends[k]) {
                        presentMap[i][k] += 1;
                    }
                }
            }
        }
    }
    
    for (int i = 0; i < friends.size(); i++) {
        for (int j = 0; j < friends.size(); j++) {
            if (i == j) {
                continue;
            }
            PDP[i][0] += presentMap[i][j];
        }
    }
    
    
    for (int i = 0; i < friends.size(); i++) {
        for (int j = 0; j < friends.size(); j++) {
            if (i == j) {
                continue;
            }
            PDP[i][1] += presentMap[j][i];
        }
    }
    
    for (int i = 0; i < friends.size(); i++) {
        PDP[i][2] = PDP[i][0] - PDP[i][1];
    }
    
    int maxCnt = 0;
    for (int i = 0; i < friends.size(); i++) {
        int cnt = 0;
        for (int j = 0; j < friends.size(); j++) {
            if (i == j)
                continue;
            
            if (presentMap[i][j] > 0 || presentMap[j][i] > 0) {
                if (presentMap[i][j] > presentMap[j][i]) {
                    cnt++;
                }
            }
            
            if (presentMap[i][j] == presentMap[j][i]) {
                if (PDP[i][2] > PDP[j][2]) {
                    cnt++;
                } else {
                    cnt += 0;
                }
            }
        }
        maxCnt = max(maxCnt, cnt);
    }
    answer = maxCnt;
    
    
    return answer;
}