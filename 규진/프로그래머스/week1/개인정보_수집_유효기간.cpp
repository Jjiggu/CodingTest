#include <string>
#include <vector>
#include <sstream>
#include <iostream>
#include <map>

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

vector<int> solution(string today, vector<string> terms, vector<string> privacies) {
    vector<int> answer;
    map<string, int> termDateMap;
    for (int i = 0; i < terms.size(); i++) {
        vector<string> splitStr = split(terms[i], ' ');
        termDateMap[splitStr[0]] = stoi(splitStr[1]);
    }
    
    for (int i = 0; i < privacies.size(); i++) {
        vector<string> splitStr = split(privacies[i], ' ');
        string originYear = splitStr[0];
        string term = splitStr[1];
        vector<string> originYearStr = split(originYear, '.');
        
        int orgYear = stoi(originYearStr[0]);
        int orgMonth = stoi(originYearStr[1]);
        string orgDay = originYearStr[2];
        
        int calculateTerm = termDateMap[term];
        int plusYear = calculateTerm / 12;
        int plusMonth = calculateTerm % 12;
        
        int termYear = orgYear + plusYear;
        int termMonth = orgMonth + plusMonth;
        if (termMonth > 12) {
            termYear += 1;
            termMonth -= 12;
        }
        string resultYear = to_string(termYear);
        string resultMonth = to_string(termMonth);
        if (resultMonth.length() == 1) {
            resultMonth = "0" + resultMonth;
        }
        
        string resultStr = resultYear + "." + resultMonth + "." + orgDay;
        if (today >= resultStr) {
            answer.push_back(i + 1);
        }
    }
    
    return answer;
}