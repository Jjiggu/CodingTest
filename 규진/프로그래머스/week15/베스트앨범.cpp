#include <string>
#include <vector>
#include <map>
#include <iostream>
#include <algorithm>

using namespace std;
map<string, int> m;

struct Music {
    string genre;
    int plays;
    int num;
};

bool cmp (Music a, Music b) {
    if (a.genre == b.genre) {
        if (a.plays == b.plays) {
            return a.num < b.num;
        }
        return a.plays > b.plays;  // 재생 횟수가 많은 순서로 정렬
    }
    return m[a.genre] > m[b.genre];  // 장르의 총 재생 횟수가 많은 순서로 정렬
}

bool cmp2(pair<string, int> a, pair<string, int> b) {
    return a.second > b.second;
}

vector<int> solution(vector<string> genres, vector<int> plays) {
    vector<int> answer;
    vector<pair<string, int>> temp;
    vector<Music> music;
    
    for (int i = 0; i < genres.size(); i++) {
        m[genres[i]] += plays[i];
    }
    
    for (auto iter = m.begin(); iter != m.end(); iter++) {
        temp.push_back({iter->first, iter->second});
    }
    
    sort(temp.begin(), temp.end(), cmp2);
    
    for (int i = 0; i < genres.size(); i++) {
        music.push_back({genres[i], plays[i], i});
    }
    
    sort(music.begin(), music.end(), cmp);
    
    for (int i = 0; i < temp.size(); i++) {
        int count = 0;
        for (int j = 0; j < music.size(); j++) {
            if (temp[i].first == music[j].genre) {
                count++;
                answer.push_back(music[j].num);
            }
            if (count == 2)
                break;
        }
    }
    
    return answer;
}