#include <iostream>
#include <vector>

using namespace std;
int T, n, cnt;
int student[100001];
int visited[100001];
int matching[100001];

void initStudent() {
    fill(student, student + 100001, 0);
    fill(visited, visited + 100001, 0);
    fill(matching, matching + 100001, 0);
    cnt = 0;
}

void studentDFS(int num) {
    visited[num] = 1;
    int chosenStudent = student[num];
    if (visited[chosenStudent] == 0) {
        studentDFS(chosenStudent);
    } else if (matching[chosenStudent] == 0) {
        for (int i = chosenStudent; i != num; i = student[i]) {
            cnt++;
        }
        cnt++;
    }
    matching[num] = 1;
}

int main(void) {
    cin >> T;
    for (int i = 0; i < T; i++) {
        initStudent();

        int sNum;
        cin >> sNum;

        for (int j = 1; j <= sNum; j++) {
            cin >> student[j];
        }

        for (int j = 1; j <= sNum; j++) {
            if (visited[j] == 0) {
                studentDFS(j);
            }
        }
        cout << sNum - cnt << endl;
    }
    return 0;
}