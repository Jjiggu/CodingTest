#include <string>
#include <vector>
#include <map>
#include <iostream>

using namespace std;

int scores[7] = {3, 2, 1, 0, 1, 2, 3};

string solution(vector<string> survey, vector<int> choices) {
    string answer = "";
    map<char, int> mbti;
    for (int i = 0; i < survey.size(); i++) {
        string str = survey[i];
        int choice = choices[i];
        mbti[str[choice / 4]] += scores[choice - 1];
    }
    
    answer += mbti['R'] >= mbti['T'] ? "R" : "T";
    answer += mbti['C'] >= mbti['F'] ? "C" : "F";
    answer += mbti['J'] >= mbti['M'] ? "J" : "M";
    answer += mbti['A'] >= mbti['N'] ? "A" : "N";
    
    return answer;
}