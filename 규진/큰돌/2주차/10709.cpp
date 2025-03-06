#include <iostream>

using namespace std;

int H, W;
char arr[101][101];
int answerArr[101][101];

void checkArr() {
    for (int i = 0; i < H; i++) {
        int temp = 0;
        bool flag = false;
        for (int j = 0; j < W; j++) {
            if (arr[i][j] == 'c') {
                flag = true;
                temp = 0;
            }
            if (flag) {
                if (arr[i][j] == 'c')
                    answerArr[i][j] = 0;
                else
                    answerArr[i][j] = temp;
                    
                temp++;
            } else {
                answerArr[i][j] = -1;
            }
        }
    }
}

int main(void) {
    cin >> H >> W;
    for (int i = 0; i < H; i++) {
        for (int j = 0; j < W; j++) {
            char c;
            cin >> c;
            arr[i][j] = c;
        }
    }
    checkArr();


    for (int i = 0; i < H; i++) {
        for (int j = 0; j < W; j++) {
            cout << answerArr[i][j] << " ";
        }
        cout << "\n";
    }


    return 0;
}