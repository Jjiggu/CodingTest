#include <string>
#include <vector>
#include <stack>
#include <iostream>

using namespace std;
stack<int> basket;

int calculateBasket() {
    if (basket.size() < 2) {
        return 0;
    }

    int first = basket.top();
    basket.pop();
    int second = basket.top();

    if (first == second) {
        basket.pop();
        return 2;
    } else {
        basket.push(first);
        return 0;
    }
}

int solution(vector<vector<int>> board, vector<int> moves) {
    int answer = 0;
    
    for (int move = 0; move < moves.size(); move++) {
        for (int i = 0; i < board.size(); i++) {
            if (board[i][moves[move] - 1] != 0) {
                basket.push(board[i][moves[move] - 1]);
                board[i][moves[move] - 1] = 0;
                answer += calculateBasket();
                break;
            }
        }
    }
    return answer;
}

