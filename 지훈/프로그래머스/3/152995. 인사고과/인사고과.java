import java.util.*;

class Solution {
    public int solution(int[][] scores) {
        int[] wanho = scores[0];

        // 1. 근무태도 내림차순, 동점일 때 동료평가 오름차순
        Arrays.sort(scores, (a, b) -> {
            if (a[0] != b[0]) return b[0] - a[0];
            return a[1] - b[1];
        });

        int maxPeer = Integer.MIN_VALUE; // 동료 평가 점수 최대값
        List<int[]> valid = new ArrayList<>(); // 인센티브 받을 수 있는 사람 목록

        for (int[] score : scores) {
            if (score[1] < maxPeer) {
                // 탈락 대상
                if (score == wanho) return -1;
                continue;
            }

            maxPeer = Math.max(maxPeer, score[1]);

            valid.add(new int[]{
                score[0] + score[1],  // 총점
                score == wanho ? 1 : 0  // 완호인지 표시
            });
        }

        // 2. 총점 내림차순 정렬
        valid.sort((a, b) -> b[0] - a[0]);

        // 3. 완호의 등수 계산 (동석차 반영)
        int rank = 1;
        int sameCount = 1;
        int prevScore = valid.get(0)[0];

        if (valid.get(0)[1] == 1) return rank;

        for (int i = 1; i < valid.size(); i++) {
            int[] current = valid.get(i);

            if (current[0] == prevScore) {
                sameCount++;
            } else {
                rank += sameCount;
                sameCount = 1;
                prevScore = current[0];
            }

            if (current[1] == 1) return rank;
        }

        return -1; // 이론상 도달 불가
    }
}
