#include <string>
#include <vector>
#include <algorithm>

using namespace std;
bool visited[100001];
bool check;

void dfs(string start, vector<vector<string>> tickets, int n, vector<string> &answer) {
    if (n == tickets.size()) {
        check = true;
    }
    answer.push_back(start);
    for (int i = 0; i < tickets.size(); i++) {
        if (!visited[i] && tickets[i][0] == start) {
            visited[i] = true;
            dfs(tickets[i][1], tickets, n + 1, answer);
            if (!check) {
                answer.pop_back();
                visited[i] = false;
            }
        }
    }
}

vector<string> solution(vector<vector<string>> tickets) {
    vector<string> answer;
    sort(tickets.begin(), tickets.end());
    dfs("ICN", tickets, 0, answer);
    return answer;
}