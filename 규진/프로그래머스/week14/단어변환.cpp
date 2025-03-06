#include <string>
#include <vector>
#include <iostream>

using namespace std;
int visited[51];
int answer = 51;

void dfs(string word, vector<string> words, string target, int step) {
    if(answer <= step)
        return;
    if (word == target) {
        answer = min(answer,step);
        return;
    }
    for (int i = 0; i < words.size(); i++) {
        int cnt = 0;
        for (int j = 0; j < words[i].size(); j++) {
            if (words[i][j] == word[j])
                cnt++;
            if (words[i].size() - 1 == cnt && !visited[i]) {
                visited[i] = 1;
                dfs(words[i], words, target, step + 1);
                visited[i] = 0;
            }
        }
    }
}

int solution(string begin, string target, vector<string> words) {
    dfs(begin, words, target, 0);

    if(answer == 51)
        return 0;

    return answer;
}